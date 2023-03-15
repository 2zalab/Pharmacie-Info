package com.sintel.infopharmaciemaroua.Screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sintel.infopharmaciemaroua.R
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.text.style.TextAlign
import com.sintel.infopharmaciemaroua.nav.Screen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment




val MyColors = lightColors(
    primary = Color(0xFF307044), // Replace with your desired primary color
    onPrimary = Color.White,
    // Other colors can be customized here as well
)


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                title = {
                    Text(text = "PHARMACIE INFO", color = MyColors.primary, fontWeight = FontWeight.Bold)
                },
                backgroundColor = MaterialTheme.colors.onPrimary,
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_pharmacie),
                        contentDescription = "Navigation icon",
                        modifier = androidx.compose.ui.Modifier
                            .padding(5.dp, 0.dp, 0.dp, 0.dp)
                            .size(30.dp)
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Search ,
                        contentDescription = null,
                        tint = MyColors.primary,
                        modifier = Modifier.padding(0.dp,0.dp,20.dp,0.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = MyColors.primary
            ) {
                Text(
                    text = "Copyright (c) JPO 2023 - LYKAMA",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) {
        LazyColumn() {
            //Spacer(modifier = Modifier.height(10.dp))
            item {
                Row(
                    modifier = Modifier.padding(0.dp)
                ) {
                    ImageSlider()
                }
            }

            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)){
                    Button(
                        onClick = {
                       navController.navigate(Screen.AppInfo.route)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MyColors.primary // Use the primary color
                        )

                    ) {
                        Text(text = "Lire Plus...", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 15.sp)
                    }
                }
            }


            item {
                Column(
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    /*
                    val images = listOf(
                        R.drawable.logo_pharmacie,
                        R.drawable.pharmacie_icone,
                        R.drawable.logo_pharmacie
                    )

                    val couleurs = listOf(
                        MaterialTheme.colors.primary,
                        Color.DarkGray,
                        MaterialTheme.colors.onSecondary
                    )

                    val Textes = listOf(
                        "Actualités sur les pharmacies de la ville de Maroua",
                        "Retrouvez facilement toutes les pharmacies de la ville",
                        "Consulter et rechercher les pharmacies de garde"
                    )

                    //val context = LocalContext.current
                    var currentIndex by remember { mutableStateOf(0) }
                    val handler = remember { Handler(Looper.getMainLooper()) }

                    LaunchedEffect(true) {
                        val runnable = object : Runnable {
                            override fun run() {
                                currentIndex = (currentIndex + 1) % images.size
                                handler.postDelayed(this, 5000) // Change image every 5 seconds
                            }
                        }
                        handler.postDelayed(runnable, 5000)
                    }


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(180.dp)
                            .padding(20.dp, 15.dp, 20.dp, 10.dp)
                            .background(
                                color = couleurs[currentIndex],
                                shape = RoundedCornerShape(6.dp)
                            )
                    ) {
                        Row(modifier = Modifier.padding(10.dp)) {
                            Image(
                                painter = painterResource(images[currentIndex]),//R.drawable.logo_ens),
                                contentDescription = null,
                                // contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(145.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = Textes[currentIndex],
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )

                                Spacer(modifier = Modifier.height(20.dp))

                                Button(
                                    onClick = {
                                              navController.navigate(Screen.AppInfo.route)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = colorResource(
                                            id = R.color.white
                                        )
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                    // .size(180.dp, 50.dp)
                                    //  .background(color = White, RoundedCornerShape(4.dp))
                                ) {
                                    Text(
                                        text = "Lire Plus...",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                }
                            }
                        }
                    }

                     */

                    //ImageSlider(navController)
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp, 0.dp, 20.dp, 0.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f)
                                .clickable {
                                    navController.navigate(Screen.Pharmacie_garde.route)
                                },
                            backgroundColor = Color.LightGray
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_pharma),
                                    contentDescription = "Image cours",
                                    modifier = Modifier
                                        .size(130.dp)
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "PHARMACIE DE GARDE",
                                    style = TextStyle(
                                        color = MyColors.primary,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }

                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f)
                                .clickable {
                                    navController.navigate(Screen.ListePharmacie.route)
                                },
                            backgroundColor = Color.LightGray
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.pharmacie_list),
                                    contentDescription = "Image evaluation",
                                    modifier = Modifier
                                        .size(130.dp)
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "LISTE DES PHARMACIES",
                                    style = TextStyle(
                                        color = MyColors.primary,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }

                    }

                }
            }
        }

    }


}

@Composable
fun Slider() {
    val images = listOf(
        R.drawable.pharma1,
        R.drawable.pharma2,
        R.drawable.pharma3
    )
    val state = rememberScrollState()
    val currentPage = remember { mutableStateOf(0) }
    val itemCount = images.size

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        //state = state,
    ) {
        items(itemCount) { index ->
            Image(
                painter = painterResource(images[index]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            )
        }
    }

    DotsIndicator(
        count = itemCount,
        currentPage = currentPage.value,
        //modifier = Modifier.align(Alignment.CenterHorizontally)
    )

    LaunchedEffect(state) {
        snapshotFlow { state.value }
            .map { stateToPage(state, itemCount) }
            .distinctUntilChanged()
            .distinctUntilChanged()
            .collect { currentPage.value = it }
    }
}


fun stateToPage(state: ScrollState, itemCount: Int): Int {
    val maxOffset = (itemCount - 1) * state.maxValue
    val currentPageOffset = state.value.toFloat() / maxOffset
    return (currentPageOffset + 0.5f).toInt().coerceIn(0, itemCount - 1)
}


@Composable
fun DotsIndicator(
    count: Int,
    currentPage: Int,
    radius: Dp = 5.dp,
    spaceBetweenDots: Dp = 8.dp,
    activeColor: Color = MaterialTheme.colors.primary,
    inactiveColor: Color = Color.LightGray
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenDots)
    ) {
        repeat(count) { index ->
            val color = if (index == currentPage) activeColor else inactiveColor
            Dot(
                color = color,
                radius = radius
            )
        }
    }
}

@Composable
fun Dot(
    color: Color,
    radius: Dp
) {
    Canvas(
        modifier = Modifier
            .size(radius * 2)
            .clip(CircleShape)
    ) {
        drawCircle(
            color = color,
            radius = radius.toPx()
        )
    }
}

