package com.example.android2_lesson1_hw1_perizat53

import android.app.Application
import androidx.room.Room
import com.example.android2_lesson1_hw1_perizat53.database.local.room.TaskDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(this,
            TaskDatabase::class.java,
            "database").allowMainThreadQueries()
            .build()
    }
    companion object{
        lateinit var db: TaskDatabase
    }
}