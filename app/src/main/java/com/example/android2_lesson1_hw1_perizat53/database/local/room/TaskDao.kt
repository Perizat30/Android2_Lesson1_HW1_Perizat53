package com.example.android2_lesson1_hw1_perizat53.database.local.room

import androidx.room.*
import com.example.android2_lesson1_hw1_perizat53.ui.home.TaskModel

@Dao
interface TaskDao {

    @Insert
    fun insert(task: TaskModel?)

    @Delete
    fun delete(task: TaskModel?)

    @Query("SELECT * FROM TaskModel")
    fun getAllTasks(): List<TaskModel?>

    @Query("SELECT * FROM TaskModel ORDER BY id DESC")
    fun getAllTasksByDate(): List<TaskModel?>

    @Query("SELECT * FROM TaskModel ORDER BY title ASC")
    fun getAllTasksByAsc(): List<TaskModel?>

    @Query("SELECT * FROM TaskModel ORDER BY title DESC")
    fun getAllTasksByDesc(): List<TaskModel?>

    @Update
    fun update(task: TaskModel?)
}