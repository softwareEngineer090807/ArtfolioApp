package com.example.artfolio.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.artfolio.R

class FullScreenFragment : Fragment(R.layout.fragment_full_screen) {
    private val args: FullScreenFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val imageView = view.findViewById<ImageView>(R.id.fullScreenImage)
        val closeBtn = view.findViewById<View>(R.id.btnClose)
        
        // Load image full screen
        Glide.with(this)
            .load(args.imageResId)
            .into(imageView)
            
        closeBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
