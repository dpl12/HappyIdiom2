package cn.deu.bztc.happyidiom.activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
/**
 * Created by Administrator on 2017/6/5.
 */

public class GameActivity extends Activity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void gamePlay(View view) {
        switch (view.getId()) {
            case R.id.tvGameGuess:
                intent=new Intent(this,GameGuessActivity.class);
                startActivity(intent);
                break;
            case R.id.tvGameConn:

                break;

            default:
                break;
        }
    }

}
