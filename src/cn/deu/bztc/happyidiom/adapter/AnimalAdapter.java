package cn.deu.bztc.happyidiom.adapter;

import java.util.List;


import cn.deu.bztc.happyidiom.activity.R;
import cn.deu.bztc.happyidiom.dao.CollectDao;
import cn.deu.bztc.happyidiom.entity.Animal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AnimalAdapter extends ArrayAdapter<Animal> {
	private int resourced;
	private Context context;
	public AnimalAdapter(Context context, int resource, List<Animal> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.context=context;
		resourced=resource;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final	Animal animal=getItem(position);//获取当前的Animal实例
		View view;
		ViewHolder  viewHolder;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourced, null);
			viewHolder=new ViewHolder();
			viewHolder.tvName=(TextView) view.findViewById(R.id.tvName);
			viewHolder.btnSave=(ImageButton) view.findViewById(R.id.btnSavae);
			viewHolder.btnSave.setFocusable(false);
			viewHolder.btnSave.setFocusableInTouchMode(false);
			//解释什么意思
			viewHolder.btnSave.setOnClickListener(new OnClickListener() {
		
				public void onClick(View v) {
					// TODO Auto-generated method stub
					CollectDao collectDao=new CollectDao(context);
					collectDao.add(animal);
					Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
				}
			});

			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder) view.getTag();//重新获取ViewHolder
		}
		viewHolder.tvName.setText(animal.getName());
		return view;
	}
	class ViewHolder{
		TextView  tvName;
		ImageButton btnSave;
	}

}
