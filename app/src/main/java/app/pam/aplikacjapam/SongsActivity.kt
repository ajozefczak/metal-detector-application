package app.pam.aplikacjapam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class SongsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        val dataBaseHandler = DataBaseHelper(this, null, null, 1)
        val songOne = Song(0,"Soldier of Heaven", "Sabaton","The War to End All Wars", "2021", "heaven")
        val songTwo = Song(1, "Aces in Exile", "Sabaton","Coat of Arms", "2021", "arms")
        dataBaseHandler.addSong(songOne)
        dataBaseHandler.addSong(songTwo)

        val btnToSearch = findViewById<Button>(R.id.searchButton);
        btnToSearch.setOnClickListener(searchTheDatabase)
    }

    private val searchTheDatabase: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            goSearch()
        }
    }

    private fun goSearch() {
        val songName = findViewById<EditText>(R.id.songNameBox)
        val bandName = findViewById<EditText>(R.id.songBandNameBox)
        val dataBaseHelper = DataBaseHelper(this, null, null, 1)

        val song = dataBaseHelper.findSong(songName.text.toString(),
            bandName.text.toString())

        if (song != null) {
            //songName.setText(song.name)
            //bandName.setText(song.albumName)
            Toast.makeText(this, "Odnaleziono piosenkę!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ShowSpecificSongActivity::class.java)
            intent.putExtra("Song", song)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Brak piosenki!", Toast.LENGTH_SHORT).show()
        }
    }
}