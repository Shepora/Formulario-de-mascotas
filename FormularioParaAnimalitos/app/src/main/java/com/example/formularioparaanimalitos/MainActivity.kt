package com.example.formularioparaanimalitos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formularioparaanimalitos.ui.theme.FormularioParaAnimalitosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MascotaViewModel by viewModels()

        setContent {
            FormularioParaAnimalitosTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "pantallaA") {
                    composable("pantallaA") {
                        PantallaA(navController, viewModel)
                    }
                    composable("pantallaB") {
                        PantallaB(navController, viewModel)
                    }
                }
            }
        }
    }
}



