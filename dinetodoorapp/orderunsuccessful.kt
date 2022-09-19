package com.example.orderunsuccessful

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.dinetodoorapp.Homepage
import com.example.dinetodoorapp.R
import com.example.dinetodoorapp.checkout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toshop_page: Button = findViewById(R.id.toshop_page)
        val backbtn4 : ImageButton = findViewById(R.id.backbtn44)


        backbtn4.setOnClickListener {
            val intent = Intent(this, checkout :: class.java)     //navigate to checkout/delivery information page
            startActivity(intent)
        }
        toshop_page.setOnClickListener {
            val intent = Intent(this,Homepage :: class.java)     //navigate to shop page
            startActivity(intent)
        }
    }



}
}