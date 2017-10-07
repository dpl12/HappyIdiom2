package cn.deu.bztc.happyidiom.activity;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.widget.TabHost;

import cn.deu.bztc.happyidiom.db.MyDatabaseHelper;


public class MainActivity extends TabActivity {
	private TabHost tabHost;// 导航栏控件

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消标题栏
		setContentView(R.layout.activity_main);

		createCollectDatabase();
		tabHost = getTabHost(); // 获取TabHost实例
		tabHost.addTab(tabHost.newTabSpec("study")
				.setIndicator("学习",getResources().getDrawable(R.drawable.study))
				.setContent(new Intent(this, StudyActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		tabHost.addTab(tabHost.newTabSpec("search")
				.setIndicator("搜索",getResources().getDrawable(R.drawable.search))
				.setContent(new Intent(this,SearchActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		tabHost.addTab(tabHost.newTabSpec("game")
				.setIndicator("游戏",getResources().getDrawable(R.drawable.game))
				.setContent(new Intent(this, GameActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		tabHost.addTab(tabHost.newTabSpec("save")
				.setIndicator("收藏",getResources().getDrawable(R.drawable.save))
				.setContent(new Intent(this, CollectActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		tabHost.addTab(tabHost.newTabSpec("music")
				.setIndicator("音乐",getResources().getDrawable(R.drawable.music))
				.setContent(new Intent(this, SetActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));

	}

	/* 创建收藏数据库 */
	private void createCollectDatabase() {
		MyDatabaseHelper mydatabaseHelper = new MyDatabaseHelper(
				MainActivity.this);
		mydatabaseHelper.getWritableDatabase();
	}

	/* 定义每个Tab的显示内容 */
	private void addTab(String tag, int title_introduction, int title_icon,
						Class ActivityClass) {
		tabHost.addTab(tabHost
				.newTabSpec(tag)
				.setIndicator(getString(title_introduction),
						getResources().getDrawable(title_icon))
				.setContent(new Intent(this, ActivityClass)));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
