package com.fdlr.listadepaises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.fdlr.listadepaises.model.Item

class MainActivity : AppCompatActivity() {


    var items = ArrayList<Item>()
    var buttonInsert: Button? = null
    var listaAdapter: ListAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonInsert = findViewById(R.id.button_adc)


        
        buttonInsert?.setOnClickListener {
            val intent = Intent(this, NomePaises::class.java)
            startActivityForResult(intent, 1)
        }
    }
}