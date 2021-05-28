package com.example.smartcity.bean;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: ResponseBean
 * @Description: 请求响应结果
 * @Author: liyingxia
 * @CreateDate: 2021/4/3 19:31
 */

public class ResponseBean {

    /**
     * msg : 操作成功
     * code : 200
     */

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
