package com.example.to_do.Model

data class  Data(var Id:Int ,  var taskName:String ,var taskText:String ,var taskTime :String)
{
    companion object{
        const val Table_Name="Data_Task"
        const val col_Id= "_id"
        const val col_task_Name="Task_Name"
        const val col_task_Text="Task_Text"
        const val col_time_task="Task_Time"
        const val Create_Table="create table $Table_Name($col_Id INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "$col_task_Name TEXT NOT NULL," +
                "$col_task_Text TEXT NOT NULL," +
                "$col_time_task TEXT NOT NULL" +
                ")"
        const val Delete_Table="DROP TABLE IF Exists $Create_Table"
    }
}
