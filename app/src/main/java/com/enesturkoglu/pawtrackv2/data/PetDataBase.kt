package com.enesturkoglu.pawtrackv2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enesturkoglu.pawtrackv2.data.dao.PetDao
import com.enesturkoglu.pawtrackv2.data.model.PetEntity

@Database(
    entities = [PetEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PetDataBase:RoomDatabase(){
    abstract fun petDao(): PetDao
}