package com.example.radiobuttonright

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup

/**
 * @author xiayiye5
 * @date 2021.1.13 11:36
 * 类描述 选择添加动作页面
 */
class SelectActionActivityKotlin : Activity(), RadioGroup.OnCheckedChangeListener {
    private var rgLayout: RadioGroup? = null
    private var rbTurnOn: RadioButton? = null
    private var rbTurnOff: RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_action)
        initView()
        initData()
    }

    private fun initView() {
        rgLayout = findViewById(R.id.rg_layout)
        rbTurnOn = findViewById(R.id.rb_turn_on)
        rbTurnOff = findViewById(R.id.rb_turn_off)
    }

    private fun initData() {
        val switchStatus = intent.getStringExtra("switch")
        //开关状态回显
        if ("turn on" == switchStatus) {
            rbTurnOn!!.isChecked = true
            rbTurnOff!!.isChecked = false
        } else if ("turn off" == switchStatus) {
            rbTurnOff!!.isChecked = true
            rbTurnOn!!.isChecked = false
        }
        rgLayout!!.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(radioGroup: RadioGroup, i: Int) {
        val intent = Intent()
        if (i == R.id.rb_turn_on) {
            rbTurnOn!!.isChecked = true
            rbTurnOff!!.isChecked = false
            //回调上个页面
            intent.putExtra("switch_status", "turn on")
        } else if (i == R.id.rb_turn_off) {
            rbTurnOn!!.isChecked = false
            rbTurnOff!!.isChecked = true
            intent.putExtra("switch_status", "turn off")
        }
        setResult(10086, intent)
        finish()
    }
}