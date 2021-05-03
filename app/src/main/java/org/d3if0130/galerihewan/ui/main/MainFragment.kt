package org.d3if0130.galerihewan.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if0130.galerihewan.Hewan
import org.d3if0130.galerihewan.MainViewModel
import org.d3if0130.galerihewan.R
import org.d3if0130.galerihewan.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private lateinit var binding: FragmentMainBinding
    private lateinit var myAdapter: MainAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter()
        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(context,
                RecyclerView.VERTICAL)
            )
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, {
            myAdapter.updateData(it)
        })
    }
}