package com.bangtiray.wvhelper.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import com.bangtiray.wvhelper.webview.src.Bangtiray


class MainActivity : AppCompatActivity() {

    private lateinit var myText:EditText
    private lateinit var myButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myText=findViewById(R.id.textUrl)
        myButton=findViewById(R.id.btnWebview)
        myButton.setOnClickListener {
            Bangtiray.showWebView(applicationContext, myText.text.toString(), "", false)
        }
    }
}
