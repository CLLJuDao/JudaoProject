package com.example.wenli.judaoproject.Utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;

/**
 * Created by wenli on 2017/10/27.
 */

public class DynamicRecyclerView  extends RecyclerView{
    //属性组件
    private SwipeRefreshLayout swipeRefresh;
    public DynamicRecyclerView(Context context) {
        super(context);
    }

    public DynamicRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(SwipeRefreshLayout s){
        swipeRefresh = s;

        addOnScrollListener(new ImageAutoLoadScrollListen());
    }
    public class ImageAutoLoadScrollListen extends OnScrollListener{
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int topRowVerticalPosition =
                    (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
            swipeRefresh.setEnabled(topRowVerticalPosition >= 0);

        }
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            switch (newState){
                case SCROLL_STATE_IDLE:
                    try {
                        if (getContext()!=null){
                            Glide.with(getContext()).resumeRequests();
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case SCROLL_STATE_DRAGGING:
                    try {
                        if (getContext()!=null){
                            Glide.with(getContext()).pauseRequests();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case SCROLL_STATE_SETTLING:
                    try {
                        if (getContext()!=null){
                            Glide.with(getContext()).pauseRequests();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

            }
        }
    }
}
