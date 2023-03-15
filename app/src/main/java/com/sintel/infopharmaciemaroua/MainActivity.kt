package com.sintel.infopharmaciemaroua

import android.os.Bundle
import android.view.Surface
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sintel.infopharmaciemaroua.Screen.AfficherListePharmacie
import com.sintel.infopharmaciemaroua.Screen.LoginScreen
import com.sintel.infopharmaciemaroua.Screen.MyColors
import com.sintel.infopharmaciemaroua.Screen.Slider
import com.sintel.infopharmaciemaroua.nav.NavigationScreen
import com.sintel.infopharmaciemaroua.ui.theme.InfoPharmacieMarouaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Remember a SystemUiController
            val systemUiController = rememberSystemUiController()
            val darkTheme = isSystemInDarkTheme()
            SideEffect {
                systemUiController.setStatusBarColor(
                    color =  MyColors.primary //else Color.White
                )
            }

            val navController= rememberNavController()
            NavigationScreen(navController = navController)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InfoPharmacieMarouaTheme {
        val navController= rememberNavController()
        //LoginScreen(navController = navController)
        //Greeting("Android")
        //Slider()
        AfficherListePharmacie(navController = navController)
    }
}