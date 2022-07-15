package com.project.onlinemusicsearch.views.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.project.onlinemusicsearch.R
import com.project.onlinemusicsearch.enums.SongTypes
import com.project.onlinemusicsearch.adapters.SongCatalogAdapter
import com.project.onlinemusicsearch.apiServices.retrofit.MusicRetrofitApiService
import com.project.onlinemusicsearch.data.SongCatalog
import com.project.onlinemusicsearch.data.SongsResponse
import com.project.onlinemusicsearch.databinding.FragmentClassicBinding
import com.project.onlinemusicsearch.interfaces.MusicServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [ClassicFragment] factory method to
 * create an instance of this fragment.
 */
class ClassicFragment : Fragment(), MusicServices {

    private lateinit var fragmentClassicBinding: FragmentClassicBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentClassicBinding = FragmentClassicBinding.inflate(layoutInflater)

        var songTypes: SongTypes
        // Fetch "Rock" songs
        fetchSongs(SongTypes.CLASSICk.toString().uppercase())
        return fragmentClassicBinding.root
    }

    /**
     *  Fetch songs from api
     */
    override fun fetchSongs(type: String) {
        MusicRetrofitApiService.getRetrofitInstance()?.create(MusicRetrofitApiService::class.java)
            ?.getSongsCatalog(type)?.enqueue(object : Callback<SongsResponse> {

                override fun onResponse(
                    call: Call<SongsResponse>, response: Response<SongsResponse>
                ) {
                    if (response.isSuccessful) {
                        val songCatalogAdapter =
                            SongCatalogAdapter(response.body()!!.results, ::playSong)
                        fragmentClassicBinding.recyclerView.adapter = songCatalogAdapter
                    }
                }

                override fun onFailure(call: Call<SongsResponse>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                }
            })
    }

    /*private fun openSongDetailFragment(songCatalog: SongCatalog) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SongDetailsFragment.createInstance(songCatalog))
            .addToBackStack(null)
            .commit()
    }*/

    private fun playSong(songCatalog: SongCatalog) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(songCatalog.previewUrl), "audio/mp4")
        startActivity(intent)
    }

}