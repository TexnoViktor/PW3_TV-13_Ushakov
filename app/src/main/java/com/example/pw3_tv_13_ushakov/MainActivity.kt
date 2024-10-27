package com.example.pw3_tv_13_ushakov

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pw3_tv_13_ushakov.ui.theme.PW3_TV13_UshakovTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PW3_TV13_UshakovTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "input") {
        composable("input") {
            InputScreen { power, deviation, error, price ->
                navController.navigate("result/$power/$deviation/$error/$price")
            }
        }
        composable(
            "result/{power}/{deviation}/{error}/{price}",
            arguments = listOf(
                navArgument("power") { type = NavType.StringType },
                navArgument("deviation") { type = NavType.StringType },
                navArgument("error") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val power = backStackEntry.arguments?.getString("power")?.toDoubleOrNull() ?: 0.0
            val deviation = backStackEntry.arguments?.getString("deviation")?.toDoubleOrNull() ?: 0.0
            val error = backStackEntry.arguments?.getString("error")?.toDoubleOrNull() ?: 0.0
            val price = backStackEntry.arguments?.getString("price")?.toDoubleOrNull() ?: 0.0
            ResultScreen(power, deviation, error, price)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PW3_TV13_UshakovTheme {
        MyApp()
    }
}