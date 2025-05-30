package com.enesturkoglu.pawtrackv2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enesturkoglu.pawtrackv2.data.PetDatabaseInstance
import com.enesturkoglu.pawtrackv2.data.PetEntity
import com.enesturkoglu.pawtrackv2.navigation.Home
import kotlinx.coroutines.launch

@Composable
fun AddPetScreen(navController: NavController) {
    val petNameValue = remember { mutableStateOf("") }
    val petAgeValue = remember { mutableStateOf("") }
    val petWeightValue = remember { mutableStateOf("") }
    val context = LocalContext.current
    val db = remember { PetDatabaseInstance.getDatabase(context)}
    val dao = db.petDao()
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {}

            Box(
                modifier = Modifier
                    .offset(x = 45.dp, y = -40.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF7043))
                    .clickable {
                        // Fotoğraf ekleme işlemi burada olacak
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Photo",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = petNameValue.value ,
                onValueChange = {petNameValue.value  = it },
                label = { Text("Pet Name") }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = petAgeValue.value ,
                onValueChange = { petAgeValue.value = it },
                label = { Text("Pet Age") }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value =petWeightValue.value ,
                onValueChange = {petWeightValue.value  = it },
                label = { Text("Pet Weight") }
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                modifier = Modifier.size(width = 200.dp, height = 50.dp),
                onClick = { coroutineScope.launch {
                    dao.insertPet(PetEntity(name = petNameValue.value, age = petAgeValue.value, weight = petWeightValue.value))
               petNameValue.value=""
                navController.navigate(Home(10000))}   },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF5722),
                    contentColor = Color.White
                )
            ) {
                Text("Save")
            }
        }
    }
}