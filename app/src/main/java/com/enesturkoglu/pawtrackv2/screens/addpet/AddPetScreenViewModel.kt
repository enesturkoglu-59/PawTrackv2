package com.enesturkoglu.pawtrackv2.screens.addpet

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.enesturkoglu.pawtrackv2.data.PetDataBase
import com.enesturkoglu.pawtrackv2.data.PetDatabaseInstance
import com.enesturkoglu.pawtrackv2.data.PetEntity
import com.enesturkoglu.pawtrackv2.navigation.Home
import com.enesturkoglu.pawtrackv2.repo.PetRepository
import kotlinx.coroutines.launch

class AddPetScreenViewModel(aplication:Application):AndroidViewModel(aplication){

    var petNameValue by  mutableStateOf("")
    var petAgeValue  by mutableStateOf("")
    var petWeightValue by  mutableStateOf("")

    private val repository = PetRepository(PetDatabaseInstance.getDatabase(aplication).petDao())

    fun addPet(petEntity: PetEntity,navController: NavController){
        viewModelScope.launch {
            repository.addPet(petEntity)
            navController.navigate(Home(1))
        }
    }

    val pets = repository.getAllPets().asLiveData()
}