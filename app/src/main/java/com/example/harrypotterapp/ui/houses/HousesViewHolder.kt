package com.example.harrypotterapp.ui.houses

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterapp.domain.model.HousesInfo
import com.example.harrypotterapp.databinding.ItemHousesBinding

class HousesViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    private val binding=ItemHousesBinding.bind(view)
    fun render(housesInfo: HousesInfo, onItemSelected: (HousesInfo) -> Unit){

        binding.ivHouses.setImageResource(housesInfo.imagen)
        binding.parent.setOnClickListener{
            starRotationAnimation(binding.ivHouses, newLambda = {onItemSelected(housesInfo)})
            //onItemSelected(housesInfo)

        }

    }
    private fun starRotationAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{newLambda()}
            start()
        }

    }

}