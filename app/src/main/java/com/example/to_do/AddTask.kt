package com.example.to_do

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do.DataBase.to_do_database
import com.example.to_do.databinding.AddNewTaskBinding

class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AddNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db= to_do_database(this)
        binding.btnSave.setOnClickListener {
            if(binding.txtName.text.isEmpty()||binding.txt.text.isEmpty()||binding.txtTime.text.isEmpty()){
                Toast.makeText(this,"Filed is Empty",Toast.LENGTH_SHORT).show()
            }else{
                if(db.insart_task(binding.txtName.text.toString(),binding.txt.text.toString(),binding.txtTime.text.toString())){
                    Toast.makeText(this,"Add Task Succeeded",Toast.LENGTH_SHORT).show()
                    val i =Intent(this,MainActivity::class.java)
                    startActivity(i)
                }else{
                    Toast.makeText(this,"Add Task Fill",Toast.LENGTH_SHORT).show()
                }

            }

}

    }
}