package com.sintel.infopharmaciemaroua.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.sintel.infopharmaciemaroua.R
import com.sintel.infopharmaciemaroua.`class`.Pharmacie
import com.sintel.infopharmaciemaroua.`class`.pharmacies_garde
import com.sintel.infopharmaciemaroua.nav.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun Pharmacies_garde(navController:NavController){

    val liste = mutableListOf(
        pharmacies_garde("26/12/2022 - 02/01/2023", groupe1),
        pharmacies_garde("02/01/2023 - 09/01/2023", groupe2),
        pharmacies_garde("09/01/2023 - 16/01/2023", groupe3),
        pharmacies_garde("16/01/2023 - 23/01/2023", groupe4),
        pharmacies_garde("23/01/2023 - 30/01/2023", groupe1),
        pharmacies_garde("30/01/2023 - 06/02/2023", groupe2),
        pharmacies_garde("06/02/2023 - 13/02/2023", groupe3p),
        pharmacies_garde("13/02/2023 - 20/02/2023", groupe4p),
        pharmacies_garde("20/02/2023 - 27/02/2023", groupe1),
        pharmacies_garde("27/02/2023 - 06/03/2023", groupe2),
        pharmacies_garde("06/03/2023 - 13/03/2023", groupe3p),
        pharmacies_garde("13/03/2023 - 20/03/2023", groupe4),
        pharmacies_garde("20/03/2023 - 27/03/2023", groupe1p),
        pharmacies_garde("27/03/2023 - 03/04/2023", groupe2),
        pharmacies_garde("03/04/2023 - 10/04/2023", groupe3p),
        pharmacies_garde("10/04/2023 - 17/04/2023", groupe4),
        pharmacies_garde("17/04/2023 - 24/04/2023", groupe1),
        pharmacies_garde("24/04/2023 - 01/05/2023", groupe2p),
        pharmacies_garde("01/05/2023 - 08/05/2023", groupe3p),
        pharmacies_garde("08/05/2023 - 15/05/2023", groupe4),
        pharmacies_garde("15/05/2023 - 22/05/2023", groupe1),
        pharmacies_garde("22/05/2023 - 29/05/2023", groupe2),
        pharmacies_garde("29/05/2023 - 05/06/2023", groupe3),
        pharmacies_garde("05/06/2023 - 12/06/2023", groupe4),
        pharmacies_garde("12/06/2023 - 19/06/2023", groupe1),
        pharmacies_garde("19/06/2023 - 26/06/2023", groupe2),
        pharmacies_garde("26/06/2023 - 03/07/2023", groupe3p),
        pharmacies_garde("03/07/2023 - 10/07/2023", groupe4p),
        pharmacies_garde("10/07/2023 - 17/07/2023", groupe1),
        pharmacies_garde("17/07/2023 - 24/07/2023", groupe2),
        pharmacies_garde("24/07/2023 - 31/07/2023", groupe3p),
        pharmacies_garde("31/07/2023 - 07/08/2023", groupe4),
        pharmacies_garde("07/08/2023 - 14/08/2023", groupe1p),
        pharmacies_garde("14/08/2023 - 21/08/2023", groupe2),
        pharmacies_garde("21/08/2023 - 28/08/2023", groupe3p),
        pharmacies_garde("28/08/2023 - 04/09/2023", groupe4p),
        pharmacies_garde("04/09/2023 - 11/09/2023", groupe1),
        pharmacies_garde("11/09/2023 - 18/09/2023", groupe2p),
        pharmacies_garde("18/09/2023 - 25/09/2023", groupe3p),
        pharmacies_garde("25/09/2023 - 02/10/2023", groupe4),
        pharmacies_garde("02/10/2023 - 09/10/2023", groupe1),
        pharmacies_garde("09/10/2023 - 16/10/2023", groupe2),
        pharmacies_garde("16/10/2023 - 23/10/2023", groupe3),
        pharmacies_garde("23/10/2023 - 30/10/2023", groupe4),
        pharmacies_garde("30/10/2023 - 06/11/2023", groupe1),
        pharmacies_garde("06/11/2023 - 13/11/2023", groupe2),
        pharmacies_garde("13/11/2023 - 20/11/2023", groupe3p),
        pharmacies_garde("20/11/2023 - 27/11/2023", groupe4p),
        pharmacies_garde("27/11/2023 - 04/12/2023", groupe1),
        pharmacies_garde("04/12/2023 - 11/12/2023", groupe2),
        pharmacies_garde("11/12/2023 - 18/12/2023", groupe3p),
        pharmacies_garde("18/12/2023 - 25/12/2023", groupe4),
        pharmacies_garde("25/12/2023 - 01/01/2024", groupe1p),
        pharmacies_garde("01/01/2024 - 08/01/2024", groupe2),
    )

    val showDialog by remember {mutableStateOf(false)}


    val ListePharmacie = listOf<Pharmacie>(
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE KALIAO","Kakataré carrefour PTT","242 05 11 16",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU CENTRE  MAROUA" ,"NZiko","699 50 05 47",""),
        Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU BOULEVARD","Domayo deux voies","699 66 40 47",""),
    )


    Column(
      modifier = Modifier.fillMaxSize()
    ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
                    .background(color = MyColors.primary)
            )
            {
               Column(
                   modifier = Modifier
                       .fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.SpaceAround
               ) {
                   Row(modifier = Modifier.fillMaxWidth()) {
                       IconButton(
                           onClick = {
                               navController.navigate(Screen.Home.route)
                           }
                       )
                       {
                           Icon(
                               imageVector = Icons.Default.ArrowBack,
                               tint = Color.White,
                               contentDescription = ""
                           )
                       }
                   }
                   Column(
                       modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
                   ) {
                       Text(
                           "PHARMACIES DE GARDE",
                           style = TextStyle(
                               fontSize = 20.sp,
                               fontWeight = FontWeight.Bold
                           ),
                           color = Color.White,
                           modifier = Modifier
                               .align(alignment = Alignment.CenterHorizontally)
                       )

                       Text(
                           "Periode: 06/03/2023 - 13/03/2023",
                           style = TextStyle(
                               fontSize = 16.sp,
                               fontWeight = FontWeight.Bold
                           ),
                           color = Color.White,
                           modifier = Modifier
                               .padding(0.dp, 30.dp, 0.dp, 0.dp)
                       )
                   }
               }
        }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    .graphicsLayer(
                        // translationX = (-30).dp.value,
                        translationY = (-80).dp.value
                    )
            ) {
                LazyColumn(){
                    item {
                        ListePharmacie.forEach { item ->
                            var showDialog by remember { mutableStateOf(false) }
                            Column(
                                modifier=Modifier.clickable {
                                    showDialog=!showDialog
                                    //showDialog = true
                                }
                            ) {
                                if (showDialog){
                                    CustomDialog()
                                }

                                Row(
                                    modifier = Modifier
                                        //.padding(8.dp)
                                        .fillMaxWidth()
                                        .clickable {
                                        }
                                ) {
                                    Image(
                                        painter = painterResource(item.Image),
                                        // Icons.Default.Add,
                                        contentDescription = "My Image",
                                        modifier = Modifier
                                            .size(100.dp)
                                    )
                                    Column(
                                        modifier = Modifier.padding(5.dp)
                                    ) {
                                        Text(
                                            text = item.name,
                                            //style = MaterialTheme.typography.h6,
                                            style = TextStyle(
                                                color = MyColors.primary,//MaterialTheme.colors.primary,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 15.sp
                                            )
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = item.quartier,
                                            style = MaterialTheme.typography.body2
                                        )
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            text = item.phone,
                                            style = MaterialTheme.typography.body2
                                        )
                                    }
                                }
                            }
                            Divider()
                        }
                    }
                }
            }
    }
}


