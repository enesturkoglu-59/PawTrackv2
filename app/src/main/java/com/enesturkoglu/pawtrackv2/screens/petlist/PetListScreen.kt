package com.enesturkoglu.pawtrackv2.screens.petlist
import androidx.compose.foundation.lazy.items
import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.enesturkoglu.pawtrackv2.screens.addpet.AddPetScreenViewModel


@Composable
fun PetListScreen(viewModel: PetListScreenViewModel,navController: NavController) {
    val petList by viewModel.petList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(petList) { pet ->
            PetItem(navController = navController, pet = pet)
        }
    }
}

