package com.example.android2_lesson1_hw1_perizat53.ui.onboard

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.android2_lesson1_hw1_perizat53.R
import com.example.android2_lesson1_hw1_perizat53.databinding.FragmentOnBoardPageBinding
import com.example.android2_lesson1_hw1_perizat53.utils.Preferences
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardPageFragment(private var onNextClick: () -> Unit,
                          private var onSkipClick: () -> Unit,) : Fragment() {

    private lateinit var binding: FragmentOnBoardPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOnBoardPageBinding.inflate(inflater,container,false)

        initViews()
        initListeners()

        return binding.root


    }

    private fun initListeners() {

        binding.btnNext.setOnClickListener{
            onNextClick.invoke()
        }
        binding.btnSkip.setOnClickListener{
            onSkipClick.invoke()
        }
        binding.btnStart.setOnClickListener{
            findNavController().navigate(R.id.navigation_home)

            Preferences(requireContext()).setBoardingShowed(true)

        }

    }
    private fun initViews() {

        val data = arguments?.getSerializable("onBoard") as BoardModel
        binding.imgBoard.setImageResource(data.image)
        binding.tvTitle.text=data.title
        binding.tvDesc.text=data.description

        //condition
        binding.btnSkip.isVisible=data.isLast==false//true,true,false(visible)
        binding.btnNext.isVisible=data.isLast==false// the same as btn skip
        binding.btnStart.isVisible=data.isLast==true //false,false,true(visible)

    }


}