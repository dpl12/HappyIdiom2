package cn.deu.bztc.happyidiom.util;
import cn.deu.bztc.happyidiom.activity.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogUtil {
	private static ImageView    ivlaba;
	private static boolean f = true;
	public static  void showDialog( final String result,final Context context){
		AlertDialog.Builder  builder=new AlertDialog.Builder(context);
		LayoutInflater  layoytInflater=LayoutInflater.from(context);
		View view=layoytInflater.inflate(R.layout.dialog_info, null);
		//ivButton=(ImageButton) view.findViewById(R.id.btnSavae);
		ivlaba = (ImageView)view.findViewById(R.id.laba);
		builder.setView(view);
		TextView tvldiomInfo=(TextView)view.findViewById(R.id.tvldiomInfo);
		tvldiomInfo.setText(result);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();//取消对话框
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		builder.create().show();
	}
}
