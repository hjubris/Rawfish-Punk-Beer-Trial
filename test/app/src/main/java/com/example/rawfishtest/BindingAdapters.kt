package com.example.rawfishtest

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rawfishtest.network.BeerModel
import com.example.rawfishtest.overview.BeerApiStatus
import com.example.rawfishtest.overview.BeerGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            //the placeholder to show while the image isn't loaded yet
            placeholder(R.drawable.loading_animation)
            //the image to show instead of the right picture when there are loading issues
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<BeerModel>?) {
    val adapter = recyclerView.adapter as BeerGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("beerApiStatus")
fun bindStatus(statusImageView: ImageView, status: BeerApiStatus?) {
    when (status) {
        BeerApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BeerApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_broken_image)
        }
        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}