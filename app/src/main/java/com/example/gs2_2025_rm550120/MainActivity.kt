package com.example.gs2_2025_rm550120

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gs2_2025_rm550120.ui.screens.LoginScreen
import com.example.gs2_2025_rm550120.ui.screens.MenuScreen
import com.example.gs2_2025_rm550120.ui.screens.IMCScreen
import com.example.gs2_2025_rm550120.ui.screens.TeamScreen
import com.example.gs2_2025_rm550120.ui.theme.GS2_2025_RM550120Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GS2_2025_RM550120Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Menu : Screen("menu")
    object IMC : Screen("imc")
    object Team : Screen("team")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController = navController)
        }
        composable(Screen.IMC.route) {
            IMCScreen(navController = navController)
        }
        composable(Screen.Team.route) {
            TeamScreen(navController = navController)
        }
    }
}
