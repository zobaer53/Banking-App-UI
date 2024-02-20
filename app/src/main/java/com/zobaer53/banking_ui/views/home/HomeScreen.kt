package com.zobaer53.banking_ui.views.home

import FinanceSection
import WalletSection
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zobaer53.banking_ui.views.bottomnav.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
                    },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            WalletSection()
            CardsSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrenciesSection()

        }
    }
}