package com.example.to_do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.Adapters.ToDoAdapter
import com.example.to_do.DataBase.to_do_database
import com.example.to_do.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db=to_do_database(this)
        val data=db.getAllData()
        val adapter= ToDoAdapter(this,data)
        binding.rvTask.layoutManager=LinearLayoutManager(this)
        binding.rvTask.adapter=ToDoAdapter(this,data)
        binding.btnAdd.setOnClickListener {
            val i = Intent(this ,AddTask::class.java)
            startActivity(i)
        }
            val RecyclerTouchHelper = object : RecyclerTouchHelper(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    adapter.deleteItem(viewHolder.adapterPosition)
            }}
            val touchHelper = ItemTouchHelper(RecyclerTouchHelper)
            touchHelper.attachToRecyclerView(binding.rvTask)
    }}
