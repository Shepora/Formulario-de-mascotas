package com.example.formularioparaanimalitos

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class MascotaViewModel : ViewModel() {
    var nombre by mutableStateOf("")
    var raza by mutableStateOf("")
    var tamaño by mutableStateOf("")
    var edad by mutableStateOf("")
    var urlFoto by mutableStateOf("")

    var listaMascotas = mutableStateListOf<Mascota>()

    fun agregarMascota() {
        val nueva = Mascota(nombre, raza, tamaño, edad, urlFoto)
        listaMascotas.add(nueva)
        limpiarCampos()
    }

    private fun limpiarCampos() {
        nombre = ""
        raza = ""
        tamaño = ""
        edad = ""
        urlFoto = ""
    }

    fun editarMascota(index: Int, mascota: Mascota) {
        listaMascotas[index] = mascota
    }

    fun eliminarMascota(index: Int) {
        listaMascotas.removeAt(index)
    }
}