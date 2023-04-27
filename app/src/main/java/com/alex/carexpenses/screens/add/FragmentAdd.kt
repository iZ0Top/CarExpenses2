package com.alex.carexpenses.screens.add

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alex.carexpenses.R
import com.alex.carexpenses.databinding.FragmentAddBinding
import com.alex.carexpenses.model.Expense
import com.alex.carexpenses.utils.APP_ACTIVITY
import com.alex.carexpenses.utils.LOG_TAG
import com.alex.carexpenses.utils.maxOdometer
import com.alex.carexpenses.utils.showToast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FragmentAdd : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var mViewModel: FragmentAddViewModel
    lateinit var currentDate: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        mViewModel = ViewModelProvider(this).get(FragmentAddViewModel::class.java)

        val dateFormatter = SimpleDateFormat("yyyy MM dd HH:mm:ss" , Locale.US)
        currentDate = dateFormatter.format(Date())

        binding.date.text = currentDate
        binding.odometer.setText(maxOdometer.toString())

        binding.btnSave.setOnClickListener {
            validationData()
        }
    }
    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validationData() {

        if (binding.description.toString().isEmpty()){
            binding.description.error = "Empty !"
            return
        }

        if (binding.quantity.text.toString().isEmpty() || binding.quantity.text.toString().toInt() == 0){
            binding.quantity.error = "Empty or null !"
            return
        }

        val expense = Expense(
            date = currentDate,
            odometer = binding.odometer.text.toString().toInt(),
            description = binding.description.text.toString(),
            detail = binding.detail.text.toString(),
            partNumber = binding.partNum.text.toString(),
            type = 0,
            quantity =  binding.quantity.text.toString().toInt(),
            prise = binding.price.text.toString().toDouble()
        )
        mViewModel.insertExpense(expense) {
            Log.d(LOG_TAG, expense.toString())
            showToast("Expense added !")
            APP_ACTIVITY.navController.navigate(R.id.action_fragmentAdd_to_fragmentList)
        }
    }
}