package com.example.navi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculateActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_calculate)
        supportActionBar?.title = "Calculate"

        val input = findViewById<EditText>(R.id.inputNilai)
        val btn = findViewById<Button>(R.id.btnProses)
        val hasil = findViewById<TextView>(R.id.txtHasil)

        btn.setOnClickListener {
            val angka = input.text.toString().toIntOrNull() ?: 0
            hasil.text = "Hasil: ${angka * 2}"
        }
    }
}