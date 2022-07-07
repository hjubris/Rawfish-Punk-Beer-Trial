package com.example.rawfishtest.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rawfishtest.databinding.GridViewItemBinding
import com.example.rawfishtest.network.BeerModel

class BeerGridAdapter
    //(val clickListener: BeerListener)
    :ListAdapter<BeerModel, BeerGridAdapter.BeerViewHolder>(DiffCallBack) {

    //Connects our code to layout files, so that the latter can access info about the item to be displayed
    class BeerViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            //clickListener: BeerListener,
            beerModel: BeerModel) {
            binding.beer = beerModel
            //binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BeerViewHolder(
            GridViewItemBinding.inflate(layoutInflater)
        )
    }

    //gets the item to be displayed and sends it to the bind function
    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer = getItem(position)
        holder.bind(beer)
           // clickListener,
        }

    //Checks which items in the list change, so that only those are updated in the view, and not the whole list
    companion object DiffCallBack : DiffUtil.ItemCallback<BeerModel>() {
        override fun areItemsTheSame(oldItem: BeerModel, newItem: BeerModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BeerModel, newItem: BeerModel): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

//function to send to the detail view,
//also used in the layout to make the card a clickable button
//class BeerListener(val clickListener: (beer: BeerModel) -> Unit) {
//    fun onCLick(beer: BeerModel) = clickListener(beer)
//}
