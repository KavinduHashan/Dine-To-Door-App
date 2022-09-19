package com.example.dinetodoorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class paymentsharemodel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paymentsharemodel)


        private const val delivery_price=200.00



        class PaymentSharedViewModel: ViewModel() {

            val dateOptions: List<String> = getPickedupOptions()

            init{
                resetOrder()
            }

            private val _fullname = MutableLiveData<String>()
            val fullname : LiveData<String> = _fullname

            private val _phoneno = MutableLiveData<Int>()
            val phoneno : LiveData<Int> = _phoneno

            private val _address = MutableLiveData<String>()
            val address : LiveData<String> = _address

            private val _email = MutableLiveData<String>()
            val email : LiveData<String> = _email

            private val _notes = MutableLiveData<String>()
            val notes : LiveData<String> = _notes

            private val _homeOfOffice = MutableLiveData<String>()
            val homeOfHome : LiveData<String> = _homeOfOffice

            private val _price = MutableLiveData<Double>() //for subtotalprice
            val price : LiveData<Double> = _price

            private val _payMethod = MutableLiveData<String>()
            val payMethod : LiveData<String> = _payMethod

            private val _date = MutableLiveData<String>()
            val date : LiveData<String> = _date
            //  private var date = dateOptions[0]

            fun setfullname(fullname: String){
                _fullname.value= fullname
            }

            fun setphoneno(phoneno : Int){
                _phoneno.value = phoneno
            }

            fun setaddress(address: String){
                _address.value = address
            }

            fun setemail(email : String){
                _email.value = email
            }

            fun setnotes(notes : String){
                _notes.value = notes
            }

            fun sethomeOrOffice(homeOrOffice : String){
                _homeOfOffice.value = homeOrOffice
            }

            fun setprice(price: Double){
                _price.value = price
                updatePrice()
            }

            fun setdate(date: String){
                _date.value = date
            }

            fun hasNohomeOrOffice():Boolean{
                return homeOfHome.value.isNullOrEmpty()
            }

            fun setpayMethod(payMethod : String){
                _payMethod.value = payMethod
            }

            val dateOption: List<String> =getPickedupOptions()
            private fun getPickedupOptions(): List<String> {
                val Options= mutableListOf<String>()
                val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
                val calendar = Calendar.getInstance()
                repeat(5){
                    Options.add(formatter.format(calendar.time))
                    calendar.add(Calendar.DATE,1)
                }
                return Options
            }

            private fun resetOrder(){
                _fullname.value=""
                _email.value=""
                _payMethod.value=""
                _address.value=""
                _notes.value=""
                _phoneno.value=0
                _homeOfOffice.value=""
                _date.value=dateOptions[0]
                _price.value=0.0

            }

            private fun updatePrice(){
                var total_price = price + delivery_price
    }
}