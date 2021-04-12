package com.example.minhaprova

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Actitity1 : AppCompatActivity() {
    lateinit var okButton: Button
    lateinit var cancelarButton: Button
    lateinit var acao1EditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actitity1)

        okButton = findViewById(R.id.ok)
        cancelarButton = findViewById(R.id.cancelar)
        acao1EditText = findViewById(R.id.editTextTextPersonName)
/*
        val botao:Button = findViewById(R.id.cancelar)
        botao.setOnClickListener {
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            Log.i("PROVA", "cancelamento")
        }

 */
        okButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("resultado", acao1EditText.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        cancelarButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}