package com.example.likemypost

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    var like:Int = 0
    var dislike:Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        textViewLike.text = like.toString()
        textViewDislike.text = dislike.toString()

        imageViewLike.setOnClickListener(){
            like ++
            textViewLike.setText(like.toString())
        }

        imageViewDislike.setOnClickListener {
            dislike ++
            textViewDislike.setText(dislike.toString())
        }

    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")
        //Retrieve counters from the SharedPref
        like = sharedPreferences.getInt(getString(R.string.up), 0)
        dislike = sharedPreferences.getInt(getString(R.string.down), 0)

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.up), like)
            putInt(getString(R.string.down), dislike)
            apply()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestory")
        super.onDestroy()
    }

}
