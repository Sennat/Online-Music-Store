package com.project.onlinemusicsearch.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.project.onlinemusicsearch.R
import com.project.onlinemusicsearch.data.SongCatalog
import com.project.onlinemusicsearch.databinding.FragmentSongDetailsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SongDetailsFragment] factory method to
 * create an instance of this fragment.
 */
class SongDetailsFragment : Fragment() {

    companion object {
        const val KEY = "value"

        fun createInstance(songCatalog: SongCatalog): SongDetailsFragment {
            val fragment = SongDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY, songCatalog)
            fragment.arguments = bundle
            return fragment
        }
    }

    //private lateinit var songDetailBinding: FragmentSongDetailsBinding

    private val binding by lazy {
        FragmentSongDetailsBinding.inflate(layoutInflater)
    }

    lateinit var selectedSong: SongCatalog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        selectedSong = arguments?.getParcelable(KEY)!!

        binding.apply {
            txtAlbum.text = selectedSong.trackName
            txtSinger.text = selectedSong.artistName
            txtPrice.text = selectedSong.trackPrice.toString()


            //placeholder
            Glide.with(detailsAntwork)
                .load(selectedSong.artworkUrl100)
                .placeholder(R.drawable.ic_placeholder)
                .into(detailsAntwork)
        }

        return binding.root
    }

}