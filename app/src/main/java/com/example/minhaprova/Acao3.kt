package com.example.minhaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.minhaprova.databinding.ActivityAcao3Binding

class Acao3 : AppCompatActivity() {

    lateinit var binding:ActivityAcao3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao3)

        val db = LivroDBOpener(this)
        var idChange = 1
        var livro = db.findById(idChange)
        var livros = db.findAll()


        binding.titulo.text = "Título: ${livro.nome}"
        binding.autor.text = "Autor: ${livro.autor}"
        binding.ano.text = "Ano: ${livro.ano}"
        binding.nota2.text = "Nota: ${livro.nota}"

        binding.anterior.setOnClickListener() {

            if(idChange > 1){
                binding.proximo.isEnabled = true
            }

            var livro = db.findById(--idChange)
            binding.apply {

                titulo.text = "Título: ${livro.nome}"
                autor.text = "Autor: ${livro.autor}"
                ano.text = "Ano: ${livro.ano}"
                nota2.text = "Nota: ${livro.nota}"
            }

            if(idChange == 1){
                binding.anterior.isEnabled = false
            }
        }

        binding.proximo.setOnClickListener() {
            var livro = db.findById(++idChange)
            binding.apply {
                titulo.text = "Título: ${livro.nome}"
                autor.text = "Autor: ${livro.autor}"
                ano.text = "Ano: ${livro.ano}"
                nota2.text = "Nota: ${livro.nota}"
            }

            if(idChange == livros.size){
                binding.proximo.isEnabled = false
            }

            if(idChange > 1){
                binding.anterior.isEnabled = true
            }
        }
    }
}