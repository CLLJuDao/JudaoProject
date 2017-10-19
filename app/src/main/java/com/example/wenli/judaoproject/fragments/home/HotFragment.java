package com.example.wenli.judaoproject.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wenli.judaoproject.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 2017/10/19.
 */

public class HotFragment extends SupportFragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_hotfragment,container,false);
    }
}
