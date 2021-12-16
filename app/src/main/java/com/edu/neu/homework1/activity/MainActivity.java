package com.edu.neu.homework1.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.neu.homework1.dao.MyHelper;
import com.edu.neu.homework1.R;
import com.edu.neu.homework1.entity.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView showName;
    MyHelper myHelper;
    User huntUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化数据库
        myHelper=new MyHelper(this);

        initView();

        //要在 MainActivity 中加入一个缓存数据的判断才行
        /*
        可以看到，这里在 onCreate()方法的一开始先从 SharedPreferences 文件中读取缓存数据，
        如果不为 null 就说明之前已经请求过天气数据了，那么就没必要让用户再次选择城市，而是直
        接跳转到 WeatherActivity 即可。
         */
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences
                (this);
        if (prefs.getString("weather", null) != null) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }


    }

    @Override
    public void onClick(View v) {

    }

    public void initView(){
        //实例化控件
        showName=findViewById(R.id.showName);



        //实现在主页显示登陆者的姓名
        Bundle bundle2 = this.getIntent().getExtras();
        huntUser=(User) bundle2.getSerializable("FindUser");
        String thisUsername = huntUser.getUsername();
        huntUser=myHelper.findUserByUsername(thisUsername);
        Log.d("msg",huntUser.getAddress());

        if(huntUser!=null){
            showName.setText(huntUser.getUsername());
        }else{
            Toast.makeText(this, "没获得到用户", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //活动界面上加载菜单（memu菜单文件）
        this.getMenuInflater().inflate(R.menu.menu_layout,menu);
        this.setTitle("Weather Today");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                String thisUsername = huntUser.getUsername();
                huntUser=myHelper.findUserByUsername(thisUsername);
                //点击进入修改活动的activity
                // bundle
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("FindUser",huntUser);
                //intent
                Intent intent3 = new Intent(this, InfoActivity.class);
                intent3.putExtras(bundle3);
                //intent2.putExtras(bundle2);

                // navigate
                startActivity(intent3);
                break;
            case R.id.item2:
                Intent intent4 = new Intent(this,ChooseAreaActivity.class);
                startActivity(intent4);
                Toast.makeText(this, "切换城市", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }
}