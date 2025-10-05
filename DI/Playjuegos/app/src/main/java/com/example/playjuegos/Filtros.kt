package com.example.playjuegos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Filtros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filtros)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val generos = arrayOf("Accion","Aventura","Deportes","Disparos","Estrategia","Lucha","Musical","Rol","Simulación")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, generos)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
    }

}