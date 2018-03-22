package com.example.jiceng.api;

/**
 * Created by jichunzeng on 2018/3/22.
 *
 */

public interface Api {
    // 请求名示例
    public final static String SEND_SAAMPLE_CODE = "service.sendSampleCode";


    /**
     * 示例请求
     *
     * @param parameter 示例参数
     * @return 成功时返回：{ "event": "0", "msg":"success" }
     */
    public ApiResponse<Void> sendSampleCode(String parameter);

}
