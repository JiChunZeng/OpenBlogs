package com.example.jiceng.openblog.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.jiceng.modle.Trace;
import com.example.jiceng.openblog.R;
import com.example.jiceng.openblog.widget.GridListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zengjichun on 2018/3/26.
 */

public class TraceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Trace> traceList = new ArrayList<>(1);
    private static final int TYPE_TOP = 0x0000;
    private static final int TYPE_NORMAL= 0x0001;
    private Context context;


    public TraceListAdapter(Context context, List<Trace> traceList) {
        inflater = LayoutInflater.from(context);
        this.traceList = traceList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_trace, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        if (getItemViewType(position) == TYPE_TOP) {
            // 第一行头的竖线不显示
            itemHolder.tvTopLine.setVisibility(View.INVISIBLE);

        } else if (getItemViewType(position) == TYPE_NORMAL) {
            itemHolder.tvTopLine.setVisibility(View.VISIBLE);
        }
        // 字体颜色加深
        itemHolder.tvAcceptTime.setTextColor(0xff555555);
        itemHolder.tvAcceptStation.setTextColor(0xff555555);
        itemHolder.bindHolder(traceList.get(position));
    }

    @Override
    public int getItemCount() {
        return traceList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP;
        }
        return TYPE_NORMAL;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAcceptTime, tvAcceptStation;
        private TextView tvTopLine, tvDot,trace_packup;
        private GridListView gridView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvAcceptTime = (TextView) itemView.findViewById(R.id.tvAcceptTime);
            tvAcceptStation = (TextView) itemView.findViewById(R.id.tvAcceptStation);
            tvTopLine = (TextView) itemView.findViewById(R.id.tvTopLine);
            tvDot = (TextView) itemView.findViewById(R.id.tvDot);
            trace_packup = itemView.findViewById(R.id.trace_packup);
            gridView = itemView.findViewById(R.id.trace_gv);
            trace_packup.setOnClickListener(new View.OnClickListener() {
                Boolean flag = true;
                @Override
                public void onClick(View view) {
                    Log.i("trace_packup",trace_packup.getHeight()+"");
                    if(flag){
                        flag = false;
                        trace_packup.setEllipsize(null); // 展开
                        trace_packup.setText("收起");
//                        trace_packup.setSingleLine(flag);
                    }else{
                        flag = true;
                        trace_packup.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                        trace_packup.setText("展开");
//                        trace_packup.setSingleLine(flag);
                    }
                }
            });
        }

        public void bindHolder( Trace trace) {
            List<Integer> date = new ArrayList<Integer>();
            date.add(R.drawable.i1);
            date.add(R.drawable.i1);
            date.add(R.drawable.i1);
            date.add(R.drawable.i1);
            date.add(R.drawable.i1);
            date.add(R.drawable.i1);
            gridView.setData(date);
            tvAcceptTime.setText(trace.getAcceptTime());
            tvAcceptStation.setText(trace.getAcceptStation());
        }
    }
}
