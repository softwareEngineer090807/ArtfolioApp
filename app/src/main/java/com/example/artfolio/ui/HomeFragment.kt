package com.example.artfolio.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artfolio.R
import com.example.artfolio.adapter.ArtAdapter
import com.example.artfolio.viewmodel.ArtViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    // Use activityViewModels to share data/scope if needed, or by viewModels for local
    private val viewModel: ArtViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(context, 2)
        
        val adapter = ArtAdapter { item ->
            // Navigate to FullScreenFragment with argument
            val action = HomeFragmentDirections.actionHomeFragmentToFullScreenFragment(item.imageResId)
            findNavController().navigate(action)
        }
        recycler.adapter = adapter

        viewModel.allArt.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }
    }
}
