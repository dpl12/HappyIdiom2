package cn.deu.bztc.happyidiom.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import cn.deu.bztc.happyidiom.activity.R;

/**
 * Created by Administrator on 2017/6/8.
 */




public class AndioService extends Service {

    //重写onCreate()，onStartCommand()，onDestroy()方法。

    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    //服务第一次创建时调用
    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.actor);
        mediaPlayer.setLooping(true);//是否循环播放
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                stopSelf();
            }
        });
    }

    //每次服务启动时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            new Thread() {    //子线程
                @Override
                public void run() {
                    super.run();
                    mediaPlayer.start();
                }
            }.start();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    //服务销毁时调用，回收不再是用的资源
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }
}
