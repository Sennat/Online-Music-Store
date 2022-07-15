package com.project.onlinemusicsearch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.project.onlinemusicsearch.R
import com.project.onlinemusicsearch.data.SongCatalog
import com.project.onlinemusicsearch.databinding.SongsListItemBinding

class SongCatalogAdapter(private val songsList: List<SongCatalog>, private val accessSong: (SongCatalog) -> Unit,) : RecyclerView.Adapter<SongCatalogAdapter.SongCatalogViewHolder>() {

    inner class SongCatalogViewHolder(private val binding: SongsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(songCatalog : SongCatalog) {
            binding.txtAlbum.text =  songCatalog.trackName
            binding.txtArtistName.text = songCatalog.artistName
            binding.txtPrice.text = "Price $ ${songCatalog.trackPrice.toString()}"

            Glide.with(binding.txtAlbum)
                .load(songCatalog.artworkUrl100)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.artwork)

            // Open song detail here
            binding.root.setOnClickListener {
                accessSong(songCatalog)
                Snackbar.make(it, "${songCatalog.trackName} is playing", 10000).show()
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
}
