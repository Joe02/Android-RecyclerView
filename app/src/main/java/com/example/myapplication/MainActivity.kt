package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.RecyclerView.ItemClickListener
import com.example.myapplication.RecyclerView.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    protected open lateinit var viewAdapter: RecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    protected open lateinit var adapter : RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        var data = arrayOf<String>("Um", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Onze")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter =
            RecyclerViewAdapter(data)

        viewAdapter.setOnItemClickListener(object :
            ItemClickListener {
            override fun onClick(v: View?) {}
            override fun onItemClick(position: Int) {}
        })

        recyclerView = findViewById<RecyclerView>(R.id.recyclerList).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}
