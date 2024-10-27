package com.example.pw3_tv_13_ushakov

import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputScreen(onCalculateClick: (Double, Double, Double, Double) -> Unit) {
    var power by remember { mutableStateOf("") }
    var deviation by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(modifier = Modifier
            .padding(16.dp),
            text = "Калькулятор Прибутку Електростанції", fontSize = 36.sp)
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = power,
                onValueChange = { power = it },
                label = { Text("Середньодобова потужність (PC)") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = deviation,
                onValueChange = { deviation = it },
                label = { Text("Відхилення (σ)") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = error,
                onValueChange = { error = it },
                label = { Text("Похибка (%)") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Ціна за кВт (B)") }
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Button(onClick = {
            val powerVal = power.toDoubleOrNull() ?: 0.0
            val deviationVal = deviation.toDoubleOrNull() ?: 0.0
            val errorVal = error.toDoubleOrNull() ?: 0.0
            val priceVal = price.toDoubleOrNull() ?: 0.0
            onCalculateClick(powerVal, deviationVal, errorVal, priceVal)
        }) {
            Text(text = "Розрахувати", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(18.dp))
    }

}