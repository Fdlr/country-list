package com.fdlr.listadepaises

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fdlr.listadepaises.adapter.CountryAdapter
import com.fdlr.listadepaises.model.Item
import com.fdlr.listadepaises.utils.Constant.BRASIL
import com.fdlr.listadepaises.utils.Constant.JAPAO
import com.fdlr.listadepaises.utils.Constant.PAISDEFAULT
import com.fdlr.listadepaises.utils.Constant.USA

class MainActivity : AppCompatActivity() {


    var items = ArrayList<Item>()
    var buttonInsert: Button? = null
    var listaAdapter: CountryAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    var list : RecyclerView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonInsert = findViewById(R.id.button_adc)
        list = findViewById(R.id.recyclerView)
        initView()
        
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

    //Buscando os gastos que inseriou na tela Name
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            when(val nome: String = data!!.getStringExtra("nome").toString()){
                BRASIL -> items.add(Item(nome, R.drawable.ic_flag_of_brazil_map))
                USA-> items.add(Item(nome, R.drawable.ic_flag_of_the_united_states))
                JAPAO -> items.add(Item(nome, R.drawable.ic_flag_and_map_of_japan))
                else -> items.add(Item(PAISDEFAULT, R.drawable.ic_mundi))
            }
        }
    }

    override fun onResumeFragments() {
        initView()
        super.onResumeFragments()
    }
}