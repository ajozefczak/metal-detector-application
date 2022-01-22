package app.pam.aplikacjapam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class ShowConcertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_concert)

        val btnToTickets = findViewById<Button>(R.id.setButton)
        btnToTickets.setOnClickListener(callChangeOfConcert)
    }

    private val callChangeOfConcert: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            callSecondActivityWithReturnParameters()
        }
    }

    fun callSecondActivityWithReturnParameters() {
        val intentWithResult = Intent(this, ConcertActivity::class.java)
        startActivityForResult(intentWithResult, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                val whenChange = findViewById<TextView>(R.id.dataValue)
                val whereChange = findViewById<TextView>(R.id.concertValue)

                val valueOne = data?.getStringExtra("WHEN")
                val valueTwo = data?.getStringExtra("WHERE")
                whenChange.setText(valueOne)
                whereChange.setText(valueTwo)
            }
        }
    }
}