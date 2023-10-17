package com.example.harrypotterapp.ui.houses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypotterapp.databinding.FragmentHousesBinding
import com.example.harrypotterapp.domain.model.HousesInfo.*
import com.example.harrypotterapp.domain.model.HousesModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HousesFragment : Fragment() {
    private val housesViewModel by viewModels<HousesViewModel>()
    private lateinit var adapterHouses: HousesAdapter


    private var _binding: FragmentHousesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapterHouses =
            HousesAdapter(onItemSelected = {
                val type=when(it){
                    gryffindor -> HousesModel.gryffindor
                    hufflepuff -> HousesModel.hufflepuff
                    ravenclaw -> HousesModel.ravenclaw
                    slytherin -> HousesModel.slytherin
                }
                findNavController().navigate(
                HousesFragmentDirections.actionHousesFragmentToHousesDetailActivity(type)) })
        binding.rvHouses.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterHouses

        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                housesViewModel.houses.collect {
                    adapterHouses.updateList(it)


                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHousesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}