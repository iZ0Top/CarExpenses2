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

        with(holder.binding){
            date.text = expense.date
            odometer.text = expense.odometer.toString()
            description.text = expense.description
            detail.text = expense.detail
            partNum.text = expense.partNumber
            quantity.text = quantity.text.toString()
            sum.text = (expense.quantity * expense.prise).toString()
        }
    }

    class MyHolder(val binding: ItemExpenseBinding): RecyclerView.ViewHolder(binding.root){
        var date = binding.date
        var odometer = binding.odometer
        var description = binding.description
        var detail = binding.detail
        var partNum = binding.partNum
        var sum = binding.sum
        var quantity = binding.quantity
    }
}