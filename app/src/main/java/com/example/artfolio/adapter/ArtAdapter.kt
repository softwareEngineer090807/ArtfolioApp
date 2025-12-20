package com.example.artfolio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artfolio.R
import com.example.artfolio.model.ArtItem

class ArtAdapter(
    private var list: List<ArtItem> = emptyList(),
    private val onClick: (ArtItem) -> Unit
) : RecyclerView.Adapter<ArtAdapter.ViewHolder>() {

    class ViewHolder(val img: ImageView) : RecyclerView.ViewHolder(img)

    fun submitList(newList: List<ArtItem>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val img = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_art, parent, false) as ImageView
        return ViewHolder(img)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        // Use Glide if imageResId is a valid drawable, or fail gracefully
        // For local resources, Glide handles Int ids perfectly.
        Glide.with(holder.itemView.context)
            .load(item.imageResId)
            .centerCrop()
            .into(holder.img)

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount() = list.size
}
