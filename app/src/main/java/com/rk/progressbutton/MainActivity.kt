package com.rk.progressbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var defultState = false
    var defult2State = false
    var changeColorState = false
    var iconState = false
    var heightState = false
    var customeDrawableButtonState = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defultBtn.setOnProgressClickListener({
            defultState = !defultState
            perfomDefultBtn(defultState, defultBtn)
        })

        defult2Btn.setOnProgressClickListener({
            defult2State = !defult2State
            perfomDefultBtn(defult2State, defult2Btn)
        })

        changeColorBtn.setOnProgressClickListener({
            changeColorState = !changeColorState
            perfomDefultBtn(changeColorState, changeColorBtn)
        })

        iconBtn.setOnProgressClickListener({
            iconState = !iconState
            perfomDefultBtn(iconState, iconBtn)
        })

        heightBtn.setOnProgressClickListener({
            heightState = !heightState
            perfomDefultBtn(heightState, heightBtn)
        })

        customeDrawableButton.setOnProgressClickListener({
            customeDrawableButtonState = !customeDrawableButtonState
            perfomDefultBtn(customeDrawableButtonState, customeDrawableButton)
        })



    }


    private fun perfomDefultBtn(state: Boolean, btn: RkProgressButton) {
        if (state) {
            btn.progressAnimation()
            Handler(Looper.getMainLooper()).postDelayed({
                btn.errorAnimation()
            }, 2000)
        } else {
            btn.progressAnimation()
            Handler(Looper.getMainLooper()).postDelayed({
                btn.doneAnimation()
            }, 2000)
        }
    }
}