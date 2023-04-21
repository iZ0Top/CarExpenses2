package com.alex.carexpenses.screens.list

import android.os.Bundle
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

class FragmentList : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: Adapter
    private lateinit var mObserver: Observer<List<Expense>>
    private lateinit var mViewModel: FragmentListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(FragmentListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        mAdapter = Adapter()
        mRecyclerView = binding.recyclerView
        mRecyclerView.adapter = mAdapter


        mObserver = Observer {
            mAdapter.setData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}
