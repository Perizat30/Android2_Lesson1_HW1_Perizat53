package com.example.android2_lesson1_hw1_perizat53.ui.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
   var id: Long? = null,
    var title: String? = null,
    var desc: String? = null,
) : java.io.Serializable

