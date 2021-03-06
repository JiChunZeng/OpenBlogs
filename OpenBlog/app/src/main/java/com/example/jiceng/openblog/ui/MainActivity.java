package com.example.jiceng.openblog.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiceng.modle.Trace;
import com.example.jiceng.openblog.R;
import com.example.jiceng.openblog.ui.adapter.TraceListAdapter;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zengjichun on 2018/3/26.
 */
public class MainActivity extends BaseActivity implements CalendarView.OnDateSelectedListener, CalendarView.OnYearChangeListener, View.OnClickListener  {
    TextView mTextMonthDay;

    TextView mTextYear;

    TextView mTextLunar;

    TextView mTextCurrentDay;

    CalendarView mCalendarView;

    RelativeLayout mRelativeTool;
    private int mYear;
    CalendarLayout mCalendarLayout;

    RecyclerView rvTrace;

    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    protected void initWindow() {
        //隐藏状态栏和导航栏，但是一点击就显示出来了
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.initWindow();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        mTextMonthDay = (TextView) findViewById(R.id.tv_month_day);
        mTextYear = (TextView) findViewById(R.id.tv_year);
        mTextLunar = (TextView) findViewById(R.id.tv_lunar);
        mRelativeTool = (RelativeLayout) findViewById(R.id.rl_tool);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mTextCurrentDay = (TextView) findViewById(R.id.tv_current_day);
        rvTrace = (RecyclerView) findViewById(R.id.rvTrace);
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarView.showYearSelectLayout(mYear);
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
        });
        mCalendarLayout = (CalendarLayout) findViewById(R.id.calendarLayout);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    @Override
    protected void initData() {
        List<Calendar> schemes = new ArrayList<>();
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();


        schemes.add(getSchemeCalendar(year, month, 3, "假"));
        schemes.add(getSchemeCalendar(year, month, 6, "事"));
        schemes.add(getSchemeCalendar(year, month, 9, "议"));
        schemes.add(getSchemeCalendar(year, month, 13, "记"));
        schemes.add(getSchemeCalendar(year, month, 14, "记"));
        schemes.add(getSchemeCalendar(year, month, 15, "假"));
        schemes.add(getSchemeCalendar(year, month, 18, "记"));
        schemes.add(getSchemeCalendar(year, month, 25, "假"));
        schemes.add(getSchemeCalendar(year, month, 27, "多"));
        mCalendarView.setSchemeDate(schemes);
        // 模拟一些假的数据
        traceList.add(new Trace("11.16  晴", "活了这么多年了终于懂了，为什么别人不把你当一回事儿！因为你太真诚，太实在，说穿了，就是太傻。因为你太好说话，什么事情，一找你就答应，什么错误，你都会原谅，什么伤害，你都能接受。要知道，有的人习惯了得到，便忘记了感恩，习惯了你的坚强，却忘记了关心，习惯了你的大度，便忘记了收敛。致：所有善良，没心眼儿的傻瓜。善良总没错，但得分跟谁。总是替别人着想，谁替你想过你的感受！——致自己！"));
        traceList.add(new Trace("11.01  晴", "我喜欢她，我有勇气告诉她，她说要很久才会去爱，我说没关系我可以等，等到你想爱的时候我出现在你面前，可是结果……——至一厢情愿的自己。（陌生人愿意听我的唠叨么！）"));
        traceList.add(new Trace("09.30  雨", "在乎你的人， 你咳了一下他以为你感冒了；不在乎你的人，你死了他以为你睡着了！（这话说的绝对经典！） 鲁迅说：我若喜欢你，你脾气再大都叫个性。我若不喜欢你，就算你温顺的像只猫，我都嫌你掉毛！"));
        adapter = new TraceListAdapter(this, traceList);
        rvTrace.setLayoutManager(new LinearLayoutManager(this));
        rvTrace.setAdapter(adapter);
    }

    private Calendar getSchemeCalendar(int year, int month, int day, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(Color.WHITE);
        calendar.setScheme(text);
        calendar.addScheme(0xFFa8b015, "rightTop");
        calendar.addScheme(0xFF423cb0, "leftTop");
        calendar.addScheme(0xFF643c8c, "bottom");

        return calendar;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
    }


    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        initData();
//    }
//
//


    @Override
    public void onClick(View view) {

    }

}