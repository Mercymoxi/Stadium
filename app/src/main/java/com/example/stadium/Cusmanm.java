package com.example.stadium;

import android.content.ContentValues;
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

import java.util.List;


public class Cusmanm extends Fragment06 {

    private EditText et_aac,et_ana,et_aps,et_as,et_at,et_id;
    private Button o_btn;
    private String aa,an,ap,as,at;
    private int ic;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cusmanm,container,false);
        o_btn = view.findViewById(R.id.o_btn);
        et_aac =view.findViewById(R.id.aac);
        et_ana = view.findViewById(R.id.an);
        et_aps = view.findViewById(R.id.aps);
        et_as = view.findViewById(R.id.as);
        et_at = view.findViewById(R.id.at);
        et_id = view.findViewById(R.id.aid);

        o_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aa= et_aac.getText().toString();
                an= et_ana.getText().toString();
                ap= et_aps.getText().toString();
                as = et_as.getText().toString();
                at = et_at.getText().toString();
                ic = Integer.parseInt(et_id.getText().toString());

                ContentValues values = new ContentValues();
                values.put("account",aa);
                values.put("name",an);
                values.put("password",ap);
                values.put("sex",as);
                values.put("telephone",at);
                DataSupport.update(Custom.class,values,ic);
                Toast.makeText(getActivity(),"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}
