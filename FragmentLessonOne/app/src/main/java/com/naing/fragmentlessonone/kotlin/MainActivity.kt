package com.naing.fragmentlessonone.kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.naing.fragmentlessonone.R
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_two.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var counter1 = 0
    var counter2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val btn = v as Button
        if (btn.text == getString(R.string.btn_one)) {
            counter1++
            val count = if (counter1 > 1) " times." else " time."
            textView1.text = getString(R.string.txt_one, counter1.toString() + count)
        } else {
            counter2++
            val count = if (counter2 > 1) " times." else " time."
            textView2.text = getString(R.string.txt_two, counter2.toString() + count)
        }
    }
}