package com.zobaer53.banking_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.zobaer53.banking_ui.ui.theme.Banking_uiTheme
import com.zobaer53.banking_ui.views.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = resources.getColor(
                    R.color.white, null),
                darkScrim = resources.getColor(R.color.black,null)
            ),)
        super.onCreate(savedInstanceState)
        setContent {
            Banking_uiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    HomeScreen()
                }
            }
        }
    }
}

