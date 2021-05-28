package com.example.smartcity.bean;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: ResultBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/31 9:16
 */
public class ResultBean {

    /**
     * total : 0
     * rows : []
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
