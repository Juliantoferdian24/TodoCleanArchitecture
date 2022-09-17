package com.ferdian.todocleanarchitecture.presentation.main.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ferdian.todocleanarchitecture.R
import com.ferdian.todocleanarchitecture.databinding.FragmentMainDetailBinding

class DetailMainFragment : Fragment(R.layout.fragment_main_detail) {

    private var _binding: FragmentMainDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainDetailBinding.bind(view)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}