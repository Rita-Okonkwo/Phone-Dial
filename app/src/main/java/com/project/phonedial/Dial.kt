package com.project.phonedial

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import es.dmoral.toasty.Toasty

class Dial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dial)



        val numText: TextView = findViewById(R.id.phone_text)
        val btn : Button = findViewById(R.id.dial_btn)

        //get intent and intent extra
        val num = intent.getIntExtra("number", 0)

        numText.text = num.toString()

        //make phone uri
        val phoneUri = "tel: " + numText.text

        //make implicit intent for phone dial
        btn.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_DIAL)
            intent2.setData(Uri.parse(phoneUri))

            if (intent2.resolveActivity(packageManager) != null) {
                startActivity(intent2)
            } else {
                Toast.makeText(this, "cannot find activity to resolve intent", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}
