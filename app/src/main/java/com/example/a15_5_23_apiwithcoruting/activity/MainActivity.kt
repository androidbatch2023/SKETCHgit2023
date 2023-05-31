package com.example.a15_5_23_apiwithcoruting.activity

import android.os.Bundle
import com.example.a15_5_23_apiwithcoruting.baseactivity.BaseActivity
import com.example.a15_5_23_apiwithcoruting.databinding.ActivityMainBinding
import com.example.a15_5_23_apiwithcoruting.fragment.OneFragment

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        loadFragment(OneFragment(), true, false)
    }

<<<<<<< HEAD
    fun fdsh(){
        print("")
    }
=======

    fun name():String{
        return  "Vatsal Bhavsar"
    }


>>>>>>> f8b55f6f4fa4b83c135e48e706b67330ffec965d
}