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

public class Frag08 extends Fragment04{

    private View view;
    private Button btn1,btn2;
    private EditText ed1;
    private int idd;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.activity_frag08,container,false);
        btn1 = view.findViewById(R.id.o_btn1);
        btn2 = view.findViewById(R.id.o_btn2);
        ed1 = view.findViewById(R.id.et_deletes);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idd = Integer.parseInt(ed1.getText().toString());
                DataSupport.delete(Sports.class,idd);
                Toast.makeText(getActivity(),"你已经删除该类型的场地信息", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Sports.class);
                Toast.makeText(getActivity(),"你已经删除所有场地信息", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
