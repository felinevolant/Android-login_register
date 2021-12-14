package com.edu.neu.homework1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.neu.homework1.dao.MyHelper;
import com.edu.neu.homework1.R;

public class InfoUpdateGenderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvUpdateNormal1;
    private Button btUpdateNormal1;
    private RadioGroup rgGenderUpdate;
    private RadioButton rbfemale1,rbmale1,rbLGBTQ1;

    private MyHelper myHelper;

    private int operation;
    private String gender;
    private String username;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_update_gender);

        Intent intent = getIntent();
        //String operation=intent.getStringExtra("operation");
        username = intent.getStringExtra("username");
        gender = intent.getStringExtra("gender");
        Log.d("gender",gender);
        title = intent.getStringExtra("title");
        //Log.d("msg",password);

        Bundle bundle=this.getIntent().getExtras();
        operation = bundle.getInt("operation");
        Log.d("operation",String.valueOf(operation));

        //initView要放在下面
        initView();
        //为提交按钮设置监听器
        btUpdateNormal1.setOnClickListener(this);

        //初始化数据库
        myHelper=new MyHelper(this);
    }

    public void initView(){
        tvUpdateNormal1=findViewById(R.id.tvUpdateNormal1);
        btUpdateNormal1=findViewById(R.id.btUpdateNormal1);
        rgGenderUpdate=findViewById(R.id.rgGenderUpdate);
        rbfemale1=findViewById(R.id.rbfemale1);
        rbmale1=findViewById(R.id.rbmale1);
        rbLGBTQ1=findViewById(R.id.rbLGBTQ1);

        tvUpdateNormal1.setText(title);
        //etUpdateNormal.setText(password);

        //rbfemale1.setChecked(false);
       // rbLGBTQ1.setChecked(false);
        //rbmale1.setChecked(false);
        //rbfemale1.setChecked(true);

        if(gender.equals("female")){
            rbfemale1.setChecked(true);
        }else if(gender.equals("male")){
            rbmale1.setChecked(true);
        }else if(gender.equals("LGBTQ")){
            rbLGBTQ1.setChecked(true);
        }


        }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdateNormal1:
                int selected=rgGenderUpdate.getCheckedRadioButtonId();
                switch (selected){
                    case R.id.rbfemale1:
                        gender="female";
                        break;
                    case R.id.rbmale1:
                        gender="male";
                        break;
                    case R.id.rbLGBTQ1:
                        gender="LGBTQ";
                        break;
                }
                myHelper.updateGender(username,gender);
                Toast.makeText(this, "修改性别成功", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.putExtra("gender",gender);
                setResult(RESULT_OK,intent1);
                finish();
            break;
        }
    }
}