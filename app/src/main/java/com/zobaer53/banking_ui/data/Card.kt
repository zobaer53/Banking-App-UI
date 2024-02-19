package com.zobaer53.banking_ui.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardName: String,
    val cardType: String,
    val balance: Double,
    val cardNumber: String,
    val cardGradient: Brush,

)
