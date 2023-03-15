package com.sintel.infopharmaciemaroua.Screen

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.sintel.infopharmaciemaroua.R
import com.sintel.infopharmaciemaroua.nav.Screen
import okhttp3.internal.wait


@Composable
fun LoginScreen(navController: NavController) {

    val context= LocalContext.current
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 0.dp, 20.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
      //  verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Text(
            text = "CONNEXION",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = MyColors.primary//MaterialTheme.colors.primary
            )
        )

        OutlinedTextField(
            value = phoneNumber,
            label = {
                Text(text = "Téléphone")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "")
            },
            onValueChange = { phoneNumber = it },
            placeholder = { Text("Téléphone") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                    Text(text = "Mot de passe")
            },
            leadingIcon = {
                          Icon(imageVector = Icons.Default.Lock, contentDescription = "")
            },
            placeholder = { Text("Mot de passe") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = {

                if (phoneNumber.isEmpty() || password.isEmpty()){
                    Toast.makeText(context,"Remplir tous les champs!", Toast.LENGTH_SHORT).show()
                } else {
                    val user = user(phoneNumber,password)
                    val userlist=mutableListOf<user>()

                    val db = FirebaseFirestore.getInstance()
                    db.collection("users")
                        .whereEqualTo("phone", phoneNumber)
                        .whereEqualTo("password", password)
                        .get()
                        .addOnSuccessListener { resultat ->
                            if (resultat.size()>0) {
                                val u = resultat.documents[0].toObject(user::class.java)
                                if (u != null) {
                                    userlist.add(u)
                                }
                                Toast.makeText(context,"Connexion reussie!", Toast.LENGTH_SHORT).show()
                                navController.navigate(Screen.Home.route)

                            } else {
                                Toast.makeText(context,"Vous n'avez pas de compte, bien vouloir vous enregistrez!", Toast.LENGTH_SHORT).show()
                            }
                        }
                        .addOnFailureListener { exception ->
                            // une erreur s'est produite lors de la récupération des documents
                        }
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MyColors.primary)
        ) {
            Text(
                "CONNEXION",
                style=TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )
        }

        Text(
            text = "Créer un compte",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.clickable {
                navController.navigate(Screen.CreateCount.route)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VoirLogin(){
    val navController = rememberNavController()
    LoginScreen(navController)
}
