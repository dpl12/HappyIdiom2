package cn.deu.bztc.happyidiom.adapter;

import java.util.List;

import cn.deu.bztc.happyidiom.activity.R;
import cn.deu.bztc.happyidiom.entity.Category;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<Category> {
	private int resourceld;
	public CategoryAdapter(Context context, int resource,
			List<Category> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		resourceld=resource;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Category category=getItem(position);//获取当前项的Category实例
		View view;
		ViewHolder  viewHolder;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourceld, null);
			viewHolder=new ViewHolder();
			viewHolder.categoryImage=(ImageView) view.findViewById(R.id.category_image);
			viewHolder.categoryName=(TextView) view.findViewById(R.id.category_name);
			view.setTag(viewHolder);
		}else{
			view=convertView;
			viewHolder=(ViewHolder) view.getTag();//重新获取ViewHolder
		}
		viewHolder.categoryImage.setImageResource(category.getImageId());
		viewHolder.categoryName.setText(category.getName());
		return view;
	}
	class ViewHolder{
		ImageView  categoryImage;
		TextView categoryName;
	}
}
