package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.bean.Money
import com.example.myapplication.databinding.LayoutItemBinding

class MoneyAdapter(var context: Context, var list: MutableList<Money>) :
    RecyclerView.Adapter<MoneyAdapter.MyViewHolder>() {


    class MyViewHolder(view: LayoutItemBinding) : RecyclerView.ViewHolder(view.root) {
        var text = view.text


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view = LayoutItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.text.text = list.get(position).money


    }
}