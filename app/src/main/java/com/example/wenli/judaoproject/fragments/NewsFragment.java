package com.example.wenli.judaoproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wenli.judaoproject.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 2017/10/18.
 */

public class NewsFragment extends SupportFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newsfragment,container,false);
    }
}
