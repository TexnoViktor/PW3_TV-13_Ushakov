package com.example.pw3_tv_13_ushakov

data class CalculationResult(val profit: Double, val penalty: Double)

fun calculateProfit(power: Double, deviation: Double, error: Double, price: Double): CalculationResult {
    val deltaW1 = 0.2 // 20% енергії генерується без збитків
    val deltaW2 = 0.68 // 68% енергії генерується після вдосконалення

    val W1 = power * 24 * deltaW1
    val P1 = W1 * price

    val W2 = power * 24 * (1 - deltaW1)
    val S1 = W2 * price

    val W3 = power * 24 * deltaW2
    val P2 = W3 * price

    val W4 = power * 24 * (1 - deltaW2)
    val S2 = W4 * price

    val profit = P2 - S2
    val penalty = S2

    return CalculationResult(profit = profit, penalty = penalty)
}