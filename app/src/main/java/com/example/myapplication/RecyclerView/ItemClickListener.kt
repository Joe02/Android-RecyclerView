package com.example.myapplication.RecyclerView

import android.view.View

interface ItemClickListener : View.OnClickListener {
    fun onItemClick(position: Int)
}