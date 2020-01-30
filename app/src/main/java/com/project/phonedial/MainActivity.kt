package com.project.phonedial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toasty.Config.getInstance().apply()

        val editText : EditText = findViewById(R.id.edit_number)

        val btn : Button = findViewById(R.id.enter_btn)
        btn.setOnClickListener {
            val numString: Int = editText.text.toString().toInt()
            val intent = Intent(this, Dial::class.java)
            intent.putExtra("number", numString)
            Toasty.success(this, "Welcome! Get ready to dial!", Toast.LENGTH_SHORT, false).show();
            startActivity(intent)
        }

    }
}
