package com.enesturkoglu.pawtrackv2.screens.petlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.enesturkoglu.pawtrackv2.data.PetDatabaseInstance
import com.enesturkoglu.pawtrackv2.data.model.PetEntity
import com.enesturkoglu.pawtrackv2.repo.PetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PetListScreenViewModel(aplication:Application) :AndroidViewModel(aplication){

    val repository = PetRepository(PetDatabaseInstance.getDatabase(aplication).petDao())

    private val _petList = MutableStateFlow<List<PetEntity>>(emptyList())
    val petList: StateFlow<List<PetEntity>> = _petList
    init {
        viewModelScope.launch {
            repository.getAllPets().collect {
                _petList.value = it
            }
        }
    }

}