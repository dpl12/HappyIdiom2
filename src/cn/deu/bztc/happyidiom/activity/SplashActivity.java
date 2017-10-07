package cn.deu.bztc.happyidiom.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Administrator on 2017/6/16.
 */

public class SplashActivity extends Activity{
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp=getPreferences(MODE_PRIVATE);
                boolean isFirst=sp.getBoolean("isFirst",true);
                Intent intent=new Intent();//意图对象
                if(isFirst){
                    //如果用户第一次安装或登录
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                    sp.edit().putBoolean("isFirst",false).commit();
                }else{
                    intent.setClass(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
