package com.fdlr.listadepaises

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fdlr.listadepaises.model.Item

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
            if (editText?.text.toString() == "") {
                Toast.makeText(this, "Digite um nome de pais.", Toast.LENGTH_SHORT).show()
            } else {
                val resultIntent = this.intent
                resultIntent.putExtra(
                    "item", editText?.text
                )
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
        buttoneCancelar?.setOnClickListener {
            finish()
        }
    }
}