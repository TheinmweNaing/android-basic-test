package com.naing.intentandactivity.kotlin

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.naing.intentandactivity.R
import kotlinx.android.synthetic.main.activity_main.*

class MainKotlinActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val KEY_ACTIVITY = "activity"
        val REQUEST_CODE = 0
    }

    var music = MediaPlayer()
    var isMusicPlayerStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPlayMusic.setOnClickListener(this)
        btnSA.setOnClickListener(this)
        btnSAFR.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvPlayMusic -> {
                music = MediaPlayer.create(applicationContext, R.raw.sayso)
                music.start()
                isMusicPlayerStarted = true
            }
            //TODO to test with extension function for Intent
            R.id.btnSA -> {
                val intent = Intent(this, NextKotlinActivity::class.java)
                val bundle = Bundle()
                bundle.putString(KEY_ACTIVITY, edText.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
            R.id.btnSAFR -> {
                val intent = Intent(this, NextKotlinActivity::class.java)
                val bundle = Bundle()
                bundle.putString(KEY_ACTIVITY, edText.text.toString())
                intent.putExtras(bundle)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) tvResult.text = data?.getStringExtra(KEY_ACTIVITY)
    }

    override fun onPause() {
        super.onPause()
        if (music != null) music.stop()
    }

    override fun onRestart() {
        super.onRestart()
        //TODO music reset
        if (isMusicPlayerStarted) {
            music = MediaPlayer.create(applicationContext, R.raw.sayso)
            music.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isMusicPlayerStarted = false
    }
}