package com.example.stadium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Csa extends Fragment01{

    private View view;
    private EditText a,b,c,d;
    private Button m;
    private String tel,date,time,spn;
    private int i;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_csa,container,false);
//        a = view.findViewById(R.id.et_1);
        b = view.findViewById(R.id.et_2);
        c = view.findViewById(R.id.et_3);
        d = view.findViewById(R.id.et_4);
        m = view.findViewById(R.id.o_sbtn);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tel = a.getText().toString();
                spn = b.getText().toString();
                date = c.getText().toString();
                time = d.getText().toString();
                Subscribe subscribe = new Subscribe();
                subscribe.setChoose_sport(spn);
                subscribe.setChoose_date(date);
                subscribe.setChoose_time(time);
                List<Custom> customList = DataSupport.select("id").where("account = ?",MainActivity.ina).find(Custom.class);
                i = customList.get(0).getId();
                Custom custom0 = DataSupport.find(Custom.class,i);
                subscribe.setCustom(custom0);
                subscribe.saveThrows();
                if(subscribe.save()){
                    Toast.makeText(getActivity(),"下单成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"下单失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
