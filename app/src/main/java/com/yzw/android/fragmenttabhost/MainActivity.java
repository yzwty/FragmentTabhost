package com.yzw.android.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

/*
自定义TabHost
 */
public class MainActivity extends FragmentActivity {
     //  定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    //定义一个布局
    private LayoutInflater layoutInflater;
    //定义数组用来存放Fragment的界面
    private Class fragmentArray[]={Activity1.class,Activity2.class,Activity3.class,Activity4.class};
    //定义数组用来存放image按钮
    private int imageArray[]={R.drawable.tab_home_btn,R.drawable.tab_message_btn,R.drawable.tab_square_btn,
            R.drawable.tab_more_btn};
    //Tab选项卡的文字
    private String mTextviewArray[] = {"快递", "收藏", "网点", "更多"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView(){
        //实例化布局对象
       layoutInflater=LayoutInflater.from(this);
        //实例化TabHost对象，得到TabHost
        mTabHost=(FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realcontent) ;
        //得到fragment的个数
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }

    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(imageArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }
}
