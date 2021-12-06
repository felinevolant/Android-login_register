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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoUpdatePhoneActivity extends AppCompatActivity implements View.OnClickListener {

    //电话号码正则判断
    public final static String PHONE_PATTERN = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    private EditText etUpdateNormal3;
    private TextView tvUpdateNormal3;
    private Button btUpdateNormal3;

    private MyHelper myHelper;

    private int operation;
    private String username;
    private String phone;

    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_update_phone);

        Intent intent = getIntent();
        //String operation=intent.getStringExtra("operation");
        username = intent.getStringExtra("username");
        phone=intent.getStringExtra("phone");
        title = intent.getStringExtra("title");


        Bundle bundle=this.getIntent().getExtras();
        operation = bundle.getInt("operation");
        Log.d("operation",String.valueOf(operation));

        //initView要放在下面
        initView();
        //为提交按钮设置监听器
        btUpdateNormal3.setOnClickListener(this);

        //初始化数据库
        myHelper=new MyHelper(this);
    }


    public void initView(){
        etUpdateNormal3=findViewById(R.id.etUpdateNormal3);
        tvUpdateNormal3=findViewById(R.id.tvUpdateNormal3);
        btUpdateNormal3=findViewById(R.id.btUpdateNormal3);


        tvUpdateNormal3.setText(title);
        etUpdateNormal3.setText(phone);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdateNormal3:
                phone=etUpdateNormal3.getText().toString().trim();
                if(isPhoneMatchered(PHONE_PATTERN,phone)){
                    myHelper.updatePhone(username,phone);
                    Toast.makeText(this, "修改电话成功", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent();
                    intent1.putExtra("phone",phone);
                    setResult(RESULT_OK,intent1);
                    finish();
                }else{
                    Toast.makeText(this, "请输入11位电话号码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 电话正则表达式匹配判断
     * @param patternStr 匹配规则
     * @param input 需要做匹配操作的字符串
     * @return true if matched, else false
     */
    public static boolean isPhoneMatchered(String patternStr, CharSequence input) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}