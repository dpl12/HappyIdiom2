package cn.deu.bztc.happyidiom.activity;

import java.util.List;

import cn.deu.bztc.happyidiom.adapter.AnimalAdapter;
import cn.deu.bztc.happyidiom.dao.AnimalDao;
import cn.deu.bztc.happyidiom.entity.Animal;
import cn.deu.bztc.happyidiom.util.DialogUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StudyAnimalActivity  extends Activity{
	private List<Animal> animalList;
	private AnimalDao animalDao;
	private ListView lvAnimalList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animal);
		initAnimals();
		lvAnimalList=(ListView) findViewById(R.id.lvAnimalList);
		AnimalAdapter animalAdapter=new AnimalAdapter(this, R.layout.animal_item, animalList);
		lvAnimalList.setAdapter(animalAdapter);
		lvAnimalList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Animal animal=animalList.get(position);
				final String result=animal.getName	()+"\n"+animal.getPronounce()+
						"\n【解释】:"+animal.getExplain()+"\n【近义词】:"+
						animal.getHomoionym()+"\n【反义词】"+animal.getAntonym()+
						"\n【来源】"+animal.getDerivation()+"\n【示例】"+animal.getExamples();
				DialogUtil.showDialog(result, StudyAnimalActivity.this);
			}
		});
	}
	private void initAnimals(){
		animalDao=AnimalDao.getInstance(this);
		animalList=AnimalDao.getAllAnimals();
	}
}
