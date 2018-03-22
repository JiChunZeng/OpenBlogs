package com.example.jiceng.api;

/**
 * Created by jichunzeng on 2018/3/22.
 * 对接口返回的json数据结构进行封装
 */
public class ApiResponse<T> {

    private String event;    // 返回码，0为成功
    private String msg;      // 返回信息
    private T obj;           // 单个对象
    private T objList;       // 数组对象
    private int currentPage; // 当前页数
    private int pageSize;    // 每页显示数量
    private int maxCount;    // 总条数
    private int maxPage;     // 总页数

        // 构造函数，初始化code和msg
    public ApiResponse(String event, String msg) {
        this.event = event;
        this.msg = msg;
    }

        // 判断结果是否成功
    public boolean isSuccess() {
        return event.equals("0");
    }

    // TODO 所有属性的getter和setter

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObjList() {
        return objList;
    }

    public void setObjList(T objList) {
        this.objList = objList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
