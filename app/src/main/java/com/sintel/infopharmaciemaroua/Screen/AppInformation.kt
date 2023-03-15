package com.sintel.infopharmaciemaroua.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sintel.infopharmaciemaroua.R

@Composable
fun AppInformation(navController: NavController) {
    val name = "PHARMACIE INFO"
    val version = "1.0.0"
    val author = "LYCEE DE KAKATARE MAROUA"
    val email = "isaac_touza@outlook.fr"
    val year = "Mars 2023"
    val description = stringResource(id = R.string.app_description)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pharmacie_icone),
                    contentDescription = "logo de l'application",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            Divider()
        }

        item {
            Text(
                text = name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                color = MyColors.primary
            )
            Text(
                text = "Version $version",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MyColors.primary
            )
            Text(
                text = "Auteur : $author",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MyColors.primary
            )
            Text(
                text = "Email : $email",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp),
                color = Color(0xFF616161)
            )
            Text(
                text = "Année de création : $year",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp),
                color = Color(0xFF616161)
            )
        }
        item {
            Divider(
                color = Color(0xFFE0E0E0),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        item {
            Text(
                text = "Description :",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp),
                color = MyColors.primary
            )
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                color = Color(0xFF616161)
            )
        }
    }
}