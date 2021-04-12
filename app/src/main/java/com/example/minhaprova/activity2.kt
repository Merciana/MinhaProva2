package com.example.minhaprova

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class activity2 : AppCompatActivity() {
    lateinit var salvarButton: Button
    lateinit var cancelarButton: Button

    lateinit var nomedolivroEditText: EditText
    lateinit var nomedoautorEditText: EditText
    lateinit var anoEditText: EditText
    lateinit var notaRatingBar: RatingBar

    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_activity2)

        salvarButton = findViewById(R.id.salvar)
        cancelarButton = findViewById(R.id.cancelar2)

        nomedolivroEditText = findViewById(R.id.NomedoLivro)
        nomedoautorEditText = findViewById(R.id.NomedoAutor)
        anoEditText = findViewById(R.id.Ano)
        notaRatingBar = findViewById(R.id.Nota)

        cancelarButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        salvarButton.setOnClickListener {
            var nomedolivro = nomedolivroEditText.text
            var nomedoautor = nomedoautorEditText.text
            var ano = anoEditText.text
            var nota = notaRatingBar.rating


            if(!(nomedolivro.isEmpty() || nomedoautor.isEmpty() || ano.isEmpty())){
                var livro = Livro(0, nomedolivro.toString(), nomedoautor.toString(), ano.toString().toInt(), nota)
                var db = LivroDBOpener(this)

                db.insert(livro)

                var i = Intent()
                i.putExtra("resultado", "cadastrado")
                setResult(Activity.RESULT_OK, i)
                finish()
            }else{
                Toast.makeText(this, "Campo Vazio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}