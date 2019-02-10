package com.example.stadium;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stadium.utils.MD5Utils;
public class LoginActivity extends AppCompatActivity {

    private Button login_button,register_button,forgetpassword;             //获取登陆按钮
    private String username,password,sppassword;   //获取的用户名，密码，加密密码
    private EditText username_et,password_et;    //编辑框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init(){
        register_button = findViewById(R.id.register_button1);
        login_button = findViewById(R.id.login_button1);
        forgetpassword =  findViewById(R.id.forgetpassword_button1);
        username_et=findViewById(R.id.username_et1);
        password_et=findViewById(R.id.password_et1);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "你点击了忘记密码按钮", Toast.LENGTH_SHORT).show();
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始登陆，获取用户和密码
                username=username_et.getText().toString().trim();
                password=password_et.getText().toString().trim();
                String md5Paw = MD5Utils.md5(password); //对当前用户输入的密码进行MD5加密再进行对比判断是否一致
                sppassword = ReadPassWord(username);
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else if (md5Paw.equals(sppassword)){
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    saveLoginStatus(true,username); //保存登陆状态，再节目保存登陆的用户名，定义个方法 saveLoginStatus boolean状态，username用户名
                    Intent data = new Intent();    //登陆成功后进入主页
                    data.putExtra("isLogin",true);
                    setResult(RESULT_OK,data); //表示此页面下的内容操作成功将data返回到上一页面，如果时用back返回过去的则不存在用setResult传递data值
//                    LoginActivity.this.finish();//跳转到主界面，登陆成功的状态传递到MainActivity中
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else if (sppassword!= null && !TextUtils.isEmpty(sppassword) && !md5Paw.equals(sppassword)){
                    Toast.makeText(LoginActivity.this, "输入的用户名和密码不一致", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "此用户名不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     *从SharedPreferences中根据用户名读取密码
     */
    private String ReadPassWord(String username){
        SharedPreferences sharedPreferences = getSharedPreferences("loginInfo",MODE_PRIVATE); //MODE_PRIVATE表示可以继续写入
        return sharedPreferences.getString(username,"");
    }

    /**
     * 保存登陆状态和登陆用户名到SharedPreferences中
     */
    private void saveLoginStatus(boolean status,String username){
        SharedPreferences sharedPreferences = getSharedPreferences("loginInfo",MODE_PRIVATE); //loginInfo表示文件名
        SharedPreferences.Editor editor = sharedPreferences.edit();      //获取编辑器
        editor.putBoolean("isLogin",status);  //存入boolean类型的登陆状态
        editor.putString("loginUserName",username);  // 存入登陆状态时的用户名
        editor.apply();      //提交修改
    }


    /**
     *
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data         数据
     */
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (data != null){

            String username = data.getStringExtra("username"); //获取注册界面传过来的用户名
            if (!TextUtils.isEmpty(username)){
                username_et.setText(username);   //设置用户名到username_et控件
                username_et.setSelection(username.length());  //username控件的setSelection方法来设置光标位置
            }
        }
    }
}
