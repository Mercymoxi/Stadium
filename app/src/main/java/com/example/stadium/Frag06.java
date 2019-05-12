package com.example.stadium;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;


public class Frag06 extends Fragment04 {

    private EditText et_na,et_nu,et_pr;
    private Button o_btn;
    private String sportsname;
    private int sports_num,sports_price;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_frag06,container,false);
        o_btn = view.findViewById(R.id.o_btn);
        et_na = view.findViewById(R.id.et_sportsname);
        et_nu = view.findViewById(R.id.et_sportsnum);
        et_pr = view.findViewById(R.id.et_sportsprice);

        o_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportsname = et_na.getText().toString();
                sports_num = Integer.parseInt(et_nu.getText().toString());
                sports_price = Integer.parseInt(et_pr.getText().toString());

                Sports sports = new Sports();
                sports.setName(sportsname);
                sports.setNum(sports_num);
                sports.setPrice(sports_price);
                sports.saveThrows();

//                Subscribe subscribe = new Subscribe();
//                subscribe.setChoose_date(date);
//                subscribe.setChoose_time(time);
//                subscribe.setChoose_sport(sports);
//                Custom custom0 = DataSupport.findLast(Custom.class);
//                subscribe.setCustom(custom0);
//                subscribe.saveThrows();

                if(sports.save()){
                    Toast.makeText(getActivity(),"添加成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"添加失败",Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(getActivity(),"每点一次按钮就会生成一个新的订单",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
