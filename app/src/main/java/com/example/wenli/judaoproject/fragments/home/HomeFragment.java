package com.example.wenli.judaoproject.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.wenli.judaoproject.R;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 2017/10/18.
 */

public class HomeFragment extends SupportFragment {
    private static final String TAG = "HomeFragment";
    private List<Fragment> list;
    private String[] titles = {"动态", "热门"};
    private TabLayout tabLayout;
    private MyAdapter adapter;
    private FragmentManager fragmentManager;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.homefragment,container,false);
        fragmentManager = getFragmentManager();
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tabLayout);
        list = new ArrayList<>();
        list.add(new DynamicFragment());
        list.add(new HotFragment());
        adapter = new MyAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    class MyAdapter extends FragmentPagerAdapter {

        @Override
        public void startUpdate(ViewGroup container) {
            super.startUpdate(container);
        }

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }


        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
