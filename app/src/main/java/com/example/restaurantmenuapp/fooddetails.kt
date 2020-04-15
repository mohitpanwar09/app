package com.example.restaurantmenuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fooddetails.*

class fooddetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fooddetails)

        val bundle=intent.extras
        imageView.setImageResource(bundle!!.getInt("Image"))
        textView.text=bundle.getString("name")
        textView2.text=bundle.getString("des")
    }
}
