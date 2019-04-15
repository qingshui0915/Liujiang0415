package com.bawei.liujiang0415;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.liujiang0415.bean.LoginBean;
import com.bawei.liujiang0415.loginmvp.LoginConstract;
import com.bawei.liujiang0415.loginmvp.LoginPresenter;
import com.bawei.liujiang0415.loginmvp.ShowActivity;
import com.bawei.liujiang0415.zhucemvp.ZcActivity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements LoginConstract.IView {

    private LoginPresenter loginPresenter;
    private EditText login_name_et,login_pwd_et;
    private Button login_bt;
    private TextView login_zc;
    private String susername;
    private String spwd;
    private LoginBean loginBean;
    public static final String URL="http://172.17.8.100/small/user/v1/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter();
        loginPresenter.accth(this);

        login_name_et = findViewById(R.id.login_name_et);
        login_pwd_et = findViewById(R.id.login_pwd_et);
        login_bt = findViewById(R.id.login_bt);
        login_zc = findViewById(R.id.login_zc);
        //注册
        login_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZcActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //登录
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框中的用户名和密码
                susername = login_name_et.getText().toString();
                spwd = login_pwd_et.getText().toString();
                //非空判断
                if (!susername.isEmpty()&&!spwd.isEmpty()){
                    loginPresenter.login(URL,susername,spwd);
                }
            }
        });
    }

    @Override
    public void getDataPre(String data) {
        Gson gson = new Gson();
        if (!data.isEmpty()){
            loginBean = gson.fromJson(data, LoginBean.class);
            Toast.makeText(this,loginBean.getMessage(),Toast.LENGTH_LONG).show();
            if (loginBean.getStatus().equals("0000")){
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();

    }
}
