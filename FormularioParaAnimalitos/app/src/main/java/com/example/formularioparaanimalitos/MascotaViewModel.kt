package com.example.formularioparaanimalitos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MascotaViewModel : ViewModel() {
    var nombre by mutableStateOf("")
    var raza by mutableStateOf("")
    var tamaño by mutableStateOf("")
    var edad by mutableStateOf("")
    var urlFoto by mutableStateOf("")
}