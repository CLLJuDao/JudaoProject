package com.example.wenli.judaoproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.wakehao.bar.BottomNavigationBar;
import com.wakehao.bar.BottomNavigationItemWithDot;

import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SupportActivity {

    private static final String TAG = "MainActivity";
    private BottomNavigationBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (BottomNavigationBar) findViewById(R.id.bar);
        //可动态改变item的标题
//        bar.setTitle(0,"home(99)");
        bar.showNum(0,80);
        bar.showNum(1,100);
        bar.showNum(2,-2);
        bar.disMissNum(3);
        bar.setOnNavigationItemSelectedListener(new BottomNavigationBar.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull BottomNavigationItemWithDot item, int selectedPosition) {
                if(selectedPosition==2){
//                    startActivityForResult(new Intent(MainActivity.this,LoginActivity.class),1);
                    //用户切换item
//                   bar.setItemSelected(3,true);
//                    bar.disMissNum(2);
                    //返回false表示不响应点击事件
                    return true;
                }
                else return true;
            }
            @Override
            public void onNavigationItemSelectedAgain(@NonNull BottomNavigationItemWithDot item, int reSelectedPosition) {
                //连续点击了同一个reSelectedPosition位置的item
            }
        });
    }
}
