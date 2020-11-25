package com.fdlr.listadepaises.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.fdlr.listadepaises.R
import com.fdlr.listadepaises.model.Item

class CountryAdapter(nameList: List<Item>, private var ctx: Context) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    private var nameList: List<Item> = nameList

    // Aqui é onde o viewholder é criado a partir do layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)

    }

    // Nessa parte é onde se modifica o item do viewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = nameList[position]

        holder.name.text = item.name
        holder.imagem.setBackgroundResource(item.img)
    }

    // Devolve quantidade de itens do nameList
    override fun getItemCount(): Int {
        return nameList.size
    }

    // Aqui é a criação dos itens do viewholder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.countryName)
        var imagem = view.findViewById<AppCompatImageView>(R.id.imgAAAA)!!
    }
}
