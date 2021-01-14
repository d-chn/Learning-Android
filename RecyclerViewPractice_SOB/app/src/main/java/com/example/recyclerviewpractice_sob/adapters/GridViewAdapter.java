package com.example.recyclerviewpractice_sob.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpractice_sob.R;
import com.example.recyclerviewpractice_sob.beans.ItemBean;

import java.util.List;

/**
 * Created by Don on 2021/1/14
 * God bless my code!
 */
public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;
    private final boolean mOrientation;

    public GridViewAdapter(List<ItemBean> data, boolean orientation) {
        this.mData = data;
        this.mOrientation = orientation;
    }

    /**
     * 这个方法根据宽度设置高度
     *
     * @param view
     */
    public static void setViewHeightByWidth(View view, double proportion) {
        final View mv = view;
        final ViewTreeObserver vto = mv.getViewTreeObserver();
        final ViewTreeObserver.OnPreDrawListener preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                long width = mv.getMeasuredWidth();
                int height = mv.getMeasuredHeight();
                ViewGroup.LayoutParams lp = mv.getLayoutParams();
                lp.height = (int) (width * proportion);
                mv.setLayoutParams(lp);
                final ViewTreeObserver vto1 = mv.getViewTreeObserver();
                vto1.removeOnPreDrawListener(this);
                return true;
            }
        };
        vto.addOnPreDrawListener(preDrawListener);
    }

    /**
     * 这个方法根据高度设置宽度
     *
     * @param view
     */
    public static void setViewWidthByHeight(View view, double proportion) {
        final View mv = view;
        final ViewTreeObserver vto = mv.getViewTreeObserver();
        final ViewTreeObserver.OnPreDrawListener preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                long width = mv.getMeasuredWidth();
                int height = mv.getMeasuredHeight();
                ViewGroup.LayoutParams lp = mv.getLayoutParams();
                lp.width = (int) (height * proportion);
                mv.setLayoutParams(lp);
                final ViewTreeObserver vto1 = mv.getViewTreeObserver();
                vto1.removeOnPreDrawListener(this);
                return true;
            }
        };
        vto.addOnPreDrawListener(preDrawListener);
    }

    /*
     * 这个方法用于创建条目的View
     * */
    @NonNull
    @Override
    public GridViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //在这里创建条目
        //传进去的这个view就是条目的界面
        View view = View.inflate(parent.getContext(), R.layout.item_grid_view, null);
        if (mOrientation) {
            setViewHeightByWidth(view, 1.2);
        } else {
            setViewWidthByHeight(view, 0.8);
        }
        return new InnerHolder(view);
    }

    /*
     * 这个方法用于绑定holder，一般用来设置数据
     * */
    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.InnerHolder holder, int position) {
        //在这里设置数据
        holder.setData(mData.get(position));
    }

    /*
     * 返回条目个数
     * */
    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;
        private boolean orientation = mOrientation;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //找到条目的控件
            mTitle = (TextView) itemView.findViewById(R.id.grid_view_title);
            mIcon = (ImageView) itemView.findViewById(R.id.grid_view_icon);
            if (orientation) {
                setViewHeightByWidth(mIcon, 1);
            } else {
                setViewHeightByWidth(mIcon, 1);
            }
        }

        /*
         * 设置数据
         * */
        public void setData(ItemBean itemBean) {
            mTitle.setText(itemBean.title);
            mIcon.setImageResource(itemBean.icon);
        }
    }
}
