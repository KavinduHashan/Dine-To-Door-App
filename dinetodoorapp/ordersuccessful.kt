package com.example.ordersuccessful

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.dinetodoorapp.Homepage
import com.example.dinetodoorapp.R
import com.example.dinetodoorapp.displaystatus

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val shoppagebtn: Button = findViewById(R.id.shoppagebtn)
       val orderstatuspage: Button = findViewById(R.id.orderstatuspage)

        shoppagebtn.setOnClickListener {
            val intent = Intent(
                this,
                Homepage::class.java
            )
            startActivity(intent)
        }
        orderstatuspage.setOnClickListener {
            val intent = Intent(
                this,
                displaystatus::class.java
            )
            startActivity(intent)
        }
    }
}


