package cn.deu.bztc.happyidiom.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cn.deu.bztc.happyidiom.db.DBOpenHelper;
import cn.deu.bztc.happyidiom.entity.Animal;

/**
 * Created by Administrator on 2017/6/5.
 */

public class GameDao {
    private static GameDao gameDao;
    private SQLiteDatabase db;
    public GameDao(Context context){
        DBOpenHelper dbHelper=new DBOpenHelper(context);
        db=dbHelper.openDatabase();
    }

    public synchronized static GameDao getInstance(Context context){
        if(gameDao==null){
            gameDao=new GameDao(context);
        }
        return gameDao;
    }

    /*根据id获取成语信息*/
    public Animal getPhrase(String id){
        Animal animal = null;
        Cursor cursor=db.query("animal",null,"_id=?",new String[]{id},null,null,null);
        if(cursor.moveToFirst()){
            animal=new Animal();
            animal.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            animal.setName(cursor.getString(cursor.getColumnIndex("name")));
            animal.setPronounce(cursor.getString(cursor.getColumnIndex("pronounce")));
            animal.setAntonym(cursor.getString(cursor.getColumnIndex("antonym")));
            animal.setHomoionym(cursor.getString(cursor.getColumnIndex("homoionym")));
            animal.setDerivation(cursor.getString(cursor.getColumnIndex("derivation")));
            animal.setExamples(cursor.getString(cursor.getColumnIndex("examples")));
            animal.setExplain(cursor.getString(cursor.getColumnIndex("explain")));
        }
        cursor.close();
        return animal;
    }
}
