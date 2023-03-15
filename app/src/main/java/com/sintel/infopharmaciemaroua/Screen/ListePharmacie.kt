package com.sintel.infopharmaciemaroua.Screen

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sintel.infopharmaciemaroua.`class`.Pharmacie
import com.sintel.infopharmaciemaroua.nav.Screen
import com.sintel.infopharmaciemaroua.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AfficherListePharmacie(navController: NavController){

    val ListePharmacie = listOf<Pharmacie>(
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE KALIAO","Kakataré carrefour PTT","242 05 11 16",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE FERNGO","Carrefour Djarma","242 06 95 40",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EXTREME NORD","Artisanat","699 85 47 27",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EMERAUDE","Maroua Kakataré","677 19 71 71",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU SAHEL","Domaya Papa Guinness","679 88 00 00",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU CENTRE" ,"NZiko","699 50 05 47",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU BOULEVARD","Domayo deux voies","699 66 40 47",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DE MAROUA","Pont Vert","692 31 64 43",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DOMAYO ","Garnizon","699 59 84 83","") ,
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DE DOUGOI","Dougoi","697 18 13 07",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE MASSEBOEUF","Bamare Maoundiyo","698 02 57 20",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DOMAYO ","Maroua","699 59 84 83",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EL RAPHA","Maroua Pitoaré","695 95 43 13",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE HORIZON","Carrefour Para","695 24 89 87","")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(text = "Liste des pharmacies", color = MyColors.primary)
                },
                backgroundColor = MaterialTheme.colors.onPrimary,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Navigation icon",
                        modifier = androidx.compose.ui.Modifier
                            .padding(5.dp, 0.dp, 0.dp, 0.dp)
                            .clickable {
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Home.route) { inclusive = true }
                                }
                            },
                        )
                },
            )

        },
    )
    {
        //val items by remember { mutableStateOf(ListePharmacie[0]) }
      SearchBar(items = ListePharmacie)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchBar(items: List<Pharmacie>) {

    var searchText by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(items) }
    //val searchQuery=remember { mutableStateOf("") }

    Column() {
        Surface(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp, 15.dp, 20.dp, 10.dp),
            color = Color.LightGray,
            elevation = 0.dp
        ) {
            TextField(
                value = searchText,
                //visualTransformation = PasswordVisualTransformation(),
                onValueChange = { newValue ->
                    searchText = newValue
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,//Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25.dp),
                placeholder = {
                    Text(
                        text = "Recherche",
                        //style = MaterialTheme.typography.body1.copy(color = Color.LightGray)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = {
                            searchText = ""
                        }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = ""
                            )
                        }
                    } else {
                        null
                    }
                },
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onSearch = {
                        performSearch(searchText,items)
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
            )
        }

        LazyColumn(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            item {
                items.forEach { option ->
                    Column(

                    ) {
                        Card(
                            modifier = androidx.compose.ui.Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            elevation = 4.dp,
                            onClick = {
                                //navController.navigate(Screen.AppInfo.route)
                                //navController.navigate(Screen.UEProgrammables.route)
                            }
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(option.Image),
                                    // Icons.Default.Add,
                                    contentDescription = "My Image",
                                    modifier = androidx.compose.ui.Modifier
                                        .size(100.dp)
                                )
                                Column(
                                    modifier = Modifier.padding(5.dp)
                                ) {
                                    Text(
                                        text = option.name,
                                        //style = MaterialTheme.typography.h6,
                                        style = TextStyle(
                                            color = MyColors.primary,//MaterialTheme.colors.primary,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = option.quartier,
                                        style = MaterialTheme.typography.body2
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = option.phone,
                                        style = MaterialTheme.typography.body2
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    }



}

fun performSearch(query: String, items: List<Pharmacie>) {
    val  searchResults = items.filter { item ->
        item.name.contains(query, ignoreCase = true) ||
                item.quartier.contains(query, ignoreCase = true) ||
                item.phone.contains(query, ignoreCase = true)
    }
}


@Preview(showBackground = true)
@Composable
fun VoirListePharmacie(){
    val navController = rememberNavController()
    AfficherListePharmacie(navController)
}

