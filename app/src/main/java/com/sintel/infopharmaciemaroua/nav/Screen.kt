package com.sintel.infopharmaciemaroua.nav

import com.sintel.infopharmaciemaroua.`class`.Pharmacie

sealed class Screen (var route:String){
    object Splash :Screen("splash")
    object Login :Screen("Login")
    object Home :Screen("Home")
    object CreateCount:Screen("signUp")
    object ListePharmacie:Screen("PharmacieListe")
    object AppInfo :Screen("AppInfo")
    object Pharmacie_garde:Screen("pharmacies_garde")
}
