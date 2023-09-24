package uz.ictschool.notes.database.dao

import androidx.room.*
import androidx.room.Query
import uz.ictschool.notes.database.entity.Task

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM task_table")
    fun getTasks(): List<Task>

    @Query("SELECT * FROM task_table where type_name = :type")
    suspend fun getTasksByType(type: String): List<Task>

    @Query("SELECT * FROM task_table where date = :date")
    fun getTasksByDate(date: String): List<Task>

    @Query("SELECT * FROM task_table where date = :date || time = :time")
    fun getTasksByDateAndTime(date: String, time: String): List<Task>

    @Query("select count(type_name) from task_table where type_name = :type")
    fun getTaskCountByType(type: String): List<Int>

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY taskId DESC LIMIT 1")
    suspend fun getLastTask(): Task?
}