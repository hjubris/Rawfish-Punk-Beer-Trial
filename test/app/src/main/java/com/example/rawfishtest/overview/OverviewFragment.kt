package com.example.rawfishtest.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rawfishtest.R
import com.example.rawfishtest.databinding.FragmentOverviewBinding


class OverviewFragment : Fragment() {
//    private var _binding: FragmentOverviewBinding? = null
//    private val binding get() = _binding!!

    private val viewModel: OverviewViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout of this fragment
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.beersGrid.adapter = BeerGridAdapter()
//            BeerListener { beer ->
//            viewModel.onBeerClicked(beer)
//        })
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        recyclerView = binding.beersGrid
//    }
}