package com.ferdian.todocleanarchitecture.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdian.todocleanarchitecture.R
import com.ferdian.todocleanarchitecture.databinding.FragmentMainHomeBinding
import com.ferdian.todocleanarchitecture.domain.product.entity.ProductEntity
import com.ferdian.todocleanarchitecture.presentation.extension.gone
import com.ferdian.todocleanarchitecture.presentation.extension.showToast
import com.ferdian.todocleanarchitecture.presentation.extension.visible
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeMainFragment : Fragment(R.layout.fragment_main_home) {

    private var _binding: FragmentMainHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HomeMainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainHomeBinding.bind(view)
    }

    private fun setupRecyclerView(){
        val mAdapter = HomeProductAdapter(mutableListOf())
        mAdapter.setItemTapListener(object : HomeProductAdapter.OnItemTap{
            override fun onTap(product: ProductEntity) {
                val b = bundleOf("product_id" to product.id)
                findNavController().navigate(R.id.action_home_to_detail, b)
            }
        })
        binding.productsRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private fun observeState(){
        viewModel.mState
            .flowWithLifecycle(viewLifecycleOwner.lifecycle,  Lifecycle.State.STARTED)
            .onEach { state ->
                handleState(state)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeProducts(){
        viewModel.mProducts
            .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { products ->
                handleProducts(products)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observe(){
        observeState()
        observeProducts()
    }

    private fun handleState(state: HomeMainFragmentState){
        when(state){
            is HomeMainFragmentState.IsLoading -> handleLoading(state.isLoading)
            is HomeMainFragmentState.ShowToast -> requireActivity().showToast(state.message)
            is HomeMainFragmentState.Init -> Unit
        }
    }

    private fun handleLoading(isLoading: Boolean){
        if(isLoading){
            binding.loadingProgressBar.visible()
        }else{
            binding.loadingProgressBar.gone()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}