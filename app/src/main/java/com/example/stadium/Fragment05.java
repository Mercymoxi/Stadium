package com.example.stadium;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Fragment05 extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{

    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button button01,button02,button03,button04;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.activity_fragment05,container,false);
        initView();
        return view;
    }

    private void initView() {
        viewPager=(ViewPager)view.findViewById(R.id.viewpager01);

        list=new ArrayList<>();
        button01=(Button)view.findViewById(R.id.f01);
        button02=(Button)view.findViewById(R.id.f02);
        button03=(Button)view.findViewById(R.id.f03);
        button04=(Button)view.findViewById(R.id.f04);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);;
        button04.setOnClickListener(this);;

        //这些界面要也要一个一个先去实现
        list.add(new Frag09());
        list.add(new Frag10());
        list.add(new Frag11());
        list.add(new Frag12());


        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(),list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        initBtnListener();
        switch (i){
            case 0:
                button01.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
            case 1:
                button02.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
            case 2:
                button03.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
            case 3:
                button04.setBackgroundColor(Color.parseColor("#ff735c"));
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        initBtnListener();
        switch (v.getId()){
            case R.id.f01:
                button01.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(0);
                break;
            case R.id.f02:
                button02.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(1);
                break;
            case R.id.f03:
                button03.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(2);
                break;
            case R.id.f04:
                button04.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private void initBtnListener(){

        button01.setBackgroundColor(Color.parseColor("#ffffff"));
        button02.setBackgroundColor(Color.parseColor("#ffffff"));
        button03.setBackgroundColor(Color.parseColor("#ffffff"));
        button04.setBackgroundColor(Color.parseColor("#ffffff"));

    }
}
