package com.example.radiobuttonright;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;


/**
 * @author xiayiye5
 * @date 2021.1.13 11:36
 * 类描述 选择添加动作页面
 */
public class SelectActionActivityJava extends Activity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rgLayout;
    private RadioButton rbTurnOn;
    private RadioButton rbTurnOff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        initView();
        initData();
    }


    public void initView() {
        rgLayout = findViewById(R.id.rg_layout);
        rbTurnOn = findViewById(R.id.rb_turn_on);
        rbTurnOff = findViewById(R.id.rb_turn_off);

    }

    public void initData() {
        String switchStatus = getIntent().getStringExtra("switch");
        //开关状态回显
        if ("turn on".equals(switchStatus)) {
            rbTurnOn.setChecked(true);
            rbTurnOff.setChecked(false);
        } else if ("turn off".equals(switchStatus)) {
            rbTurnOff.setChecked(true);
            rbTurnOn.setChecked(false);
        }
        rgLayout.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Intent intent = new Intent();
        if (i == R.id.rb_turn_on) {
            rbTurnOn.setChecked(true);
            rbTurnOff.setChecked(false);
            //回调上个页面
            intent.putExtra("switch_status", "turn on");
        } else if (i == R.id.rb_turn_off) {
            rbTurnOn.setChecked(false);
            rbTurnOff.setChecked(true);
            intent.putExtra("switch_status", "turn off");
        }
        setResult(10086, intent);
        finish();
    }
}