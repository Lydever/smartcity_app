package com.example.smartcity.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: OrderBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/31 9:15
 */
public class OrderBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":"2020-10-24 19:23:31","updateBy":null,"updateTime":null,"remark":null,"params":{},"orderNum":"60353861","id":1,"path":"一号线","start":"泰德大厦","end":"大连北站","price":8,"userName":"张三","userTel":"12345611","userId":1,"status":0},{"searchValue":null,"createBy":null,"createTime":"2020-10-24 19:25:36","updateBy":null,"updateTime":null,"remark":null,"params":{},"orderNum":"60353873","id":2,"path":"一号线","start":"泰德大厦","end":"大连北站","price":8,"userName":"张三","userTel":"12345611","userId":1,"status":0}]
     */

    private String msg;
    private int code;
    private List<OrderData> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OrderData> getData() {
        return data;
    }

    public void setData(List<OrderData> data) {
        this.data = data;
    }

    public static class OrderData {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2020-10-24 19:23:31
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * orderNum : 60353861
         * id : 1
         * path : 一号线
         * start : 泰德大厦
         * end : 大连北站
         * price : 8
         * userName : 张三
         * userTel : 12345611
         * userId : 1
         * status : 0
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;

        private String orderNum;
        private int id;
        private String path;
        private String start;
        private String end;
        private int price;
        private String userName;
        private String userTel;
        private int userId;
        private int status;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public OrderData(String createTime, String orderNum) {
            this.createTime = createTime;
            this.orderNum = orderNum;
        }
    }
}
