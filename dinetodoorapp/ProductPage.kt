package com.example.dinetodoorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProductPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)


        val Button2 = findViewById<Button>(R.id.homebtn)
        Button2.setOnClickListener {
            val intent = Intent(this,Homepage::class.java)
            startActivity(intent)
        }
        val Button3 = findViewById<Button>(R.id.cartbtn)
        Button3.setOnClickListener {
            val intent = Intent(this,Cart::class.java)
            startActivity(intent)
        }

    }
}