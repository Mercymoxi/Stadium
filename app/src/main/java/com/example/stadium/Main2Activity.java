package com.example.stadium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText check;
    private String managerm,cc="learnandroid";
    private Button con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        check = findViewById(R.id.check);
        con = findViewById(R.id.confirm);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerm = check.getText().toString();
                if (managerm.equals(cc)){
                    Toast.makeText(Main2Activity.this,"管理员权限码正确，进入管理员页面",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                }else{
                    Toast.makeText(Main2Activity.this,"管理员权限码错误，请重新输入",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
