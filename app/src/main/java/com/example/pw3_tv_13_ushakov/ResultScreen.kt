package com.example.pw3_tv_13_ushakov

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("DefaultLocale")
@Composable
fun ResultScreen(power: Double, deviation: Double, error: Double, price: Double) {
    val result = calculateProfit(power, deviation, error, price)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Результати:", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Прибуток: ${String.format("%.2f", result.profit)} тис. грн",
            fontSize = 18.sp
        )
        Text(
            text = "Штраф: ${String.format("%.2f", result.penalty)} тис. грн",
            fontSize = 18.sp
        )

    }
}