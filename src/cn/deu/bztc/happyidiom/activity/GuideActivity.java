package cn.deu.bztc.happyidiom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */

public class GuideActivity extends Activity {
    private ViewPager MvpGuide;
    private Button btnStart;
    private List<View> mviewList=new ArrayList<View>();
    int [] imgRes=new int[]{
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        InitData();
        btnStart= (Button) findViewById(R.id.button);
        MvpGuide= (ViewPager) findViewById(R.id.viewpager);
        MyPagerAdapter adapter=new MyPagerAdapter();
        MvpGuide.setAdapter(adapter);
        MvpGuide.setOnPageChangeListener(new MyListener());
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        });
    }
    /**创建初始化数据**/
    private void InitData() {
        for(int i=0;i<imgRes.length;i++){
            View inflater=getLayoutInflater().inflate(R.layout.guide_item,null);
            ImageView iv_Guide= (ImageView) inflater.findViewById(R.id.iv_guide);
            iv_Guide.setBackgroundResource(imgRes[i]);
            mviewList.add(inflater);
        }
    }
    /**引导界面的ViewPager适配器**/
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imgRes.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mviewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=mviewList.get(position);
            container.addView(view);
            return view;
        }
    }
    class MyListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        //ViewPager滚动到第几张
        @Override
        public void onPageSelected(int position) {
            //ViewPager到最后一张图片显示按钮
            if(position==imgRes.length-1){
                btnStart.setVisibility(View.VISIBLE);
                Animation animation= AnimationUtils.loadAnimation(GuideActivity.this,R.anim.anim_guide_btn_start);
                btnStart.startAnimation(animation);
            }else {
                btnStart.setVisibility(View.GONE);
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
