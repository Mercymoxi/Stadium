package com.example.stadium;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stadium.utils.MD5Utils;
public class RegisterActivity extends AppCompatActivity {

    private Button register_button;
    private String  username,password,confirmpassword;   //用户名，密码，确认密码控件的获取值
    private EditText username_et,password_et,confirmpassword_et;


    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init(){
//        TextView back_text = (TextView) findViewById(R.id.back_text);   //返回按钮
        register_button = findViewById(R.id.register_button2);  //注册按钮
        username_et = findViewById(R.id.username_et2);
        password_et=findViewById(R.id.password_et2);
        confirmpassword_et=findViewById(R.id.confirmpassword_et2);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入在相应控件中的字符窜
                getEditString();
                //判断输入框内容
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(confirmpassword)){
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                }else if (!password.equals(confirmpassword)){
                    Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                }else if (isExistUserName(username)){
                    Toast.makeText(RegisterActivity.this, "此用户名已存在", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "账号注册成功", Toast.LENGTH_SHORT).show();
                    saveRegisterInfo(username,password);//把账号，密码和账号标识保存到sp里面
                    Intent data = new Intent();
                    data.putExtra("username",username);
                    setResult(RESULT_OK,data);//RESULT_OK为Activity系统常量，状态码为-1.表示此页面下的内容操作成功将data返回到上一页面，如果是用back返回过去的则不存在用setResult传递data
                    RegisterActivity.this.finish();
                }
            }
        });

    }

    /**
     * 获取控件中的字符窜
     */
    private void getEditString(){
        username = username_et.getText().toString().trim();
        password = password_et.getText().toString().trim();
        confirmpassword = confirmpassword_et.getText().toString().trim();
    }

    /**
     * 从SharedPreferences中读取输入的用户名，判断SharedPreferences中是否有此用户名
     */
    private boolean isExistUserName(String username){
        boolean has_username = false;
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPassword = sp.getString(username,""); //传入用户获取密码
        if (!TextUtils.isEmpty(spPassword)){
            has_username=true;
        }//如果密码不为空就保存这个用户名
        return has_username;
    }

    /**
     * 保存账号和密码到SharedPreferences中
     */
    private void saveRegisterInfo(String username,String password){
        String md5Psw = MD5Utils.md5(password);    //用MD5加密
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE); //loginInfo表示文件名
        SharedPreferences.Editor editor = sp.edit();  //获取编辑器
        editor.putString(username,md5Psw);  //以用户名为key，密码为value保存在SharedPreferences中，键值对
        editor.apply();  //提交修改
    }
}
