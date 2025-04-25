package com.example.formularioparaanimalitos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaA(navController: NavController, viewModel: MascotaViewModel) {
    val colorFondo = Color(0xFF83BDB0)
    val colorBoton = Color(0xFFFA9E57)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Registrar Mascota", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

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
            label = { Text("URL Foto") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.agregarMascota()
                navController.navigate("pantallaB")
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorBoton),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🐶 Registrar Mascota", color = Color.White)
        }
    }
}