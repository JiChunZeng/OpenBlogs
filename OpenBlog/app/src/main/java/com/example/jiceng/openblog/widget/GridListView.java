package com.example.jiceng.openblog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jiceng.openblog.R;

import java.util.List;

/**
 * Created by zengjichun on 2018/3/28.
 * 日记列表图片排列
 */

public class GridListView extends ViewGroup {

    /**
     * 子项大小
     */
    private int mItemWidth;
    /**
     * 间隙大小
     */
    private int mPadding = 0;
    /**
     * 列数
     */
    private int mClunNum = 0;
    /**
     * 数据源
     */
    private List<Integer> mData;

    public GridListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPadding = (int) (4*getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 宽度获取
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        mItemWidth = (widthSize - 2*mPadding)/3;

        // 测量子View
        int childCount = getChildCount();
        if(1 == childCount) {
            View child = getChildAt(0);
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            int height = child.getMeasuredHeight();
            setMeasuredDimension(widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST));
        }else {
            for(int i=0; i<childCount; i++) {
                View child = getChildAt(i);

                child.measure(MeasureSpec.makeMeasureSpec(mItemWidth, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(mItemWidth, MeasureSpec.EXACTLY));
            }
            // 测量当前View
            int rowNum = childCount/mClunNum;
            rowNum = childCount%mClunNum == 0 ? rowNum : rowNum + 1;
            int heightSize = (rowNum - 1) * mPadding + rowNum*mItemWidth;
            setMeasuredDimension(widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY));
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        if(count == 1) {
            View view = getChildAt(0);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }else {
            layoutChild(count, mClunNum);
        }
    }

    private void layoutChild(int childCount, int clunNum) {
        if(clunNum == 0) {
            return;
        }
        for(int i=0; i<childCount; i++) {
            View childView = getChildAt(i);
            int xPosition = i%clunNum;
            int yPosition = i/clunNum;
            int l = mPadding*xPosition + mItemWidth*xPosition;
            int t = mPadding*yPosition + mItemWidth*yPosition;
            childView.layout(l, t, l+mItemWidth, t+mItemWidth);
        }
    }

    /**
     * 设置数据源
     * @param data
     */
    public void setData(List<Integer> data) {
        this.mData = data;
        if(null == data) {
            return;
        }
        int size = data.size();
        if(size == 0) {
            return;
        }

        if(size == 1) {
            mClunNum = 1;
        }else {
            mClunNum = 3;
        }

        removeAllViews();
        // 添加子View
        for(int i=0; i<mData.size(); i++) {
            ImageView imvItem = new ImageView(getContext());
            imvItem.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            imvItem.setImageResource(mData.get(i));
            imvItem.setBackgroundResource(R.drawable.i1);
            imvItem.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imvItem);
        }
    }
}
