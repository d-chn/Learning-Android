package com.example.recyclerviewpractice_sob.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpractice_sob.R;
import com.example.recyclerviewpractice_sob.beans.ItemBean;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    public ListViewAdapter(List<ItemBean> mData) {
        this.mData = mData;
    }

    /*
     * 这个方法用于创建条目的View
     * 步骤：1.拿到view 2.创建InnerHolder
     * */
    @NonNull
    @Override
    public ListViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去的这个view其实就是条目的界面
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHolder(view);
    }

    /*
     * 这个方法用于绑定holder，一般用来设置数据
     * */
    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.InnerHolder holder, int position) {
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

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //找到条目的控件
            mIcon = itemView.findViewById(R.id.list_view_icon);
            mTitle = itemView.findViewById(R.id.list_view_title);
        }

        /*
         * 这个方法用于设置数据
         * */
        public void setData(ItemBean itemBean) {
            //开始设置数据
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }
}
