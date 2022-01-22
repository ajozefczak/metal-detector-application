package app.pam.aplikacjapam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ConcertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concert)

      val btnToTickets = findViewById<Button>(R.id.saveButton)
      btnToTickets.setOnClickListener(callReturnToConcert)
    }

    private val callReturnToConcert: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            callReturn()
        }
    }

    fun callReturn() {
        var returnIntent = Intent();
        val whenReturn = findViewById<EditText>(R.id.whenIsConcert)
        val whereReturn = findViewById<EditText>(R.id.whereIsConcert)
        val valueOne = whenReturn.text
        val valueTwo = whereReturn.text
        returnIntent.putExtra("WHEN", valueOne.toString())
        returnIntent.putExtra("WHERE", valueTwo.toString())
        setResult(RESULT_OK, returnIntent);
        Toast.makeText(this, "Ustawiono", Toast.LENGTH_SHORT).show()
        finish();
    }

}