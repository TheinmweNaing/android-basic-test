package com.naing.intentandactivity.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.naing.intentandactivity.R
import com.naing.intentandactivity.kotlin.MainKotlinActivity.Companion.KEY_ACTIVITY
import kotlinx.android.synthetic.main.activity_two.*

class NextKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val bundle = intent.extras
        val text = bundle?.getString(KEY_ACTIVITY)
        tvShowText.text = text

        rdGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbAndroid -> tvChoose.text = String.format(getString(R.string.txt_choose), "Android")
                R.id.rbSwift -> tvChoose.text = String.format(getString(R.string.txt_choose), "Swift")
                R.id.rbJava -> tvChoose.text = String.format(getString(R.string.txt_choose), "Java")
            }
        })

        btnFinish.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.putExtra(KEY_ACTIVITY, tvChoose.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }
}