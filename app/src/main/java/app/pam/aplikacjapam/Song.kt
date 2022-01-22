package app.pam.aplikacjapam

import android.media.Image
import java.io.Serializable

class Song : Serializable {
    var id: Int
    var name: String
    var bandName: String
    var albumName: String
    var dateOfRecording: String
    var songImage: String

    constructor(id: Int, name: String, bandName: String, albumName: String, dateOfRecording: String, songImage: String){
        this.id = id
        this.name = name
        this.bandName = bandName
        this.albumName = albumName
        this.dateOfRecording = dateOfRecording
        this.songImage = songImage
    }
}