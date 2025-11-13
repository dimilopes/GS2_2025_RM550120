package com.example.gs2_2025_rm550120.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gs2_2025_rm550120.Screen

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MENU", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.IMC.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cálculo de IMC")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.Team.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Equipe")
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Menu.route) { inclusive = true }
            } },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar (Logout)")
        }
    }
}
