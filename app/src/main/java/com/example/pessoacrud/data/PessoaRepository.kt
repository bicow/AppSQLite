package com.example.pessoacrud.data

import kotlinx.coroutines.flow.Flow

open class PessoaRepository(private val pessoaDao: PessoaDao) {
    fun getPessoas(): Flow<List<Pessoa>> = pessoaDao.getPessoas()

    fun getPessoaById(id: Int): Flow<Pessoa> = pessoaDao.getPessoaById(id)

    suspend fun insertPessoa(pessoa: Pessoa) = pessoaDao.insertPessoa(pessoa)

    suspend fun deletePessoa(pessoa: Pessoa) = pessoaDao.deletePessoa(pessoa)
}
