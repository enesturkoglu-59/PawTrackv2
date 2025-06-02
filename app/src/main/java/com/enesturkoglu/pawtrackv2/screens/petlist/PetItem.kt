package com.enesturkoglu.pawtrackv2.screens.petlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enesturkoglu.pawtrackv2.data.model.PetEntity
import com.enesturkoglu.pawtrackv2.navigation.Home

@Composable
fun PetItem(pet: PetEntity, navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { navController.navigate(Home(pet.id))  },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

                Text(text = "Ad: ${pet.name}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Yaş: ${pet.age}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Kilo: ${pet.weight}", style = MaterialTheme.typography.bodyMedium)


        }
    }
}