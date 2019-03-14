package com.example.stadium;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {

    private Button button01,button02,button03;
    private ViewPager viewPager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment(){

        FragmentManager ft = getSupportFragmentManager();
        FragmentTransaction fm = ft.beginTransaction();
        fm.replace(R.id.frame,new Fragment01());
        fm.commit();
    }

    private void initView(){

        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);
        radioGroup = (RadioGroup) findViewById(R.id.radio);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    FragmentManager fm =getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    initBtn();
                    switch (checkedId){
                        case R.id.button01:
                            button01.setBackgroundColor(Color.parseColor("#2bccfc"));
                            ft.replace(R.id.frame,new Fragment01());
                            break;
                        case R.id.button02:
                            button02.setBackgroundColor(Color.parseColor("#2bccfc"));
                            ft.replace(R.id.frame, new Fragment02());
                            break;
                        case R.id.button03:
                            button03.setBackgroundColor(Color.parseColor("#2bccfc"));
                            ft.replace(R.id.frame, new Fragment03());
                            break;

                    }
                    ft.commit();
            }
        });
    }

    private void initBtn(){
        button01.setBackgroundColor(Color.parseColor("#ffffff"));
        button02.setBackgroundColor(Color.parseColor("#ffffff"));
        button03.setBackgroundColor(Color.parseColor("#ffffff"));
    }
}
