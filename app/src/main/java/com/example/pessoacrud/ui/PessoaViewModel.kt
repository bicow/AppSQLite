package com.example.pessoacrud.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pessoacrud.data.PessoaRepository
import com.example.pessoacrud.data.Pessoa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PessoaViewModel(private val repository: PessoaRepository) : ViewModel() {

    val pessoaList: Flow<List<Pessoa>> = repository.getPessoas()

    fun getPessoaById(id: Int): Flow<Pessoa> = repository.getPessoaById(id)

    fun addOrUpdatePessoa(id: Int? = null, nome: String, idade: Int, genero: String, profissao: String, nacionalidade: String) {
        val pessoa = Pessoa(id = id ?: 0, nome = nome,  idade = idade, genero = genero, profissao = profissao, nacionalidade = nacionalidade)
        viewModelScope.launch {
            repository.insertPessoa(pessoa)
        }
    }

    fun deleteSpider(pessoa: Pessoa) {
        viewModelScope.launch {
            repository.deletePessoa(pessoa)
        }
    }
}
