package com.sintel.infopharmaciemaroua.`class`

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.sintel.infopharmaciemaroua.R

data class Pharmacie(
    val Image:Int,
    val name: String,
    val quartier: String,
    val phone: String,
    val email: String
)


data class pharmacies_garde(var periode:String, var groupe:MutableList<Pharmacie>)