package cn.deu.bztc.happyidiom.test;

import java.util.List;

import cn.deu.bztc.happyidiom.dao.AnimalDao;
import cn.deu.bztc.happyidiom.db.DBOpenHelper;
import cn.deu.bztc.happyidiom.entity.Animal;
import android.test.AndroidTestCase;

public class DBOpenHelpTest extends AndroidTestCase {
	public void testDBCOpy(){
		DBOpenHelper  dbopenHelper=new DBOpenHelper(getContext());
		dbopenHelper.openDatabase();
	}
	public void testGetAllAnimals(){
		AnimalDao animalDao=AnimalDao.getInstance(getContext());
		List<Animal> animals=animalDao.getAllAnimals();
		System.out.println(animals.size());
		for(Animal animal:animals){
			System.out.println(animal.getName());
		}
	}
}
