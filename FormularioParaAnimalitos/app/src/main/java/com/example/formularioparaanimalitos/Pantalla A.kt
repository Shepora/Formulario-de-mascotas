package com.example.formularioparaanimalitos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaA(navController: NavController, viewModel: MascotaViewModel){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.nombre = it },
            label = { Text("Nombre") }
        )
        OutlinedTextField(
            value = viewModel.raza,
            onValueChange = { viewModel.raza = it },
            label = { Text("Raza") }
        )
        OutlinedTextField(
            value = viewModel.tamaño,
            onValueChange = { viewModel.tamaño = it },
            label = { Text("Tamaño") }
        )
        OutlinedTextField(
            value = viewModel.edad,
            onValueChange = { viewModel.edad = it },
            label = { Text("Edad") }
        )
        OutlinedTextField(
            value = viewModel.urlFoto,
            onValueChange = { viewModel.urlFoto = it },
            label = { Text("URL de la Foto") }
        )
        Button(onClick = { navController.navigate("pantallaB") }) {
            Text("Registrar Mascota")
        }
    }
}