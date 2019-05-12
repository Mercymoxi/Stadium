package com.example.stadium;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

public class Csm extends Fragment01{

    private View view;
    private EditText a,b;
    private Button m,n,l;
    private int j;
    private String k;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_csm,container,false);
        a = view.findViewById(R.id.et_aid);
        b = view.findViewById(R.id.et_c);
        m = view.findViewById(R.id.o_btna1);
        n = view.findViewById(R.id.o_btna2);
        l = view.findViewById(R.id.o_btna3);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = Integer.parseInt(a.getText().toString());
                k = b.getText().toString();
                ContentValues values = new ContentValues();
                values.put("choose_sport",k);
                DataSupport.update(Subscribe.class,values,j);
                Toast.makeText(getActivity(),"成功修改场地的类型", Toast.LENGTH_SHORT).show();
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = Integer.parseInt(a.getText().toString());
                k = b.getText().toString();
                ContentValues values = new ContentValues();
                values.put("choose_date",k);
                DataSupport.update(Subscribe.class,values,j);
                Toast.makeText(getActivity(),"成功修改预约的日期", Toast.LENGTH_SHORT).show();
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = Integer.parseInt(a.getText().toString());
                k = b.getText().toString();
                ContentValues values = new ContentValues();
                values.put("choose_time",k);
                DataSupport.update(Subscribe.class,values,j);
                Toast.makeText(getActivity(),"成功修改预约的时间", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
