package com.example.wenli.judaoproject.fragments.home;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wenli.judaoproject.R;
import com.example.wenli.judaoproject.Utils.DrawableTintUtil;
import com.example.wenli.judaoproject.Utils.DynamicRecyclerView;
import com.example.wenli.judaoproject.adapter.DynamicAdapter;
import com.example.wenli.judaoproject.bean.DynamicItem;
import com.example.wenli.judaoproject.fragments.base.BaseLazyFragment;
import com.example.wenli.judaoproject.urls.ImageUrl;

import java.util.ArrayList;
import java.util.List;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by wenli on 2017/10/19.
 */

public class DynamicFragment extends SupportFragment {
    private static final String TAG = "DynamicFragment";
    //属性组件
    private SwipeRefreshLayout swipeRefresh;
    //更多按钮
    private LinearLayout most;
    //隐藏的view
    private View gonelayout;
    //显示的view
    private View visiblelayout;
    //基础动画，已抛弃不用
    //private AnimationSet animationSet;
    //private ScaleAnimation scaleAnimation;

    //使用属性动画
    private ObjectAnimator animator;
    private ValueAnimator va ;

    //重复点击判定
    private boolean reclick = false;
    //列表
    private DynamicRecyclerView dynamicRecyclerView;
    //模拟数据，可替换
    private List<DynamicItem> data;
    private ImageView jiuji;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    //初始化布局V
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "11onCreateView: ");

        data = new ArrayList<>();
        //导入布局文件
        View view = inflater.inflate(R.layout.home_dynamicfragment,container,false);
        //下啊刷新
        swipeRefresh = view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDynamic();
            }
        });
        //初始化刷新组件
        swipeRefresh=view.findViewById(R.id.swipe_refresh);
        //改变图片颜色
        jiuji = view.findViewById(R.id.jiuji);
        Drawable src = jiuji.getDrawable();
        jiuji.setImageDrawable(DrawableTintUtil.tintDrawable(src, ColorStateList.valueOf(Color.BLUE)));
        //初始化样式
        initFragment(view);
        initImageUrls();
        //初始化recyclerview
        dynamicRecyclerView = view.findViewById(R.id.dynamic_content);
        dynamicRecyclerView.init(swipeRefresh);
        //定义recyclerview布局格式
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置布局
        dynamicRecyclerView.setLayoutManager(layoutManager);
        //定义适配器
        DynamicAdapter adapter = new DynamicAdapter(data);
        //设置适配器
        dynamicRecyclerView.setAdapter(adapter);


        return view;
    }
    private void refreshDynamic(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                    }
                });

            }
        });
    }
    private void initImageUrls() {
        int i = ImageUrl.imageList().size();
        for (int j=0;j<i;j++){
            DynamicItem dynamicItem = new DynamicItem(ImageUrl.imageList().get(j));
            data.add(dynamicItem);
        }

    }

    //初始化组件
    public  void initFragment(View view){
        most = view.findViewById(R.id.most);
        //初始化隐藏功能
        gonelayout = view.findViewById(R.id.gone_layout);
        most.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                float startHeight = visiblelayout.getHeight();
                reclick = !reclick;
                if(reclick){
                    //显示view，高度从0变到height值
                    va = ValueAnimator.ofInt(0,210);
                }else{
                    //隐藏view，高度从height变为0
                    va = ValueAnimator.ofInt(210,0);
                }
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //获取当前的height值
                        int h =(Integer)valueAnimator.getAnimatedValue();
                        //动态更新view的高度
                        gonelayout.getLayoutParams().height = h;
                        gonelayout.requestLayout();
                    }
                });
                va.setDuration(300);
                //开始动画
                va.start();
            }

        });
    }



}
