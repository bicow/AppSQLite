package com.example.pessoacrud.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pessoa::class], version = 1, exportSchema = false)
abstract class PessoaDatabase : RoomDatabase() {
    abstract fun pessoaDao(): PessoaDao
}
