package com.example.dinetodoorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class userprofile : AppCompatActivity() {


    /*private lateinit var txtfname : EditText
    private lateinit var txtemail : EditText
    private lateinit var txtuname: EditText
    private lateinit var txtcno : EditText
    private lateinit var txtaddress : EditText
    private lateinit var Regbtn : Button

    private lateinit var  dbref: DatabaseReference*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)




        val Button1 = findViewById<Button>(R.id.homebtn)
        Button1.setOnClickListener {
            val intent = Intent(this,Homepage::class.java)
            startActivity(intent)
        }
        val Button2 = findViewById<Button>(R.id.productbtn)
        Button2.setOnClickListener {
            val intent = Intent(this,ProductPage::class.java)
            startActivity(intent)
        }
        val Button3 = findViewById<Button>(R.id.cartbtn)
        Button3.setOnClickListener {
            val intent = Intent(this,Cart::class.java)
            startActivity(intent)
        }




       /* txtfname = findViewById(R.id.txtfname)
        txtemail = findViewById(R.id.txtemail)
        txtuname = findViewById(R.id.txtuname)
        txtcno   = findViewById(R.id.txtcno)
        txtaddress = findViewById(R.id.txtaddress)

        Regbtn = findViewById(R.id.Regbtn)


        dbref = FirebaseDatabase.getInstance().getReference("Users")

        Regbtn.setOnClickListener {

            saveUserData()
        }*/

    }

   /* private fun saveUserData()
    {
        val fname = txtfname.text.toString()
        val email = txtemail.text.toString()
        val uname = txtuname.text.toString()
        val cno   = txtcno.text.toString()
        val address = txtaddress.text.toString()

        if(fname.isEmpty()){
            txtfname.error = "Please enter name"
        }
        if (email.isEmpty()){
            txtemail.error = "Please enter email"
        }
        if (uname.isEmpty()){
            txtuname.error = "please enter username"
        }
        if(cno.isEmpty()){
            txtcno.error = "please enter contact no"
        }
        if(address.isEmpty()){
            txtaddress.error = "please enter address"
        }

        val userId = dbref.push().key!!

        val user = UserModel(userId, fname, email, uname, cno, address)

        dbref.child(userId).setValue(user)
            .addOnCompleteListener {
                Toast.makeText(this,"Data inserted successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this,"Error $err.get", Toast.LENGTH_LONG).show()

            }


    }*/
}