@Preview(showBackground = false)
@Composable
fun PreviewPharmacieDeGarde(){
    val navController= rememberNavController()
    Pharmacies_garde(navController = navController)
}



val groupe1= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DOMAYO ","Garnizon","699 59 84 83","") ,
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EMERAUDE","Maroua Kakataré","677 19 71 71",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DE MAROUA","Pont Vert","692 31 64 43",""),
)
val groupe1p= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DOMAYO ","Garnizon","699 59 84 83","") ,
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EMERAUDE","Maroua Kakataré","677 19 71 71",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DE MAROUA","Pont Vert","692 31 64 43",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE HORIZON","Carrefour Para","695 24 89 87","")
)

val groupe2= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EL RAPHA","Maroua Pitoaré","695 95 43 13",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EXTREME NORD","Artisanat","699 85 47 27",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE FERNGO","Carrefour Djarma","242 06 95 40","")
)

val groupe2p= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EL RAPHA","Maroua Pitoaré","695 95 43 13",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE EXTREME NORD","Artisanat","699 85 47 27",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE FERNGO","Carrefour Djarma","242 06 95 40","") ,
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE HORIZON","Carrefour Para","695 24 89 87","")
)

val groupe3= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU CENTRE " ,"NZiko","699 50 05 47",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU BOULEVARD","Domayo deux voies","699 66 40 47",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE KALIAO","Kakataré carrefour PTT","242 05 11 16",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE HORIZON","Carrefour Para","695 24 89 87","")
)

val groupe3p= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU CENTRE " ,"NZiko","699 50 05 47",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU BOULEVARD","Domayo deux voies","699 66 40 47",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE KALIAO","Kakataré carrefour PTT","242 05 11 16",""),
)

val groupe4= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DE DOUGOI","Dougoi","697 18 13 07",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE MASSEBOEUF","Bamare Maoundiyo","698 02 57 20",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU SAHEL","Domaya Papa Guinness","679 88 00 00",""),
)

val groupe4p= mutableListOf<Pharmacie>(
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DE DOUGOI","Dougoi","697 18 13 07",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE MASSEBOEUF","Bamare Maoundiyo","698 02 57 20",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE DU SAHEL","Domaya Papa Guinness","679 88 00 00",""),
    Pharmacie(R.drawable.image_pharmacie,"PHARMACIE HORIZON","Carrefour Para","695 24 89 87","")
)


@SuppressLint("SuspiciousIndentation")
fun addPharmaciesgarde(liste: MutableList<pharmacies_garde>){
    val db = FirebaseFirestore.getInstance()
      liste.forEach{
          db.collection("pharmacies_garde")
              .add(it)
              .addOnSuccessListener(OnSuccessListener {

              })
              .addOnFailureListener(OnFailureListener {

              })
      }

}

