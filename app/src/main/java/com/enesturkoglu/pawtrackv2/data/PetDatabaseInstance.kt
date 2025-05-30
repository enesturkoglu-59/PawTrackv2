package com.enesturkoglu.pawtrackv2.data

import android.content.Context
import androidx.room.Room

object PetDatabaseInstance {

    @Volatile
    private var INSTANCE: PetDataBase? = null

    fun getDatabase(context: Context): PetDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PetDataBase::class.java,
                "pet_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}