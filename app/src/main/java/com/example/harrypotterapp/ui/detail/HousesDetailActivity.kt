package com.example.harrypotterapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypotterapp.databinding.ActivityHousesDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HousesDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHousesDetailBinding
    private lateinit var adapterDetail: HousesDetailAdapter

    private val args: HousesDetailActivityArgs by navArgs()
    private val housesDetailViewModel: HousesDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHousesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        housesDetailViewModel.getCharacter(args.type.name)
    }

    private fun initUI() {
        initState()
        initRecycler()
    }

    private fun initRecycler() {
        adapterDetail = HousesDetailAdapter()
        binding.rvHousesDetail.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterDetail
        }

    }

    private fun initState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                housesDetailViewModel.state.collect {
                    when (it) {
                        is HousesDetailState.Error -> TODO()
                        HousesDetailState.Loading -> {
                            binding.progressBar.isVisible = true
                        }

                        is HousesDetailState.Success -> {
                            binding.progressBar.isVisible = false
                            val characterList = it.characterList
                            adapterDetail.updateList(characterList!!)


                        }
                    }
                }
            }
        }
    }
}


