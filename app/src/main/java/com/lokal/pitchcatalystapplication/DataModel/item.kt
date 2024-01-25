package com.lokal.pitchcatalystapplication.DataModel

data class Item(
    val title: String? = "",
    val desc: String? = "",
    val _id: String? = "",
    var isSelected: Boolean = false,
    val timestamp: Long? = 0
)