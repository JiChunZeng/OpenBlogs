package com.example.jiceng.openblog.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jiceng.modle.Trace;
import com.example.jiceng.openblog.R;
import com.example.jiceng.openblog.ui.adapter.TraceListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zengjichun on 2018/3/26.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rvTrace) RecyclerView rvTrace;

    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }


    private void initData() {
        // 模拟一些假的数据
        traceList.add(new Trace("11.16  晴", "活了这么多年了终于懂了，为什么别人不把你当一回事儿！因为你太真诚，太实在，说穿了，就是太傻。因为你太好说话，什么事情，一找你就答应，什么错误，你都会原谅，什么伤害，你都能接受。要知道，有的人习惯了得到，便忘记了感恩，习惯了你的坚强，却忘记了关心，习惯了你的大度，便忘记了收敛。致：所有善良，没心眼儿的傻瓜。善良总没错，但得分跟谁。总是替别人着想，谁替你想过你的感受！——致自己！"));
        traceList.add(new Trace("11.01  晴", "我喜欢她，我有勇气告诉她，她说要很久才会去爱，我说没关系我可以等，等到你想爱的时候我出现在你面前，可是结果……——至一厢情愿的自己。（陌生人愿意听我的唠叨么！）"));
        traceList.add(new Trace("09.30  雨", "在乎你的人， 你咳了一下他以为你感冒了；不在乎你的人，你死了他以为你睡着了！（这话说的绝对经典！） 鲁迅说：我若喜欢你，你脾气再大都叫个性。我若不喜欢你，就算你温顺的像只猫，我都嫌你掉毛！"));
        adapter = new TraceListAdapter(this, traceList);
        rvTrace.setLayoutManager(new LinearLayoutManager(this));
        rvTrace.setAdapter(adapter);
    }
}
