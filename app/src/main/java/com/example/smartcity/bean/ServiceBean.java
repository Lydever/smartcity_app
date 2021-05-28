package com.example.smartcity.bean;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: ServiceBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/14 14:03
 */
public class ServiceBean {

    /**
     * total : 6
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:23","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":2,"serviceName":"城市地铁","serviceDesc":"城市地铁路线","serviceType":"1","imgUrl":"/profile/ditie.png","pid":1,"isRecommend":1,"link":"metro_query/index"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:33","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":3,"serviceName":"智慧巴士","serviceDesc":"智慧巴士站点","serviceType":"1","imgUrl":"/profile/bus.png","pid":1,"isRecommend":1,"link":"bus_query/custom_shuttle"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:58","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":5,"serviceName":"门诊预约","serviceDesc":"快捷方便不要出门也能门诊预约","serviceType":"1","imgUrl":"/profile/menzheng.png","pid":1,"isRecommend":1,"link":"outpatient/hospitalList"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:21","updateBy":null,"updateTime":"2020-10-19 16:56:47","remark":null,"params":{},"id":7,"serviceName":"生活缴费","serviceDesc":"不要出门也能缴费","serviceType":"2","imgUrl":"/profile/live.png","pid":1,"isRecommend":1,"link":"living_expenses/index"},{},{"searchValue":null,"createBy":null,"createTime":"2020-10-23 16:17:56","updateBy":null,"updateTime":"2020-10-23 16:17:58","remark":null,"params":{},"id":17,"serviceName":"停车场","serviceDesc":"查询停车场","serviceType":"3","imgUrl":"/profile/pack.png","pid":1,"isRecommend":1,"link":"park/index"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;

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

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2020-10-12 18:17:23
         * updateBy : null
         * updateTime : 2020-10-19 16:56:47
         * remark : null
         * params : {}
         * id : 2
         * serviceName : 城市地铁
         * serviceDesc : 城市地铁路线
         * serviceType : 1
         * imgUrl : /profile/ditie.png
         * pid : 1
         * isRecommend : 1
         * link : metro_query/index
         */

        private Object searchValue;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private String updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private String serviceName;
        private String serviceDesc;
        private String serviceType;
        private String imgUrl;
        private int pid;
        private int isRecommend;
        private String link;

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

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceDesc() {
            return serviceDesc;
        }

        public void setServiceDesc(String serviceDesc) {
            this.serviceDesc = serviceDesc;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(int isRecommend) {
            this.isRecommend = isRecommend;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public static class ParamsBean {
        }

        public RowsBean(String serviceName, String serviceDesc, String imgUrl, String link) {
            this.serviceName = serviceName;
            this.serviceDesc = serviceDesc;
            this.imgUrl = imgUrl;
            this.link = link;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "serviceName='" + serviceName + '\'' +
                    ", serviceDesc='" + serviceDesc + '\'' +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", link='" + link + '\'' +
                    '}';
        }
    }
}
