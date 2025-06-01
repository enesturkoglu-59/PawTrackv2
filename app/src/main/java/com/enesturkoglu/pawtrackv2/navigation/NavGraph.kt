package com.enesturkoglu.pawtrackv2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enesturkoglu.pawtrackv2.screens.addpet.AddPetScreen
import com.enesturkoglu.pawtrackv2.screens.HomeScreen

@Composable
fun MyApp(){

    val navController = rememberNavController()
    NavHost(startDestination = AddPet, navController = navController ) {

        composable<AddPet> { AddPetScreen(navController = navController) }

        composable<Home> {
            val petId = it.arguments?.getInt("petIsd")
            HomeScreen(petId) }

    }

}