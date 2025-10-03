package com.example.playjuegos

import android.os.Bundle
import android.view.Menu
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_games)

        val toolbar: Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val angryBirds = findViewById<CheckBox>(R.id.angryBirds)
        val dragonFly = findViewById<CheckBox>(R.id.dragonFly)
        val hillClimbingRacing = findViewById<CheckBox>(R.id.hillClimbingRacing)
        val radiantDefense = findViewById<CheckBox>(R.id.radiantDefense)
        val pocketSoccer = findViewById<CheckBox>(R.id.pocketSoccer)
        val ninJump = findViewById<CheckBox>(R.id.ninJump)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val selectedGames = mutableListOf<String>()

            if (angryBirds.isChecked) selectedGames.add("Angry Birds")
            if (dragonFly.isChecked) selectedGames.add("Dragon Fly")
            if (hillClimbingRacing.isChecked) selectedGames.add("Hill Climbing Racing")
            if (radiantDefense.isChecked) selectedGames.add("Radiant Defense")
            if (pocketSoccer.isChecked) selectedGames.add("Pocket Soccer")
            if (ninJump.isChecked) selectedGames.add("Ninja Jump")

            if (selectedGames.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Juegos seleccionados: ${selectedGames.joinToString()}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "No has seleccionado ningún juego", Toast.LENGTH_SHORT).show()
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}