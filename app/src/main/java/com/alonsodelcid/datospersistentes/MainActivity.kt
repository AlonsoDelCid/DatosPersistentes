package com.alonsodelcid.datospersistentes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leerDatos()

        saveButton.setOnClickListener { guardarDatos() }
        eraseButton.setOnClickListener { borrarDatos() }
    }

    private fun leerDatos(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        val texto = sharedPref.getString(KEY, "")
        textoEditText.setText(texto)
    }

    private fun guardarDatos(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putString(KEY, textoEditText.text.toString())
            commit()
        }
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show()
    }

    private fun borrarDatos(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putString(KEY, "")
            commit()
        }
        Toast.makeText(this, "Datos borrados", Toast.LENGTH_LONG).show()
    }

    companion object{
        const val KEY = "miString"
    }
}