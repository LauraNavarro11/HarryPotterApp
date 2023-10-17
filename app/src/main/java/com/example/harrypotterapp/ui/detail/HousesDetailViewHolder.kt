package com.example.harrypotterapp.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotterapp.data.network.response.CharacterResponse
import com.example.harrypotterapp.databinding.ItemDetailHousesBinding
import com.example.harrypotterapp.domain.model.CharacterModel

class HousesDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding=ItemDetailHousesBinding.bind(view)
    fun render(characterModel: CharacterModel){
        binding.tvHouseCharacter.text=characterModel.name
        binding.tvNameCharacter.text=characterModel.house
        Glide.with(binding.tvHouseCharacter.context).load(characterModel.image).into(binding.ivCharacters)



    }
}