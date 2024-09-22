package com.example.pessoacrud.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoa")
data class Pessoa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val idade: Int,
    val genero: String,
    val profissao: String,
    val nacionalidade: String
)
