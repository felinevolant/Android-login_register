package com.edu.neu.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoUpdateEmailActivity extends AppCompatActivity implements View.OnClickListener {


    //邮箱自动补全的后缀
    private static final String[] emailSuffix = {
            "@qq.com", "@163.com", "@126.com", "@gmail.com", "@sina.com", "@foxmail.com", "@139.com"};

    private MultiAutoCompleteTextView emailMutiAutoupdate;
    private TextView tvUpdateNormal2;
    private Button btUpdateNormal2;

    private MyHelper myHelper;

    private int operation;
    private String username;
    private String email;

    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_update_email);

        Intent intent = getIntent();
        //String operation=intent.getStringExtra("operation");
        username = intent.getStringExtra("username");
        email=intent.getStringExtra("email");
        Log.d("hahaha",email);
        Log.d("heiheihei",username);
        title = intent.getStringExtra("title");


        Bundle bundle=this.getIntent().getExtras();
        operation = bundle.getInt("operation");
        Log.d("operation",String.valueOf(operation));

        //initView要放在下面
        initView();
        //为提交按钮设置监听器
        btUpdateNormal2.setOnClickListener(this);

        //初始化数据库
        myHelper=new MyHelper(this);
    }

    public void initView(){
        emailMutiAutoupdate=findViewById(R.id.emailMutiAutoupdate);
        tvUpdateNormal2=findViewById(R.id.tvUpdateNormal2);
        btUpdateNormal2=findViewById(R.id.btUpdateNormal2);

        //邮箱输入@自动联想
        MailBoxAssociateTokenizer tokenizer = new MailBoxAssociateTokenizer();
        //定义数据适配器
        ArrayAdapter<String> adapter=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,emailSuffix);
        //为emailsuffix设置数据适配器
        emailMutiAutoupdate.setAdapter(adapter);
        emailMutiAutoupdate.setTokenizer(tokenizer);

        tvUpdateNormal2.setText(title);
        emailMutiAutoupdate.setText(email);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdateNormal2:
                email=emailMutiAutoupdate.getText().toString().trim();
                myHelper.updateEmail(username,email);
                Toast.makeText(this, "修改邮箱成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.putExtra("email",email);
                setResult(RESULT_OK,intent1);
                finish();
                break;
        }

    }
}