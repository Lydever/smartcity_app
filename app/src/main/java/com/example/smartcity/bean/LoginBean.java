package com.example.smartcity.bean;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: LoginBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/31 9:17
 */
public class LoginBean {

    /**
     * msg : 操作成功
     * code : 200
     * token : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImMyYjE1YTNkLTlkNWQtNGFmZi04MGU3LTNlNWMxYTdkYzcyNSJ9.sZxcMsSvH7F50jCpTdtrv296mgq5IOI8OAo8rAXDQ4mw7KssvPsdwFcFdxHyGodfYmrsDxv0wyyEgDdl7JDxoQ
     */

    private String msg;
    private String code;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginBean(String msg, String code, String token) {
        this.msg = msg;
        this.code = code;
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", token='" + token + '\'' +
                '}';
    }
}
