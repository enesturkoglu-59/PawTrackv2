package com.enesturkoglu.pawtrackv2.repo

import com.enesturkoglu.pawtrackv2.data.dao.PetDao
import com.enesturkoglu.pawtrackv2.data.model.PetEntity
import kotlinx.coroutines.flow.Flow

class PetRepository(private val petDao: PetDao){

    fun getAllPets():Flow<List<PetEntity>>{
        return petDao.getAllPets()
    }

    suspend fun addPet(petEntity: PetEntity) {
        petDao.insertPet(petEntity)
    }
}