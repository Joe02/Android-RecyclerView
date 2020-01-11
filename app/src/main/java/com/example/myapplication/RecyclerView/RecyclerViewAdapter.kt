package com.example.myapplication.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerViewAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> () {

    var itemClickListener: ItemClickListener? = null

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    class MyViewHolder : RecyclerView.ViewHolder, View.OnClickListener{

        constructor(itemView: View):super(itemView){
            itemView.setOnClickListener(this)
        }

        var number : TextView = itemView.findViewById(R.id.number)


        override fun onClick(v: View?) {
            Log.d("functionalTest", "O item de número "+ adapterPosition+1 + "foi clicado!!!")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.number.text = myDataset[position]
    }
}
