package com.example.pessoacrud.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PessoaScreen(viewModel: PessoaViewModel) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var profissao by remember { mutableStateOf("") }
    var nacionalidade by remember { mutableStateOf("") }
    var selectedPessoaId by remember { mutableStateOf<Int?>(null) }

    val pessoaList by viewModel.pessoaList.collectAsState(initial = emptyList())

    val isFormValid = nome.isNotBlank() && idade.isNotBlank() && genero.isNotBlank() && profissao.isNotBlank() && nacionalidade.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(16.dp)) // Fundo branco translúcido
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Cadastrar Pessoa",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    fontSize = 28.sp
                )
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text("Idade", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = nacionalidade,
                onValueChange = { nacionalidade = it },
                label = { Text("Nacionalidade", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Genêro", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = profissao,
                onValueChange = { profissao = it },
                label = { Text("Profissão", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (isFormValid) {
                        viewModel.addOrUpdatePessoa(selectedPessoaId, nome, idade.toIntOrNull() ?: 1, genero, profissao, nacionalidade)
                        nome = ""
                        idade = ""
                        genero = ""
                        profissao = ""
                        nacionalidade = ""
                        selectedPessoaId = null
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, disabledContainerColor = Color.Blue.copy(alpha = 0.5f)),
                enabled = isFormValid
            ) {
                Text(if (selectedPessoaId == null) "Adicionar Pessoa" else "Atualizar Pessoa", color = Color.White)
            }

            LazyColumn (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(pessoaList) { time ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Nome: ${time.nome}", color = Color.Black)
                            Text(text = "Idade: ${time.idade}", color = Color.Black)
                            Text(text = "Nacionalidade: ${time.nacionalidade}", color = Color.Black)
                            Text(text = "Genêro: ${time.genero}", color = Color.Black)
                            Text(text = "Profissão: ${time.profissao}", color = Color.Black)
                        }

                        Row {
                            // Botão de editar
                            IconButton(onClick = {
                                nome = time.nome
                                idade = time.idade.toString()
                                genero = time.genero
                                profissao = time.profissao
                                nacionalidade = time.nacionalidade
                                selectedPessoaId = time.id
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = "Editar Pessoa",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        IconButton(onClick = { viewModel.deleteSpider(time) }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                modifier = Modifier.size(32.dp),
                                contentDescription = "Excluir Pessoa",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}
