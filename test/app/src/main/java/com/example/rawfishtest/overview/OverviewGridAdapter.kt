package com.example.rawfishtest.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rawfishtest.databinding.GridViewItemBinding
import com.example.rawfishtest.network.BeerModel

class BeerGridAdapter
//    private val clickListener: BeerListener
    : ListAdapter<BeerModel, BeerGridAdapter.BeerViewHolder>(DiffCallBack) {

    //Connects our code to layout files, so that the latter can access info about the item to be displayed
    class BeerViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            beerModel: BeerModel
//          clickListener: BeerListener,
        ) {
            binding.beer = beerModel
            binding.executePendingBindings()
//          binding.clickListener = clickListener
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
//        holder.bind(clickListener, beer)
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
/**
 * This class would be used in grid_view_item.xml, to make items clickable and to send that item to fragment_detail_view.xml
 */
//class BeerListener(val clickListener: (beer: BeerModel) -> Unit) {
//    fun onClick(beer: BeerModel) = clickListener(beer)
//}