package com.example.playjuegos

import android.os.Bundle
import android.view.Menu
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preferences)

        val toolbar: Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val seekBar: SeekBar = findViewById(R.id.seekBar)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "No has pulsado ninguna opción", Toast.LENGTH_LONG).show()
            } else {
                val radioButton: RadioButton = findViewById(selectedId)
                val mensaje = "Has seleccionado: ${radioButton.text}\n" +
                        "Puntuacion: ${ratingBar.rating}\n"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
