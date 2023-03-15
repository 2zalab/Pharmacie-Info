package com.sintel.infopharmaciemaroua.Screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.sintel.infopharmaciemaroua.R
import com.sintel.infopharmaciemaroua.nav.Screen


@Composable
fun SignUp (navController: NavController){
    val context = LocalContext.current
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordverification by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
       item {
           Image(
               painter = painterResource(id = R.drawable.create_account),
               contentDescription = null,
               modifier = Modifier
                   .size(250.dp)
                   .clip(CircleShape)
           )
           Text(
               text = "CREATION DE COMPTE",
               style = TextStyle(
                   fontWeight = FontWeight.Bold,
                   fontSize = 25.sp,
                   color = MyColors.primary
               )
           )

       }


       item {
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
                   .padding(16.dp, 16.dp, 16.dp, 0.dp)
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
                   .padding(16.dp, 16.dp, 16.dp, 0.dp)
           )

           OutlinedTextField(
               value = passwordverification,
               onValueChange = { passwordverification = it },
               label = {
                   Text(text = "Vérification de Mot de passe")
               },
               leadingIcon = {
                   Icon(imageVector = Icons.Default.Lock, contentDescription = "")
               },
               placeholder = { Text("Vérification Mot de passe") },
               visualTransformation = PasswordVisualTransformation(),
               keyboardOptions = KeyboardOptions.Default.copy(
                   keyboardType = KeyboardType.Password
               ),
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp)
           )

       }
       item {
           Button(
               onClick = {
                   if(password.isEmpty()|| phoneNumber.isEmpty()|| passwordverification.isEmpty()){
                       Toast.makeText(context,"Remplir tous les champs",Toast.LENGTH_SHORT).show()
                   }else if (password!=passwordverification){
                       Toast.makeText(context,"Vérification incorrecte",Toast.LENGTH_SHORT).show()
                   } else {
                       val user=user(phoneNumber,password)
                       saveData(user)
                       password = ""
                       phoneNumber=""
                       passwordverification=""
                       Toast.makeText(context,"Compté crée avec succès, Bien vouloir vous connectez!",Toast.LENGTH_SHORT).show()
                   }


               },
               modifier = Modifier
                   .padding(16.dp)
                   .fillMaxWidth(),
               colors = ButtonDefaults.buttonColors(
                   backgroundColor = MyColors.primary // Use the primary color
               )
           ) {
               Text(
                   "ENREGISTRER",
                   style=TextStyle(
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Bold
                   ),
                   color = Color.White
               )
           }

       }
       item {
           Text(
               text = "Se connecter",
               style = TextStyle(
                   fontSize = 14.sp,
                   fontWeight = FontWeight.Bold
               ),
               modifier = Modifier.clickable {
                   navController.navigate(Screen.Login.route){
                       popUpTo(Screen.Login.route) { inclusive = true }
                   }
               }
           )
       }
    }
}

fun saveData(user: user) {
    val db = FirebaseFirestore.getInstance()
    db.collection("users")
        .add(user)
        .addOnSuccessListener (OnSuccessListener {

        })
        .addOnFailureListener(OnFailureListener {

        })

}

data class user
    (
    var phone:String="",
    var password:String=""
)


@Preview(showBackground =true)
@Composable
fun SignUpPreWiew(){
    val navController = rememberNavController()
    SignUp(navController)
}