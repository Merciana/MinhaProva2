package com.example.minhaprova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import androidx.lifecycle.ViewModelProvider
import com.example.minhaprova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: VM

    val MY_BOTAO1 = 60
    val MY_BOTAO3 = 80

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(VM::class.java)

        binding.textview1.text = viewModel.text1
        binding.textview2.text = viewModel.text2

        val settings = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        var sinal = settings.getBoolean("flag", true)


        if(sinal){
            Toast.makeText(this, getString(R.string.welcome), Toast.LENGTH_SHORT).show()
            var editSettings = settings.edit()
            editSettings.putBoolean("flag", false)
            editSettings.apply()
        }

        binding.button1.setOnClickListener {
            val i = Intent(this, Actitity1::class.java)
            startActivityForResult(i, MY_BOTAO1)
        }

        binding.button2.setOnClickListener {
            var dialogo = Dialogo()
            dialogo.show(supportFragmentManager, "Dialog")
        }

        binding.button3.setOnClickListener {
            val i = Intent(this, activity2::class.java)
            startActivityForResult(i, MY_BOTAO3)
        }

        binding.button4.setOnClickListener {
            val i = Intent(this, Acao3::class.java)
            startActivity(i)
        }
    }


    override fun onStop() {
        Log.i("PROVA", "onStop () invocado.")
        super.onStop()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            Activity.RESULT_OK -> {
                val resultado = data!!.getStringExtra("resultado")
                when (requestCode) {
                    MY_BOTAO1 -> {
                        binding.textview1.text = resultado
                        viewModel.text1 = resultado.toString()
                    }
                    MY_BOTAO3 -> {
                        binding.textview2.text = resultado
                        viewModel.text2 = resultado.toString()
                    }
                }
            }
            Activity.RESULT_CANCELED -> {
                when (requestCode) {
                    MY_BOTAO1 -> {
                        //var ml = findViewById<View>(R.id.mainlayout)
                    Snackbar.make(binding.mainlayout, "Cancelado", Snackbar.LENGTH_LONG)
                            .setAction("OK"){}.show()
                    }
                    MY_BOTAO3 -> {

                    }
                }
            }
        }
    }


}
