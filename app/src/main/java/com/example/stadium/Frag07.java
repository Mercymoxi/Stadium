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

public class Frag07 extends Fragment04{

    private View view;
    private EditText a,b;
    private Button m,n;
    private int j,k;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.activity_frag07,container,false);
        a = view.findViewById(R.id.et_aid);
        b = view.findViewById(R.id.et_c);
        m = view.findViewById(R.id.o_btna1);
        n = view.findViewById(R.id.o_btna2);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = Integer.parseInt(a.getText().toString());
                k = Integer.parseInt(b.getText().toString());
                ContentValues values = new ContentValues();
                values.put("sports_num",k);
                DataSupport.update(Sports.class,values,j);
                Toast.makeText(getActivity(),"你已经成功修改场地数量", Toast.LENGTH_SHORT).show();
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = Integer.parseInt(a.getText().toString());
                k = Integer.parseInt(b.getText().toString());
                ContentValues values = new ContentValues();
                values.put("sports_price",k);
                DataSupport.update(Sports.class,values,j);
                Toast.makeText(getActivity(),"你已经成功修改场地数量", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
