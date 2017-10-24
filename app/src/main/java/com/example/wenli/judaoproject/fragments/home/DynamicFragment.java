package com.example.wenli.judaoproject.fragments.home;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.wenli.judaoproject.R;
import com.example.wenli.judaoproject.Utils.ViewGroupAnimator;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by wenli on 2017/10/19.
 */

public class DynamicFragment extends SupportFragment {

    private LinearLayout most;
    private View gonelayout;
    private View visiblelayout;
    private AnimationSet animationSet;
    private ScaleAnimation scaleAnimation;
    private ObjectAnimator animator;
    private boolean reclick = false;
    Animation animation;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_dynamicfragment,container,false);
        most = view.findViewById(R.id.most);
        gonelayout = view.findViewById(R.id.gone_layout);
//        visiblelayout=view.findViewById(R.id.visiblelayout);


        animation = AnimationUtils.loadAnimation(getActivity(),R.anim.scale);
        most.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                float startHeight = visiblelayout.getHeight();
                if (reclick == false){

                    animator = ObjectAnimator.ofFloat(gonelayout, "alpha",0f, 1f);
                    animator.setDuration(5000);
                    animator.start();

                }else{
                    animator = ObjectAnimator.ofFloat(gonelayout, "alpha", 0, 1);
                    animator.setDuration(5000);
                    animator.start();
                    reclick = true;
                }

//                gonelayout.startAnimation(animation);
//                if (gonelayout.getVisibility()==View.GONE){
//
//                    gonelayout.setVisibility(View.VISIBLE);
//                }else {
//                    gonelayout.setVisibility(View.GONE);
//                }

            }

        });


        return view;
    }

}
