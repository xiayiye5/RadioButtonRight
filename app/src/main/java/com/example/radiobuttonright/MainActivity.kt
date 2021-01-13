package com.example.radiobuttonright

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var tvData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvData = findViewById(R.id.tvData)
    }

    fun goToJava(view: View) {
        //获取开关状态
        val trim: String = tvData.text.toString().trim()
        val intent = Intent(this, SelectActionActivityJava::class.java)
        intent.putExtra("switch", trim)
        startActivityForResult(
            intent, 10010
        )
    }

    fun goToKotlin(view: View) {
        //获取开关状态
        val trim: String = tvData.text.toString().trim()
        val intent = Intent(this, SelectActionActivityKotlin::class.java)
        intent.putExtra("switch", trim)
        startActivityForResult(
            intent, 10010
        )
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10010 && null != data) {
            val switchStatus = data.getStringExtra("switch_status")
            tvData.text = switchStatus
        }
    }
}