package com.example.dinetodoorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.findNavController

class ordersummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordersummary)

        //var subtotal from firebase database
        //set the cart items inside recycle view from the database
        // private RecyclerView: RecyclerView

        val confirmorder: Button = findViewById(R.id.checkoutbtn)
        val cancelorder: Button = findViewById(R.id.cancelorderbtn)


        confirmorder.setOnClickListener {
            val intent = Intent(
                this,
                Homepage::class.java
            )
            ContextCompat.startActivity(intent)
        }
        cancelorder.setOnClickListener {
            val intent = Intent(
                this,
                displaystatus::class.java
            )
            ContextCompat.startActivity(intent)
        }


        private val sharedViewModel: PaymentSharedViewModel by activityViewModels()
        private var binding: ActivityOrdersummaryBinding? = null


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val activityBinding = ActivityOrdersummaryBinding.inflate(inflater, container, false)
            binding = activityBinding
            return activityBinding.root
        }


        //assign checkoutorderhistory_layout xml file to recycler view to display the products in the cart from database
        /*   override protected fun onCreate(
            savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
             setContentView(R.layout.checkoutorderhistory_layout)

            recyclerView1 = findViewById(R.id.recycleview1)
            recyclerView1.setHasFixedSize=true
            linearLayoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = linearLayoutManager
        }      */

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            super.onViewCreated(view, savedInstanceState)


            binding?.apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = sharedViewModel
                checkoutbtn.setOnClickListener {
                          //navigate to order success page
                    intent=sendOrder(R.id.)
                    startActivity(intent)

                    //send an email or sms or both to customer
                }

            }
        }


        //get the variable from the firebase database or from the sharedViewModel
        fun sendOrder() {
            val order_summary=getString(R.string.order_details,
                sharedViewModel.fullname.value.toString(),
                sharedViewModel.address.value.toString(),
                sharedViewModel.phoneno.value.toString(),
                sharedViewModel.price.value.toString(),
                sharedViewModel.total.value.toString(),
                sharedViewModel.email.value.toString())
        }
        //send SMS
        setContentView(R.layout.activity_ordersuccessful)
        //  if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        val cust: String = cust.text.toString()
        val reg: String = reg.text.toString()
        val pal: String = pal.text.toString()
        val data: String =
            "CUST : ".plus(cust).plus("\n").plus("REG : ").plus(reg).plus("\n").plus("PAL : ")
                .plus(pal)
        startActivity(getSendSmsIntent(phoneno, data))

        //send email

        val cust: String = custTextField.text.toString()
        val reg: String = regTextField.text.toString()
        val pal: String = palTextField.text.toString()
        val data:String = "CUST : ".plus(cust).plus("\n").plus("REG : ").plus(reg).plus("\n").plus("PAL : ").plus(pal)
        startActivity(Intent.createChooser(getEmailIntent(email, order_details, data), "DIENTODOOR NEW ORDER"))
    }
}

//send SMS
fun getSendSmsIntent(phoneno: String, content: String?): Intent? {
    val uri = Uri.parse("smsto:$phoneno")
    val intent = Intent(Intent.ACTION_SENDTO, uri)
    intent.putExtra(order_details, content)
    return getIntent(intent, true)
}

//send email
private fun getEmailIntent(email: String, new_order: String?, order_details: String?): Intent? {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "message/rfc822"
    intent.putExtra(Intent.EXTRA_EMAIL, email)
    intent.putExtra(Intent.EXTRA_SUBJECT,new_order )
    intent.putExtra(Intent.EXTRA_TEXT, order_details)
    return getIntent(intent, true)
}

private fun getIntent(intent: Intent, isNewTask: Boolean): Intent? {
    return if (isNewTask) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) else intent
}





override fun onDestroyView() {
    super.onDestroyView()
    binding=null









    }
}