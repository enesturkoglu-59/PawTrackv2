package com.enesturkoglu.pawtrackv2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val petId:Int = 0,
    val taskName: String,
    val taskDate:String,
    val timestamp: Long

)