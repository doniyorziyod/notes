package uz.ictschool.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.ictschool.notes.database.dao.TaskDao
import uz.ictschool.notes.database.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(ctx: Context) =
            Room.databaseBuilder(ctx.applicationContext, AppDatabase::class.java, "word_database")
                .createFromAsset("Data.db")
                .allowMainThreadQueries()
                .build()
    }
}
