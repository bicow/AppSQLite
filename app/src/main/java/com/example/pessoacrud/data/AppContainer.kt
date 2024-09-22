package com.example.pessoacrud.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: PessoaDatabase by lazy {
        Room.databaseBuilder(context, PessoaDatabase::class.java, "pessoa_db").build()
    }

    val pessoaRepository: PessoaRepository by lazy {
        PessoaRepository(database.pessoaDao())
    }
}