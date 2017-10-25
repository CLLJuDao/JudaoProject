package com.example.wenli.judaoproject.fragments.home;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.wenli.judaoproject.R;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 2017/10/19.
 */

public class DynamicFragment extends SupportFragment {

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
    private RecyclerView recyclerView;
    //模拟数据，可替换
    private List<String> data;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //导入布局文件
        View view = inflater.inflate(R.layout.home_dynamicfragment,container,false);
        //初始化更多按钮
        most = view.findViewById(R.id.most);
        //初始化数据
        data = new ArrayList<String>();
        //初始化隐藏功能
        gonelayout = view.findViewById(R.id.gone_layout);
        //初始化recyclerview
        recyclerView = view.findViewById(R.id.dynamic_content);
        //定义recyclerview布局格式
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置布局
        recyclerView.setLayoutManager(layoutManager);
        //添加数据
        for (int i=0;i<50;i++){
            data.add("test"+i);
        }
        //定义适配器
        DynamicAdapter adapter = new DynamicAdapter(data);
        //设置适配器
        recyclerView.setAdapter(adapter);
        most.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                float startHeight = visiblelayout.getHeight();
                reclick = !reclick;
                if(reclick){
                    //显示view，高度从0变到height值
                    va = ValueAnimator.ofInt(0,200);
                }else{
                    //隐藏view，高度从height变为0
                    va = ValueAnimator.ofInt(200,0);
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
        return view;
    }
    class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder>{


         class ViewHolder extends RecyclerView.ViewHolder{
            TextView test;

            public ViewHolder(View itemView) {
                super(itemView);
                test = itemView.findViewById(R.id.test_text);
            }
        }

        public DynamicAdapter(List<String> list) {

            data = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.test.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }


    }

}
