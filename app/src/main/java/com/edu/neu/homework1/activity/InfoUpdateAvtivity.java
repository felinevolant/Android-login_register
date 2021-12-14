package com.edu.neu.homework1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.neu.homework1.dao.MyHelper;
import com.edu.neu.homework1.R;

public class InfoUpdateAvtivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUpdateNormal;
    private TextView tvUpdateNormal;
    private Button btUpdateNormal;

    private MyHelper myHelper;

    private int operation;
    private String password;
    private String username;
    private String realname;
    private String age;
    private String address;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_update_avtivity);


        Intent intent = getIntent();
        //String operation=intent.getStringExtra("operation");
        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");
        realname = intent.getStringExtra("realname");
        age = intent.getStringExtra("age");
        address=intent.getStringExtra("address");
        title = intent.getStringExtra("title");
        //Log.d("msg",password);

        Bundle bundle=this.getIntent().getExtras();
         operation = bundle.getInt("operation");
         Log.d("operation",String.valueOf(operation));

         //initView要放在下面
        initView();
        //为提交按钮设置监听器
        btUpdateNormal.setOnClickListener(this);

        //初始化数据库
        myHelper=new MyHelper(this);
    }

    public void initView(){
        etUpdateNormal=findViewById(R.id.etUpdateNormal);
        tvUpdateNormal=findViewById(R.id.tvUpdateNormal);
        btUpdateNormal=findViewById(R.id.btUpdateNormal);

        tvUpdateNormal.setText(title);
        //etUpdateNormal.setText(password);

        //不同的类型在editText中显示不同的
        switch (operation){
            case R.id.updatePassword:
                etUpdateNormal.setText(password);
                break;
            case R.id.updateRealName:
                etUpdateNormal.setText(realname);
                break;
            case R.id.updateAge:
                etUpdateNormal.setText(age);
                break;
            case R.id.updateAdress:
                etUpdateNormal.setText(address);
                break;


        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btUpdateNormal:
                switch (operation){
                    //操作的值代表更改密码
                    case R.id.updatePassword:
                        password=etUpdateNormal.getText().toString().trim();
                        Log.d("newPass",password);
                        Log.d("username",username);
                        if(password!=null){
                            myHelper.updatePassword(username,password);
                            Toast.makeText(this, "修改密码成功", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent();
                            intent1.putExtra("password",password);
                            setResult(RESULT_OK,intent1);
                            finish();
                        }else{
                            Toast.makeText(this, "密码不能输入空值", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.updateRealName:
                        realname=etUpdateNormal.getText().toString().trim();
                        myHelper.updateRealName(username,realname);
                        Toast.makeText(this, "修改真实姓名成功", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent();
                        intent1.putExtra("realname",realname);
                        setResult(RESULT_OK,intent1);
                        finish();
                        break;

                    case R.id.updateAge:
                        age=etUpdateNormal.getText().toString().trim();
                        myHelper.updateAge(username,age);
                        Toast.makeText(this, "修改年龄成功", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent();
                        intent2.putExtra("age",age);
                        setResult(RESULT_OK,intent2);
                        finish();
                        break;

                    case R.id.updateAdress:
                        address=etUpdateNormal.getText().toString().trim();
                        myHelper.updateAddress(username,address);
                        Toast.makeText(this, "修改地址成功", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent();
                        intent3.putExtra("address",address);
                        setResult(RESULT_OK,intent3);
                        finish();
                        break;
                }
                break;
        }
    }
}