package com.example.to_do.Adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.DataBase.to_do_database
import com.example.to_do.Model.Data
import com.example.to_do.databinding.CardBinding

class ToDoAdapter( var activity :Activity , var Data:ArrayList<Data>): RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {
    class  MyViewHolder(var binding :CardBinding):RecyclerView.ViewHolder(binding.root)
    val db= to_do_database(activity)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val binding =CardBinding.inflate(activity.layoutInflater,parent,false)
    return MyViewHolder(binding)
    }

    fun deleteItem(p0: Int) {
        val item: Data = Data[p0]
        db.DeleteTask(item.Id)
        Data.removeAt(p0)
        notifyItemRemoved(p0)
    }

    override fun onBindViewHolder(holder: MyViewHolder, p0: Int) {
        holder.binding.txtTitle.text=Data[p0].taskName
        holder.binding.txt.text=Data[p0].taskText
        holder.binding.txttime.text=Data[p0].taskTime
    }

    override fun getItemCount(): Int {
    return  Data.size
    }

}
