package com.naing.toastmessgejava

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class Main : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_two.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Button Two Kotlin", Toast.LENGTH_LONG).show()
        })

        btn_three.setOnClickListener(Click())

        btn_four.setOnClickListener(this)
        btn_five.setOnClickListener(this)
    }

    fun showToastMessage(v: View) {
        Toast.makeText(v.context, "Button One Kotlin", Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_four -> Toast.makeText(applicationContext, "Button Four Kotlin", Toast.LENGTH_LONG).show()
            R.id.btn_five -> Toast.makeText(applicationContext, "Button Five Kotlin", Toast.LENGTH_LONG).show()
        }
    }
}

class Click : View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(v?.context, "Button Three Kotlin", Toast.LENGTH_LONG).show()
    }

}
