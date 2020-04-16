package com.naing.likeandunlike

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class Main : AppCompatActivity(), View.OnClickListener {
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (num == 0) txtResult.text = (String.format(getString(R.string.txt_like), num.toString()))

        btnLike.setOnClickListener(this)
        btnUnlike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLike -> {
                num++
                txtResult.text = String.format(getString(R.string.txt_like), num.toString())
                imageLike.setVisibility(View.VISIBLE)
                imageUnlike.setVisibility(View.INVISIBLE)
            }
            R.id.btnUnlike -> {
                num--
                if (num < 0) num = 0
                txtResult.text = String.format(getString(R.string.txt_like), num.toString())
                imageLike.setVisibility(View.INVISIBLE)
                imageUnlike.setVisibility(View.VISIBLE)
            }
        }
    }
}