package com.fdlr.listadepaises

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fdlr.listadepaises.model.Item
import com.fdlr.listadepaises.utils.Constant
import com.fdlr.listadepaises.utils.Constant.ESTADAOWEB
import com.fdlr.listadepaises.utils.Constant.GUMWEB
import com.fdlr.listadepaises.utils.Constant.RSETEWEB

class NomePaises : AppCompatActivity() {
    var buttoneSalvar: Button? = null
    var buttoneCancelar: Button? = null
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nome_paises)
        buttoneSalvar = findViewById(R.id.buttonSave)
        buttoneCancelar = findViewById(R.id.buttonCancel)
        editText = findViewById(R.id.insertCountry)

        buttoneSalvar?.setOnClickListener {
            val nome = editText?.text.toString()
            if (nome == "") {
                Toast.makeText(this, "Digite um nome de site.", Toast.LENGTH_SHORT).show()
            } else {
                getCountry(nome)

            }
        }

        buttoneCancelar?.setOnClickListener {
            finish()
        }
    }

    private fun getCountry(name: String) {
        when (name) {
            Constant.GUM -> MainActivity.items.add(Item(name, R.drawable.gone, GUMWEB))
            Constant.RSETE -> MainActivity.items.add(Item(name, R.drawable.rsete_logo, RSETEWEB))
            Constant.ESTADAO -> MainActivity.items.add(Item(name, R.drawable.estadao, ESTADAOWEB))
            else -> MainActivity.items.add(Item(Constant.SITEDEFAULT, R.drawable.ic_mundi,""))
        }
        navigateToMain()
    }

    private fun navigateToMain() {
        finish()
    }
}