package com.example.katz.ui.atividades

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.katz.R

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Materia>) : ArrayAdapter<Materia>(context, R.layout.row, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.row, null)
        val imageView: ImageView = view.findViewById(R.id.materia_imagem)
        val materiaLabel: TextView = view.findViewById(R.id.materia)
        val corrigidasLabel: TextView = view.findViewById(R.id.corrigidas)
        val pendentesLabel: TextView = view.findViewById(R.id.pendentes)

        imageView.setImageResource(arrayList[position].imageId)
        materiaLabel.text = arrayList[position].name
        corrigidasLabel.text = arrayList[position].corrigidas
        pendentesLabel.text = arrayList[position].pendentes
        return view
    }
}
