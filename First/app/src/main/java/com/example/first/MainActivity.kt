package com.example.first

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val LOG_TAG : String = MainActivity::class.java.name
    val EXTRA_MESSAGE : String = "com.example.first.extra.MESSAGE"
    val TEXT_REQUEST : Int = 1


    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message : String = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE,message)
        startActivityForResult(intent,TEXT_REQUEST)

    }

    public override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST && resultCode == RESULT_OK) {
            val reply = data!!.getStringExtra(SecondActivity().EXTRA_REPLY)
            mReplyHeadTextView.visibility = View.VISIBLE
            mReplyTextView.text = reply
            mReplyTextView.visibility = View.VISIBLE
        }

    }
}
