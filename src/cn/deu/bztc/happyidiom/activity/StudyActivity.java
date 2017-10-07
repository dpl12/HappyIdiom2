package cn.deu.bztc.happyidiom.activity;

import java.util.ArrayList;
import java.util.List;

import cn.deu.bztc.happyidiom.adapter.CategoryAdapter;
import cn.deu.bztc.happyidiom.entity.Category;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class StudyActivity extends Activity{
	private List<Category>  categorList;
	private String [] category_name;
	private int[] category_images;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study);
		initeCategories();//初始化类别
		CategoryAdapter adapter=new CategoryAdapter(this, R.layout.category_item, categorList);
		ListView listView=(ListView) findViewById(R.id.lvCategories);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch ( position) {
				case 0:
					Intent intent=new Intent(StudyActivity.this, StudyAnimalActivity.class);
					startActivity(intent);
					break;

				default:
					break;
				}
				Category category=categorList.get(position);
				Toast.makeText(StudyActivity.this, category.getName(),
						Toast.LENGTH_LONG).show();
			}
		});
		
	}
	private void initeCategories(){
		categorList =new ArrayList<Category>();
		Resources resources=getResources();
		category_name=resources.getStringArray(R.array.category);
		category_images=new int[]{R.drawable.category_animal,
				R.drawable.category_nature,R.drawable.category_human,
				R.drawable.category_season,R.drawable.category_number,
				R.drawable.category_fable,R.drawable.category_other};
		for(int i=0;i<category_name.length;i++){
			categorList.
			add(new Category(category_name[i], category_images[i]));			
		
		}
	}
	
}
