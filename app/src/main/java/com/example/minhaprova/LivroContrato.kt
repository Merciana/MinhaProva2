package com.example.minhaprova

import android.provider.BaseColumns

object LivroContrato {
    const val DATABASE_NAME = "livrodb.sqlite"
    const val DATA_BASE_VERSION = 1

    object LivroEntry : BaseColumns{
        const val TABLE_NAME = "Livro"
        const val NOME_LIVRO = "Nome"
        const val AUTOR = "Autor"
        const val ANO = "Ano"
        const val NOTA = "Nota"
    }

}