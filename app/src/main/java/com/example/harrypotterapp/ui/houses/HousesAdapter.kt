package com.example.harrypotterapp.ui.houses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterapp.R
import com.example.harrypotterapp.domain.model.HousesInfo

class HousesAdapter(private var housesList: List<HousesInfo> = emptyList(), private val onItemSelected:(HousesInfo)->Unit):
RecyclerView.Adapter<HousesViewHolder>() {
    fun updateList(list: List<HousesInfo>) {
        housesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HousesViewHolder {
        return HousesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_houses, parent, false)
        )

    }

    override fun getItemCount(): Int =housesList.size


    override fun onBindViewHolder(holder: HousesViewHolder, position: Int) {
        holder.render(housesList[position],onItemSelected)
    }

}