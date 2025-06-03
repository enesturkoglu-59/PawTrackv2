package com.enesturkoglu.pawtrackv2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enesturkoglu.pawtrackv2.data.dao.PetDao
import com.enesturkoglu.pawtrackv2.data.dao.TaskDao
import com.enesturkoglu.pawtrackv2.data.model.PetEntity
import com.enesturkoglu.pawtrackv2.data.model.TaskEntity

@Database(
    entities = [PetEntity::class,TaskEntity::class],
    version = 2,
    exportSchema = false
)
abstract class PetDataBase:RoomDatabase(){
    abstract fun petDao(): PetDao
    abstract fun taskDao():TaskDao
}