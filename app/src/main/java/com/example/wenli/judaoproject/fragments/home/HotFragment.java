package com.example.wenli.judaoproject.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wenli.judaoproject.R;
import com.example.wenli.judaoproject.fragments.base.BaseLazyFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 2017/10/19.
 */

public class HotFragment extends SupportFragment {
    private static final String TAG = "HotFragment";
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "22onCreateView: ");
        return inflater.inflate(R.layout.home_hotfragment,container,false);
    }

//    @Override
//    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
//        if (getUserVisibleHint()){
//            Toast.makeText(getContext(),"加载完毕",Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(getContext(),"正在加载",Toast.LENGTH_SHORT).show();
//
//        }
//        Log.d(TAG, "22onLazyInitView: ");
//
//    }
}
