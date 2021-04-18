package com.rk.progressbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setProgressButtonClickListener(object :
            RkProgressButton.ProgressButtonClickListner {
            override fun onClick(var1: View?) {
                btnLogin.progressAnimation()
                Handler(Looper.getMainLooper()).postDelayed({
                    btnLogin.errorAnimation()
                    Handler(Looper.getMainLooper()).postDelayed({

                    },2000)
                },2000)
            }
        })
    }
}