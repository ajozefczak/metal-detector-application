package app.pam.aplikacjapam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ShowSpecificSongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_specific_song)

        setTheSong()
    }

    fun setTheSong() {
        var foundSong: Song = intent.getSerializableExtra("Song") as Song

        val sName = findViewById<TextView>(R.id.foundSongName)
        val aName = findViewById<TextView>(R.id.foundAlbuName)
        val bName = findViewById<TextView>(R.id.foundBandName)
        val dRecorded = findViewById<TextView>(R.id.foundRecorderDate)
        val iName = findViewById<ImageView>(R.id.songImage)

        sName.setText(foundSong.name)
        aName.setText(foundSong.albumName)
        bName.setText(foundSong.bandName)
        dRecorded.setText(foundSong.dateOfRecording)
        iName.setImageResource(R.mipmap.heaven)

        Toast.makeText(this, "Załadowano piosenkę", Toast.LENGTH_SHORT).show()
    }
}