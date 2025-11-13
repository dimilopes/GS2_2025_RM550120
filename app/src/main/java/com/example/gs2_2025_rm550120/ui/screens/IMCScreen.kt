package com.example.gs2_2025_rm550120.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gs2_2025_rm550120.Screen
import kotlin.math.pow

@Composable
fun IMCScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var weightText by remember { mutableStateOf("") }
    var heightText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Pair<String, Double>?>(null) } // Pair<Name, IMC>

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculadora IMC", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Seu nome") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = weightText,
            onValueChange = { weightText = it.replace(',', '.') },
            label = { Text("Seu Peso (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = heightText,
            onValueChange = { heightText = it.replace(',', '.') },
            label = { Text("Sua Altura (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    val weight = weightText.toDoubleOrNull()
                    val height = heightText.toDoubleOrNull()

                    if (weight != null && height != null && height > 0) {
                        val imc = weight / height.pow(2)
                        result = Pair(name.ifEmpty { "Pessoa" }, imc)
                    } else {
                        result = null
                    }
                },
                enabled = weightText.isNotEmpty() && heightText.isNotEmpty()
            ) {
                Text("Calcular")
            }

            Button(
                onClick = {
                    name = ""
                    weightText = ""
                    heightText = ""
                    result = null
                }
            ) {
                Text("Limpar")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        result?.let { (personName, imc) ->
            val imcFormatted = String.format("%.2f", imc)
            val classification = when {
                imc < 18.5 -> "Abaixo do peso"
                imc < 24.9 -> "Peso normal"
                imc < 29.9 -> "Sobrepeso"
                imc < 34.9 -> "Obesidade Grau I"
                imc < 39.9 -> "Obesidade Grau II"
                else -> "Obesidade Grau III"
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Resultado para: $personName", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "IMC: $imcFormatted", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Classificação: $classification", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.Menu.route) {
                popUpTo(Screen.IMC.route) { inclusive = true }
            } },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar para Menu")
        }
    }
}
