package app.pam.aplikacjapam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class CalculateTicketsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_tickets)

        val concertBox = findViewById<TextView>(R.id.finalCost)
        val intent = intent;

        val cost = intent.getIntExtra("COST", 0)
        val number = intent.getIntExtra("NUMBER", 0)

        val tickets = cost * number;

        concertBox.text = tickets.toString()
    }
}