package com.example.harrypotterapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.network.response.CharacterResponse
import com.example.harrypotterapp.domain.model.CharacterModel

class HousesDetailAdapter(private var housesDetailList: List<CharacterModel> = emptyList()):
    RecyclerView.Adapter<HousesDetailViewHolder>() {
    fun updateList(list: List<CharacterModel>) {
        housesDetailList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HousesDetailViewHolder {
        return HousesDetailViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_houses, parent, false)
        )

    }

    override fun getItemCount(): Int = housesDetailList.size


    override fun onBindViewHolder(holder: HousesDetailViewHolder, position: Int) {
        holder.render(housesDetailList[position])
    }

}