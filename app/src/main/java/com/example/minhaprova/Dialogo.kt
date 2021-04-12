package com.example.minhaprova

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class Dialogo : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var builder = AlertDialog.Builder(activity!!)
                    .setTitle("Pergunta Importante")
                    .setMessage("Gostaria de uma xícara de café?")
                    .setPositiveButton("Sim") {dialog, i ->
                        Toast.makeText(it.baseContext, "Ótimo!", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Não") {dialog, i ->
                        Toast.makeText(it.baseContext, "Fica para a próxima!", Toast.LENGTH_SHORT).show()
                    }
           return builder.create()
        }?: throw IllegalStateException ("Activity not found")
    }
}