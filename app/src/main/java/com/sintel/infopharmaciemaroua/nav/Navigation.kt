package com.sintel.infopharmaciemaroua.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sintel.infopharmaciemaroua.Screen.*

@Composable
fun NavigationScreen(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.CreateCount.route){
            SignUp(navController = navController)
        }
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(route=Screen.ListePharmacie.route){
            AfficherListePharmacie(navController = navController)
        }
        composable(route=Screen.AppInfo.route){
            AppInformation(navController = navController)
        }

        composable(route=Screen.Pharmacie_garde.route){
            Pharmacies_garde(navController = navController)
        }
    }
}