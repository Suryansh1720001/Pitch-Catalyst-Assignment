package com.lokal.pitchcatalystapplication.ViewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.lokal.pitchcatalystapplication.DataModel.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ItemViewModel : ViewModel() {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val dbRef: CollectionReference = firestore.collection("item")

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    init {
        observeItems()
    }

    private fun observeItems() {
        viewModelScope.launch(Dispatchers.IO) {
            callbackFlow {
                val snapshot = dbRef.orderBy("timestamp", Query.Direction.DESCENDING)
                    .addSnapshotListener { value, error ->
                        if (error == null && value != null) {
                            val items = value.toObjects(Item::class.java)
                            this.trySend(items).isSuccess
                        }
                    }
                awaitClose { snapshot.remove() }
            }.collect { items ->
                _items.postValue(items)
            }
        }
    }

    fun deleteSelectedItems(selectedItems: List<Item>) {
        viewModelScope.launch(Dispatchers.IO) {
            for (item in selectedItems) {
                try {
                    dbRef.document(item._id!!).delete().await()
                } catch (e: Exception) {
                    Log.d("BODY", "Something went wrong")
                }
            }
        }
    }
}
