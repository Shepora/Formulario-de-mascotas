package com.example.formularioparaanimalitos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale

@Composable
fun PantallaB(navController: NavController, viewModel: MascotaViewModel) {
    val colorFondo = Color(0xFF83BDB0)
    val colorTarjeta = Color.White
    val colorTexto = Color(0xFF333333)
    val colorBoton = Color(0xFFFA9E57)

    var mascotaEditandoIndex by remember { mutableStateOf(-1) }
    var mascotaEditando by remember { mutableStateOf<Mascota?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(20.dp)
    ) {
        viewModel.listaMascotas.forEachIndexed { index, mascota ->
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = colorTarjeta),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp)
                    .clickable {
                        mascotaEditando = mascota.copy()
                        mascotaEditandoIndex = index
                    }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    AsyncImage(
                        model = mascota.urlFoto,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(350.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("🐾 Nombre: ${mascota.nombre}", color = colorTexto)
                    Text("🐕 Raza: ${mascota.raza}", color = colorTexto)
                    Text("📏 Tamaño: ${mascota.tamaño}", color = colorTexto)
                    Text("🎂 Edad: ${mascota.edad}", color = colorTexto)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = colorBoton),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("🔙 Volver", color = Color.White)
        }
    }

    mascotaEditando?.let { mascota ->
        // Estados locales para editar cada campo
        var nombre by remember { mutableStateOf(mascota.nombre) }
        var raza by remember { mutableStateOf(mascota.raza) }
        var tamaño by remember { mutableStateOf(mascota.tamaño) }
        var edad by remember { mutableStateOf(mascota.edad) }
        var urlFoto by remember { mutableStateOf(mascota.urlFoto) }

        AlertDialog(
            onDismissRequest = {
                mascotaEditando = null
                mascotaEditandoIndex = -1
            },
            confirmButton = {
                Button(onClick = {
                    if (mascotaEditandoIndex >= 0) {
                        val mascotaActualizada = mascota.copy(
                            nombre = nombre,
                            raza = raza,
                            tamaño = tamaño,
                            edad = edad,
                            urlFoto = urlFoto
                        )
                        viewModel.editarMascota(mascotaEditandoIndex, mascotaActualizada)
                    }
                    mascotaEditando = null
                    mascotaEditandoIndex = -1
                }) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                Button(onClick = {
                    if (mascotaEditandoIndex >= 0) {
                        viewModel.eliminarMascota(mascotaEditandoIndex)
                    }
                    mascotaEditando = null
                    mascotaEditandoIndex = -1
                }) {
                    Text("Eliminar")
                }
            },
            title = { Text("Editar Mascota") },
            text = {
                Column {
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") }
                    )
                    OutlinedTextField(
                        value = raza,
                        onValueChange = { raza = it },
                        label = { Text("Raza") }
                    )
                    OutlinedTextField(
                        value = tamaño,
                        onValueChange = { tamaño = it },
                        label = { Text("Tamaño") }
                    )
                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        label = { Text("Edad") }
                    )
                    OutlinedTextField(
                        value = urlFoto,
                        onValueChange = { urlFoto = it },
                        label = { Text("URL Foto") }
                    )
                }
            }
        )
    }
}