package com.alex.carexpenses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.carexpenses.databinding.ItemExpenseBinding
import com.alex.carexpenses.model.Expense

class Adapter: RecyclerView.Adapter<Adapter.MyHolder>() {

    private var list = emptyList<Expense>()

    fun setData(list: List<Expense>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemExpenseBinding.inflate(layoutInflater, parent, false)
        return MyHolder(binding)
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val expense = list[position]
    }

    class MyHolder(val binding: ItemExpenseBinding): RecyclerView.ViewHolder(binding.root){
        val date = binding.date
        val odometer = binding.odometer
        val description = binding.description
        val detail = binding.detail
        val sum = binding.sum
        val quantity = binding.quantity
    }
}