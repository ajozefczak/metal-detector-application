package app.pam.aplikacjapam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class TicketsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tickets)

        val btnToCalculateTickets = findViewById<Button>(R.id.calculateCost)
        btnToCalculateTickets.setOnClickListener(callChangeOfConcert)
    }

    private val callChangeOfConcert: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            goToCalculate()
        }
    }

    fun goToCalculate() {
        val runCalculateIntent = Intent(this, CalculateTicketsActivity::class.java)
        val costValue = findViewById<TextView>(R.id.ticketCostBox)
        val ticketNumberValue = findViewById<TextView>(R.id.ticketNumberBox)

        val valueOne = Integer.parseInt(costValue.text.toString())
        val valueTwo = Integer.parseInt(ticketNumberValue.text.toString())

        runCalculateIntent.putExtra("COST", valueOne)
        runCalculateIntent.putExtra("NUMBER", valueTwo)
        startActivity(runCalculateIntent)
    }
}