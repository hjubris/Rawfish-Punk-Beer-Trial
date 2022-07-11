package com.example.rawfishtest.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.rawfishtest.R
import com.example.rawfishtest.databinding.FragmentDetailViewBinding
import com.example.rawfishtest.overview.OverviewViewModel

/**
 * The class that should inflate and display the detail page
 */
class DetailViewFragment : Fragment() {

    private val viewModel: OverviewViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val binding = FragmentDetailViewBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        binding.viewModel = viewModel

        return inflater.inflate(R.layout.fragment_detail_view, container, false)
    }

}