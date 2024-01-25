package com.lokal.pitchcatalystapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lokal.pitchcatalystapplication.DataModel.Item
import com.lokal.pitchcatalystapplication.R


class ItemAdapter(private val onItemLongClickListener: ((Item) -> Unit)? = null) :
    Adapter<ItemAdapter.ItemViewHolder>() {
    private var mlist: List<Item> = arrayListOf()

    fun setLit(list: List<Item>) {
        mlist = list
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(view: View) : ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleTextView)
        val desc: TextView = view.findViewById(R.id.bodyTextView)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = mlist.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // bind all the data

        val current = mlist[position];
        holder.title.text = current.title
        holder.desc.text = current.desc
        holder.checkBox.isChecked = current.isSelected
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            current.isSelected = isChecked
        }

        holder.itemView.setOnLongClickListener {
            onItemLongClickListener?.invoke(current)
            return@setOnLongClickListener true
        }
    }


    fun getSelectedItems(): List<Item> {
        return mlist.filter { it.isSelected }
    }
}