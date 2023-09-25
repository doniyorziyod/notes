package uz.ictschool.notes.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.ictschool.notes.database.Types

@Entity(tableName = "task_table")
class Task(
    @ColumnInfo(name = "name")
    val name:String,
    @Embedded
    val type: Types,
    val date:String,
    val time:String,
    var isCompleted:Boolean = false
//    var imgPath:String
){
    @PrimaryKey(autoGenerate = true)
    var taskId:Int = 0
}
