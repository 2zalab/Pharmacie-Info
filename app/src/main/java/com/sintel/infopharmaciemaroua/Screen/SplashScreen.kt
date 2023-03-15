package com.sintel.infopharmaciemaroua.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sintel.infopharmaciemaroua.nav.Screen
import kotlinx.coroutines.delay
import com.sintel.infopharmaciemaroua.R

@Composable
fun SplashScreen(navController: NavController) {


    var progress by remember { mutableStateOf(0f) } // Initial progress value

    LaunchedEffect(Unit) {
        while (progress <= 1f) {
            delay(50)
            progress += 0.01f // Increment the progress by 1%
        }
        navController.navigate(Screen.Login.route) {
            popUpTo(Screen.Login.route) { inclusive = true }
        }// Navigate to the main screen
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pharmacie_icone),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = progress,
                color = MyColors.primary//MaterialTheme.colors.primary
            )
        }
    }
}
