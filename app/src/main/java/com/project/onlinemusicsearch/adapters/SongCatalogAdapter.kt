package com.project.onlinemusicsearch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.onlinemusicsearch.R
import com.project.onlinemusicsearch.data.SongCatalog
import com.project.onlinemusicsearch.databinding.SongsListItemBinding

class SongCatalogAdapter(private val songsList: List<SongCatalog>, private val songDetail: (SongCatalog) -> Unit) : RecyclerView.Adapter<SongCatalogAdapter.SongCatalogViewHolder>() {
    private lateinit var songPreview: String

    inner class SongCatalogViewHolder(private val binding: SongsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(songCatalog : SongCatalog) {
            binding.txtAlbum.text =  songCatalog.trackName
            binding.txtArtistName.text = songCatalog.artistName
            binding.txtPrice.text = "$ ${songCatalog.trackPrice.toString()}"
            //songPreview = songCatalog.previewUrl

            Glide.with(binding.txtAlbum)
                .load(songCatalog.artworkUrl100)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.artwork)

            // Open song detail here
            binding.root.setOnClickListener {
                songDetail(songCatalog)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongCatalogViewHolder {
        return SongCatalogViewHolder(SongsListItemBinding.inflate( LayoutInflater.from(parent.context), parent, false))}

    override fun onBindViewHolder(holder: SongCatalogViewHolder, position: Int) {
        holder.onBind(songsList[position])
    }

    override fun getItemCount(): Int {
        return songsList.size
    }

    //fun clicable(view: View)
}
