package com.example.artfolio.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.artfolio.R

class AboutFragment : Fragment(R.layout.fragment_about) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup social links interactions if buttons exist
        view.findViewById<View>(R.id.btnInstagram)?.setOnClickListener {
            openUrl("https://instagram.com")
        }
        
        view.findViewById<View>(R.id.btnWebsite)?.setOnClickListener {
            openUrl("https://example.com")
        }
        
        view.findViewById<View>(R.id.btnEmail)?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:contact@example.com")
            }
            startActivity(intent)
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
