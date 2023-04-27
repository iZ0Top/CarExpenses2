package com.alex.carexpenses.screens.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.alex.carexpenses.R
import com.alex.carexpenses.adapters.Adapter
import com.alex.carexpenses.databinding.FragmentListBinding
import com.alex.carexpenses.model.Expense
import com.alex.carexpenses.utils.APP_ACTIVITY
import com.alex.carexpenses.utils.LOG_TAG
import com.alex.carexpenses.utils.maxOdometer

class FragmentList : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: Adapter
    private lateinit var mObserver: Observer<List<Expense>>
    private lateinit var mViewModel: FragmentListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "FragmentList: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "FragmentList: onStart")

        mViewModel = ViewModelProvider(this).get(FragmentListViewModel::class.java)

        mAdapter = Adapter()
        mRecyclerView = binding.recyclerView
        mRecyclerView.adapter = mAdapter

        mObserver = Observer {
            mAdapter.setData(it.reversed())

            maxOdometer = 0
            for (x in it){
                if (x.odometer > maxOdometer){
                    maxOdometer = x.odometer
                }
            }
        }

        mViewModel.allExpenses.observe(viewLifecycleOwner, mObserver)

        binding.fab.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_fragmentList_to_fragmentAdd)
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.allExpenses.removeObserver(mObserver)
    }
}
