package cn.deu.bztc.happyidiom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import cn.deu.bztc.happyidiom.service.AndioService;

/**
 * Created by Administrator on 2017/6/8.
 */

public class SetActivity extends Activity {

    private Switch switchMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        switchMusic=(Switch) findViewById(R.id.switchMusic);
        switchMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    //开始服务
                    startService(new Intent(SetActivity.this,AndioService.class));
                }else{
                    //停止服务
                    stopService(new Intent(SetActivity.this,AndioService.class));
                }
            }
        });
    }
}
