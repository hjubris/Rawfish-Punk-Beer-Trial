package com.example.rawfishtest.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rawfishtest.R

/**
 * A simple [Fragment] subclass.
 * Use the [DetailView.newInstance] factory method to
 * create an instance of this fragment.
 * TODO: implement this
 */
class DetailView : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_view, container, false)

    }
}