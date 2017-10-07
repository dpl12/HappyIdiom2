package cn.deu.bztc.happyidiom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2017/6/5.
 */

public class GameGuessActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_guess);


    }
    public void startGame(View view){
        switch (view.getId()) {
            case R.id.ibStartGame:
                Intent intent=new Intent(this,PlayGuessActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }
}
