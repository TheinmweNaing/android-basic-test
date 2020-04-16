package com.naing.textplay

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToggle.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                edText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                edText.inputType = InputType.TYPE_CLASS_TEXT
            }
        })

        btnCommand.setOnClickListener(View.OnClickListener {
            val ran = Random()
            val text = edText.text.toString()
            tvResult.text = text

            //set random text size
            tvResult.textSize = ran.nextInt(50).toFloat()
            //set random text color
            tvResult.setTextColor(Color.rgb(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255)))
            //set random text gravity
            when (ran.nextInt(3)) {
                0 -> tvResult.gravity = Gravity.START
                1 -> tvResult.gravity = Gravity.END
                2 -> tvResult.gravity = Gravity.CENTER_HORIZONTAL
            }
            //check text content and change gravity
            when (text.toLowerCase(Locale.getDefault())) {
                "left", "start" -> tvResult.gravity = Gravity.START
                "right", "end" -> tvResult.gravity = Gravity.END
                "center" -> tvResult.gravity = Gravity.CENTER_HORIZONTAL
            }
        })
    }


}