package app.pam.aplikacjapam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToSongList = findViewById<Button>(R.id.songsButton)
        btnToSongList.setOnClickListener(toSongList)

        val btnToConcerSetter = findViewById<Button>(R.id.concertButton)
        btnToConcerSetter.setOnClickListener(toConcertSetter)

        val btnToTickets = findViewById<Button>(R.id.ticketButton)
        btnToTickets.setOnClickListener(toTicketCounter)

    }

    private val toSongList: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            goToSongs()
        }
    }

    private val toConcertSetter: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            goToConcert()
        }
    }

    private val toTicketCounter: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            goToTickets()
        }
    }

    private fun goToSongs() {
        val runSongsIntent = Intent(this, SongsActivity::class.java)
        startActivity(runSongsIntent)
    }

    private fun goToConcert() {
        val runSongsIntent = Intent(this, ShowConcertActivity::class.java)
        startActivity(runSongsIntent)
    }

    private fun goToTickets() {
        val runSongsIntent = Intent(this, TicketsActivity::class.java)
        startActivity(runSongsIntent)
    }
}