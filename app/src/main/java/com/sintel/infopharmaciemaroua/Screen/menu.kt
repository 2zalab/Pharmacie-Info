package com.sintel.infopharmaciemaroua.Screen

import android.app.AlertDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomDialog(
    //showDialog: Boolean,
    //onShowDialogChange: (Boolean) -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "Choisir une Options", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MyColors.primary)
        },
        text = {
            Column {
                DialogOption("Itinéraire", Icons.Default.Place, onClick = { /* Do something */ })
                DialogOption("Appeler", Icons.Default.Call, onClick = { /* Do something */ })
                DialogOption("Voir détails", Icons.Default.Info, onClick = { /* Do something */ })
            }
        },
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = {
                //run { onShowDialogChange(false) }
            }) {
                Text(text = "Fermer", color = MyColors.primary)
            }
        }
    )
}

@Composable
fun DialogOption(text: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview
@Composable
fun VoirMenu(){
    var showDialog by remember { mutableStateOf(false) }
    CustomDialog(
        //showDialog = showDialog,
       // onShowDialogChange = { showDialog = it }
    )
}
