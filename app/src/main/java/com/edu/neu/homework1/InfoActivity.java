package com.edu.neu.homework1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 修改个人信息的页面
 */
public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    User findUser3;

    private EditText etUsername;
    private EditText etPassword;
    private EditText etRealName;
    private EditText etAge;
    private EditText etGender;
    private EditText etPhone;
    private EditText etAdress;
    private ImageView updatePassword;
    private ImageView updateRealName;
    private ImageView updateAge;
    private ImageView updateGender;
    private ImageView updateEmail;
    private ImageView updatePhone;
    private ImageView updateAdress;

    private MultiAutoCompleteTextView emailMutiAuto1;
    private Button btSubmit;
    private MyHelper myHelper;

    String username;
    String password;
    String realname;
    String age;
    String gender;
    String email;
    String phone;
    String address;

    //邮箱自动补全的后缀
    private static final String[] emailSuffix = {
            "@qq.com", "@163.com", "@126.com", "@gmail.com", "@sina.com", "@foxmail.com", "@139.com"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        initView();

        //初始化数据库
        myHelper=new MyHelper(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.item1);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_left_back); //修改actionbar左上角返回按钮的图标



    }

    public void initView(){
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        etRealName=findViewById(R.id.etRealName);
        etAge=findViewById(R.id.etAge);
        etGender=findViewById(R.id.etGender);
        etPhone=findViewById(R.id.etPhone);
        etAdress=findViewById(R.id.etAdress);

        //btSubmit=findViewById(R.id.btSubmit);

        emailMutiAuto1=findViewById(R.id.emailMutiAuto1);

        updatePassword=findViewById(R.id.updatePassword);
        updateRealName=findViewById(R.id.updateRealName);
        updateAge=findViewById(R.id.updateAge);
        updateGender=findViewById(R.id.updateGender);
        updateEmail=findViewById(R.id.updateEmail);
        updatePhone=findViewById(R.id.updatePhone);
        updateAdress=findViewById(R.id.updateAdress);
        //设置用户名只读
        etUsername.setInputType(InputType.TYPE_NULL);
        etPassword.setInputType(InputType.TYPE_NULL);
        etRealName.setInputType(InputType.TYPE_NULL);
        etAge.setInputType(InputType.TYPE_NULL);
        etPhone.setInputType(InputType.TYPE_NULL);
        etAdress.setInputType(InputType.TYPE_NULL);
        etGender.setInputType(InputType.TYPE_NULL);
        emailMutiAuto1.setInputType(InputType.TYPE_NULL);
        //etUsername.setTextColor(Color.GRAY);

        //提交按钮设置监听器
        //btSubmit.setOnClickListener(this);
        updatePassword.setOnClickListener(this);
        updateRealName.setOnClickListener(this);
        updateAge.setOnClickListener(this);
        updateGender.setOnClickListener(this);
        updateEmail.setOnClickListener(this);
        updatePhone.setOnClickListener(this);
        updateAdress.setOnClickListener(this);

        //邮箱输入@自动联想
        MailBoxAssociateTokenizer tokenizer = new MailBoxAssociateTokenizer();
        //定义数据适配器
        ArrayAdapter<String> adapter=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,emailSuffix);
        //为emailsuffix设置数据适配器
        emailMutiAuto1.setAdapter(adapter);
        emailMutiAuto1.setTokenizer(tokenizer);

        //实现在显示登陆者的所有信息
        Bundle bundle4 = this.getIntent().getExtras();
        findUser3=(User) bundle4.getSerializable("FindUser");
        if(findUser3!=null){
            etUsername.setText(findUser3.getUsername());
            etPassword.setText(findUser3.getPassword());
            etPhone.setText(findUser3.getPhone());
            etAdress.setText(findUser3.getAddress());
            emailMutiAuto1.setText(findUser3.getEmail());
            etRealName.setText(findUser3.getRealname());
            etAge.setText(findUser3.getAge());
            etGender.setText(findUser3.getGender());

            Log.d("msg",username +" de "+email);

        }else{
            Toast.makeText(this, "没获得到用户", Toast.LENGTH_SHORT).show();
        }

    }


    //activity类中的方法，实现返回键
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           /*
           case R.id.btSubmit:
               username=etUsername.getText().toString().trim();
               password=etPassword.getText().toString().trim();

               email=emailMutiAuto1.getText().toString().trim();
               phone=etPhone.getText().toString().trim();
               address=etAdress.getText().toString().trim();
               myHelper.update(username,password,realname,age,gender,email,phone,address);
               Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
               break;

            */

               //修改密码
           case R.id.updatePassword:
               username=etUsername.getText().toString().trim();
               password=etPassword.getText().toString().trim();
               int operation = R.id.updatePassword;
               String title = "密    码：";

               //传递整数需要用buddle
               Bundle bundle = new Bundle();
               Intent intent = new Intent(this, InfoUpdateAvtivity.class);
               intent.putExtra("username",username);
               intent.putExtra("password",password);
               intent.putExtra("operation",operation);
               bundle.putInt("operation",operation);
               intent.putExtra("title",title);
               intent.putExtras(bundle);
               startActivityForResult(intent,1);
               break;

               //修改真实姓名
           case R.id.updateRealName:
               realname=etRealName.getText().toString().trim();
               username=etUsername.getText().toString().trim();
               operation = R.id.updateRealName;
               String title1 = "真实姓名:";
               //传递整数需要用buddle
               Bundle bundle1 = new Bundle();
               Intent intent1 = new Intent(this, InfoUpdateAvtivity.class);
               intent1.putExtra("username",username);
               intent1.putExtra("realname",realname);
               intent1.putExtra("operation",operation);
               bundle1.putInt("operation",operation);
               intent1.putExtra("title",title1);
               intent1.putExtras(bundle1);
               startActivityForResult(intent1,2);
               break;

           //修改年龄
           case R.id.updateAge:
               age=etAge.getText().toString().trim();
               username=etUsername.getText().toString().trim();
               operation = R.id.updateAge;
               String title2 = "年    龄：";
               //传递整数需要用buddle
               Bundle bundle2 = new Bundle();
               Intent intent2 = new Intent(this, InfoUpdateAvtivity.class);
               intent2.putExtra("username",username);
               intent2.putExtra("age",age);
               intent2.putExtra("operation",operation);
               bundle2.putInt("operation",operation);
               intent2.putExtra("title",title2);
               intent2.putExtras(bundle2);
               startActivityForResult(intent2,3);
               break;

           //修改性别
           case R.id.updateGender:
               gender=etGender.getText().toString().trim();
               username=etUsername.getText().toString().trim();
               operation = R.id.updateAge;
               String title3 = "性    别：";
               //传递整数需要用buddle
               Bundle bundle3 = new Bundle();
               Intent intent3 = new Intent(this, InfoUpdateGenderActivity.class);
               intent3.putExtra("username",username);
               intent3.putExtra("gender",gender);
               intent3.putExtra("operation",operation);
               bundle3.putInt("operation",operation);
               intent3.putExtra("title",title3);
               intent3.putExtras(bundle3);
               startActivityForResult(intent3,4);
               break;

           //修改邮箱
           case R.id.updateEmail:
               email=emailMutiAuto1.getText().toString().trim();
               username=etUsername.getText().toString().trim();
               operation = R.id.updateEmail;
               String title4 = "邮    箱：";
               //传递整数需要用buddle
               Bundle bundle4 = new Bundle();
               Intent intent4 = new Intent(this, InfoUpdateEmailActivity.class);
               intent4.putExtra("username",username);
               intent4.putExtra("email",email);
               Log.d("email",email);
               intent4.putExtra("operation",operation);
               bundle4.putInt("operation",operation);
               intent4.putExtra("title",title4);
               intent4.putExtras(bundle4);
               startActivityForResult(intent4,5);
               break;

           //修改电话号码
           case R.id.updatePhone:
               phone=etPhone.getText().toString().trim();
               username=etUsername.getText().toString().trim();
               operation = R.id.updatePhone;
               String title5 = "电    话：";
               //传递整数需要用buddle
               Bundle bundle5 = new Bundle();
               Intent intent5 = new Intent(this, InfoUpdatePhoneActivity.class);
               intent5.putExtra("username",username);
               intent5.putExtra("phone",phone);
               Log.d("phone",phone);
               intent5.putExtra("operation",operation);
               bundle5.putInt("operation",operation);
               intent5.putExtra("title",title5);
               intent5.putExtras(bundle5);
               startActivityForResult(intent5,6);
               break;

           //修改地址
           case R.id.updateAdress:
               address=etAdress.getText().toString().trim();
               username=etUsername.getText().toString().trim();
               operation = R.id.updateAdress;
               String title6 = "电    话：";
               //传递整数需要用buddle
               Bundle bundle6 = new Bundle();
               Intent intent6 = new Intent(this, InfoUpdateAvtivity.class);
               intent6.putExtra("username",username);
               intent6.putExtra("address",address);
               Log.d("address",address);
               intent6.putExtra("operation",operation);
               bundle6.putInt("operation",operation);
               intent6.putExtra("title",title6);
               intent6.putExtras(bundle6);
               startActivityForResult(intent6,7);
               break;

       }

    }

    /**
     * 返回数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case 1:
                    String password1 = data.getStringExtra("password");
                    etPassword.setText(password1);
                    break;

                case 2:
                    String realname1 = data.getStringExtra("realname");
                    etRealName.setText(realname1);
                    break;

                case 3:
                    String age1 = data.getStringExtra("age");
                    etAge.setText(age1);
                    break;

                case 4:
                    String gender1=data.getStringExtra("gender");
                    etGender.setText(gender1);
                    break;

                case 5:
                    String email1=data.getStringExtra("email");
                    emailMutiAuto1.setText(email1);
                    break;

                case 6:
                    String phone1=data.getStringExtra("phone");
                    etPhone.setText(phone1);
                    break;

                case 7:
                    String address1=data.getStringExtra("address");
                    etAdress.setText(address1);
                    break;

            }
        }


        /*
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // SearchAddressInfo info = (SearchAddressInfo) data.getParcelableExtra("position");
            String password1 = data.getStringExtra("password");
            etPassword.setText(password1);
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
            // SearchAddressInfo info = (SearchAddressInfo) data.getParcelableExtra("position");
            String password1 = data.getStringExtra("password");
            etPassword.setText(password1);
        }

         */
    }


}