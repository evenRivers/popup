package com.popup.qsj.filtrate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        bt.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"1111",Toast.LENGTH_SHORT).show();
        })
    }
}
