package com.example.pessoacrud.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PessoaDao {
    @Query("SELECT * FROM pessoa")
    fun getPessoas(): Flow<List<Pessoa>>

    @Query("SELECT * FROM pessoa WHERE id = :id")
    fun getPessoaById(id: Int): Flow<Pessoa>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPessoa(pessoa: Pessoa)

    @Delete
    suspend fun deletePessoa(pessoa: Pessoa)
}
