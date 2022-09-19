package com.example.dinetodoorapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dinetodoorapp.databinding.ActivityCheckoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dinetodoorapp.databinding.ActivityCheckoutBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import userCheckout

class checkout : AppCompatActivity()
{

    private lateinit var binding: ActivityCheckoutBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState:

                          Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.confirmbtn1.setOnClickListener {

            val fullname = binding.fullnametxtbox.text.toString()
            val phone = binding.phonenotxtbox.text.toString()
            val email = binding.emailtxtbox.text.toString()
            val address = binding.addresstxtbox.text.toString()
            val additionalnotes = binding.notestxtbox.toString()
            val payment= binding.payment.toString()
            val location = binding.location.toString()

            database = FirebaseDatabase.getInstance().getReference("Checkout")

            val checkoutuser = userCheckout(fullname,phone,email,address,additionalnotes,payment,location)

            database.child(fullname).setValue(checkoutuser).addOnSuccessListener{
                Toast.makeText(this,"Checkout Successfull",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this,"Checkout Fail",Toast.LENGTH_SHORT).show()

            }
        }
    }



}
