package com.example.harrypotterapp.ui.luck

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.example.harrypotterapp.R
import com.example.harrypotterapp.databinding.FragmentHousesBinding
import com.example.harrypotterapp.databinding.FragmentLuckBinding
import com.example.harrypotterapp.ui.providers.CardsProviders
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {
    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var randomCardProvider:CardsProviders

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initListener()
        preparePrediction()


    }

    private fun preparePrediction() {
        val luck=randomCardProvider.getLuck()
        luck?.let { binding.tvLucky.text=getString(it.text)
            binding.ivluckyCard.setImageResource(it.imagen)}
    }

    private fun initListener() {
        binding.ruleta.setOnClickListener { spinRoulette() }


    }

    private fun spinRoulette() {
        val random = java.util.Random()
        val degrees = random.nextInt(1440) + 360

        val animator = ObjectAnimator.ofFloat(binding.ruleta, View.ROTATION, 0f, degrees.toFloat())
        animator.duration=3000
        animator.interpolator= DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation= AnimationUtils.loadAnimation(requireContext(),R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                binding.reverse.isVisible=true
            }

            override fun onAnimationEnd(p0: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
        binding.reverse.startAnimation(slideUpAnimation)
    }

    private fun growCard() {
        val growAnimation=AnimationUtils.loadAnimation(requireContext(),R.anim.grow)
        growAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.reverse.isVisible=false
                premonitionView()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })
        binding.reverse.startAnimation(growAnimation)    }

    private fun premonitionView() {
        val disapearAnimation= AlphaAnimation(1.0f,0.0f)
        disapearAnimation.duration=200

        val appearAnimation= AlphaAnimation(0.0f,1.0f)
        appearAnimation.duration=1000

        disapearAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.preview.isVisible=false
                binding.prediction.isVisible=true
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })
        binding.preview.startAnimation(disapearAnimation)
        binding.prediction.startAnimation(appearAnimation)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}