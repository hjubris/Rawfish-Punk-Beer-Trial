package com.example.rawfishtest.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rawfishtest.R
import com.example.rawfishtest.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
//    private var _binding: FragmentOverviewBinding? = null
//    private val binding get() = _binding!!

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout of this fragment
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.beersGrid.adapter = BeerGridAdapter()
        /**
         * This should use the navController created in MainActivity.kt, but the Logcat throws an error,
         * apparently no NavController is set for the ConstraintLayout in fragment_overview.xml
         */
//        binding.beersGrid.adapter = BeerGridAdapter(BeerListener { beer ->
//            viewModel.onBeerCLicked(beer)
//            findNavController().navigate(R.id.action_overviewFragment_to_detailView)
//        })

        return binding.root
    }
}