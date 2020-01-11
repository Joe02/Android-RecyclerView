package com.example.myapplication.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerViewAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> () {

    //Inicialização da instância da interface ItemClickListener
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

    //Primeira propriedade necessária para a classe Adapter, nela a view é "criada" de acordo com o
    //espaço necessário na tela. Ela retornará uma view (o seu layout) para a classe MyViewHolder tratar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(view)
    }

    //Segunda propriedade necessária para a classe Adapter, retorna a quantidade de elementos de uma lista
    override fun getItemCount(): Int {
        return myDataset.size
    }

    //Terceira propriedade necessária para a classe Adapter, cria o vínculo entre a informação recebida
    //pelo nosso Adapter (no caso, um array de strings) e a View especificada no XML
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.number.text = myDataset[position]
    }
}
