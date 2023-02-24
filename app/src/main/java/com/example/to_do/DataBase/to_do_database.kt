package com.example.to_do.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.to_do.Model.Data

class to_do_database(context :Context): SQLiteOpenHelper(context,DataBase_Name,null,DataBase_Version) {
 private var  db: SQLiteDatabase
 init {
     db=this.writableDatabase
 }
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(Data.Create_Table)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL(Data.Delete_Table)
        onCreate(p0)
    }
 fun insart_task(TaskName:String , TaskText:String ,TimeTask:String):Boolean{
     val cv=ContentValues()
     cv.put(Data.col_task_Name,TaskName)
     cv.put(Data.col_task_Text,TaskText)
     cv.put(Data.col_time_task,TimeTask)
      return db.insert(Data.Table_Name,null,cv)>0
 }


    fun getAllData():ArrayList<Data>{
        val Tasks=ArrayList<Data>()
        val cursor=db.rawQuery("Select * from ${Data.Table_Name} order by ${Data.col_Id}",null)
        cursor.moveToFirst()
        while(!cursor.isAfterLast){
            val t=Data(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3))
            Tasks.add(t)
            cursor.moveToNext()
         }
        cursor.close()
        return Tasks
    }


    fun DeleteTask(id:Int):Boolean{
        return db.delete(Data.Table_Name,"${Data.col_Id}==$id",null)>0
    }




    fun updateTask(old_id:Int , TaskName:String , TaskText:String ,TimeTask:String):Boolean{
        val cv=ContentValues()
        cv.put(Data.col_task_Name,TaskName)
        cv.put(Data.col_task_Text,TaskText)
        cv.put(Data.col_time_task,TimeTask)
        return db.update(Data.Table_Name,cv,"${Data.col_Id}==$old_id",null)>0
    }



    companion object{
        const val DataBase_Name="Todo_db"
        const val DataBase_Version=1
    }
}