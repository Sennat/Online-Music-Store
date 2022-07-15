package com.project.onlinemusicsearch.interfaces

import com.project.onlinemusicsearch.data.SongCatalog

interface MusicServices {
    /**
     *  Fetch songs
     */
    fun fetchSongs(type: String)

    /**
     *  Play a preview of a selected song
     */
    fun playSong(songCatalog: SongCatalog)
}