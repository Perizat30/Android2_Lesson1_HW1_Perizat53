package com.example.android2_lesson1_hw1_perizat53.database.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android2_lesson1_hw1_perizat53.database.local.room.TaskDao
import com.example.android2_lesson1_hw1_perizat53.ui.home.TaskModel

@Database(entities = [TaskModel::class],version=1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

}