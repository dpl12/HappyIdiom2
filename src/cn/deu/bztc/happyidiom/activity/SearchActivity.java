package cn.deu.bztc.happyidiom.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/6/6.
 */

public class SearchActivity  extends Activity {
    //查询按钮申明
    private Button myButton01;
    //清空按钮申明
    private Button myButton02;
    //输入框申明
    private EditText mEditText1;
    //加载数据的WebView申明
    private WebView mWebView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        myButton01 = (Button)findViewById(R.id.myButton01);
        myButton02 = (Button) findViewById(R.id.myButton02);
        mEditText1 = (EditText) findViewById(R.id.myEditText1);
        mWebView1 = (WebView) findViewById(R.id.myWebView1);
        //设置WebView背景图片
        mWebView1 .setBackgroundColor(0);
        mWebView1.setBackgroundResource(R.drawable.bg_animal);
        //设置浏览器权限
        mWebView1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
        //查询按钮添加事件
        myButton01.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View arg0)
            {
                String strURI = (mEditText1.getText().toString());
                strURI = strURI.trim();
                //如果查询内容为空提示
                if (strURI.length() == 0)
                {
                    Toast.makeText(SearchActivity.this, "查询内容不能为空!", Toast.LENGTH_LONG)
                            .show();
                }
                //否则则以参数的形式从http://dict.baidu.com/取得数据，加载到WebView里.
                else
                {
                    String strURL = "http://dict.baidu.com/s?wd="
                            + strURI+"&device=pc&from=home&q="+strURI;
                    mWebView1.loadUrl(strURL);
                }
            }
        });
        //http://dict.baidu.com/s?wd=()&device=pc&from=home&q=()
        //清空按钮添加事件，将EditText置空
        myButton02.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                mEditText1.setText("");
            }
        });
    }
}
