package com.fdlr.listadepaises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fdlr.listadepaises.adapter.CountryAdapter
import com.fdlr.listadepaises.model.Item
import com.fdlr.listadepaises.utils.Constant

class MainActivity : AppCompatActivity() {
    var buttonInsert: Button? = null
    var listaAdapter: CountryAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonInsert = findViewById(R.id.button_adc)
        list = findViewById(R.id.recyclerView)
        initView()
        getCats()

        buttonInsert?.setOnClickListener {
            val intent = Intent(this, NomePaises::class.java)
            startActivityForResult(intent, 1)
        }
    }

    private fun initView() {
        listaAdapter = CountryAdapter(items, this)
        linearLayoutManager = LinearLayoutManager(this)
        list?.layoutManager = linearLayoutManager
        list?.adapter = listaAdapter
    }

    private fun getCats(){
        items.add(Item("Xaropinho", R.drawable.cats_a,""))
        items.add(Item("Ronald", R.drawable.cat_b,""))
        items.add(Item("Canela", R.drawable.cat_c,""))
        items.add(Item("Rambo", R.drawable.cat_d,""))
    }

    override fun onResume() {
        initView()
        super.onResume()
    }

    companion object {
        var items = ArrayList<Item>()
    }
}