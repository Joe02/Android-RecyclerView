package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.RecyclerView.ItemClickListener
import com.example.myapplication.RecyclerView.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    //A inicialização das seguintes variáveis é respectivamente ligada a manipulação da Recyclerview,
    //manipulação do Adapter da lista e o LayoutManager necessário para a criação da lista.

    private lateinit var recyclerView: RecyclerView
    protected open lateinit var viewAdapter: RecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {

        //Aqui criamos um pequeno array de strings que será utilizado como nossa "data" passada para
        //o adapter, afim de criar uma Row para cada item.
        var data = arrayOf<String>("Um", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Onze")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //O LayoutManager funciona como um gerenciador de layouts da sua RecyclerView, nele é possível
        //"settar" o formato no qual a lista será exibida assim como outras propriedades
        viewManager = LinearLayoutManager(this)

        //Bem como o LayoutManager também precisamos "settar" nosso Adapter, que tem como função a
        //criação de cada Row da nossa lista
        viewAdapter = RecyclerViewAdapter(data)

        //Nessa etapa chamamos a função contida no nosso adapter para tratarmos os click's recebidos
        //pelo listener da nossa lista.
        viewAdapter.setOnItemClickListener(object :
            ItemClickListener {
            override fun onClick(v: View?) {}
            override fun onItemClick(position: Int) {}
        })

        //Aplicando algumas propriedades não necessárias para a formatação da nossa lista
        recyclerView = findViewById<RecyclerView>(R.id.recyclerList).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}
