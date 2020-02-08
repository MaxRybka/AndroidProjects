package com.example.first

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    val LOG_TAG : String = SecondActivity::class.java.name
    val EXTRA_REPLY : String = "com.example.first.extra.REPLY"

    private lateinit var mReply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mReply = findViewById(R.id.editText_second)
        val message = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message
    }

    fun returnReply(view: View) {
        val reply = mReply.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }
}
