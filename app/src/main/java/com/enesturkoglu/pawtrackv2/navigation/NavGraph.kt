package com.enesturkoglu.pawtrackv2.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enesturkoglu.pawtrackv2.screens.addpet.AddPetScreen
import com.enesturkoglu.pawtrackv2.screens.HomeScreen
import com.enesturkoglu.pawtrackv2.screens.addpet.AddPetScreenViewModel
import com.enesturkoglu.pawtrackv2.screens.petlist.PetListScreen
import com.enesturkoglu.pawtrackv2.screens.petlist.PetListScreenViewModel

@Composable
fun MyApp(){

    val context = LocalContext.current.applicationContext as Application
    val petListViewModel = remember { PetListScreenViewModel(context) }
    val addPetViewModel = remember {AddPetScreenViewModel(context)}
    val navController = rememberNavController()
    NavHost(startDestination = AddPet, navController = navController ) {

        composable<AddPet> { AddPetScreen(navController = navController, viewModel = addPetViewModel) }

        composable<PetList>{
            PetListScreen(navController=navController, viewModel =petListViewModel )
        }
        composable<Home> {
            val petId = it.arguments?.getInt("petId")
            HomeScreen(petId) }

    }

}