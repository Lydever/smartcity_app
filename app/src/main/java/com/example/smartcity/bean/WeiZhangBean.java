package com.example.smartcity.bean;

import java.util.List;

/**
 * @ProjectName: smartcity4
 * @Package: com.example.smartcity4.bean
 * @ClassName: WeiZhangBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/6 15:57
 */
public class WeiZhangBean  {

    /**
     * total : 1
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"licencePlate":"京123","disposeState":"1","badTime":"2020-11-09 10:52","money":"200","deductMarks":"6","illegalSites":"大连","noticeNo":"1234","engineNumber":"1234","catType":"小型汽车","trafficOffence":"闯红灯"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsDTO> rows;

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

    public List<RowsDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowsDTO> rows) {
        this.rows = rows;
    }

    public static class RowsDTO {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 21
         * licencePlate : 京123
         * disposeState : 1
         * badTime : 2020-11-09 10:52
         * money : 200
         * deductMarks : 6
         * illegalSites : 大连
         * noticeNo : 1234
         * engineNumber : 1234
         * catType : 小型汽车
         * trafficOffence : 闯红灯
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsDTO params;
        private int id;
        private String licencePlate;
        private String disposeState;
        private String badTime;
        private String money;
        private String deductMarks;
        private String illegalSites;
        private String noticeNo;
        private String engineNumber;
        private String catType;
        private String trafficOffence;

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

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
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

        public ParamsDTO getParams() {
            return params;
        }

        public void setParams(ParamsDTO params) {
            this.params = params;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLicencePlate() {
            return licencePlate;
        }

        public void setLicencePlate(String licencePlate) {
            this.licencePlate = licencePlate;
        }

        public String getDisposeState() {
            return disposeState;
        }

        public void setDisposeState(String disposeState) {
            this.disposeState = disposeState;
        }

        public String getBadTime() {
            return badTime;
        }

        public void setBadTime(String badTime) {
            this.badTime = badTime;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getDeductMarks() {
            return deductMarks;
        }

        public void setDeductMarks(String deductMarks) {
            this.deductMarks = deductMarks;
        }

        public String getIllegalSites() {
            return illegalSites;
        }

        public void setIllegalSites(String illegalSites) {
            this.illegalSites = illegalSites;
        }

        public String getNoticeNo() {
            return noticeNo;
        }

        public void setNoticeNo(String noticeNo) {
            this.noticeNo = noticeNo;
        }

        public String getEngineNumber() {
            return engineNumber;
        }

        public void setEngineNumber(String engineNumber) {
            this.engineNumber = engineNumber;
        }

        public String getCatType() {
            return catType;
        }

        public void setCatType(String catType) {
            this.catType = catType;
        }

        public String getTrafficOffence() {
            return trafficOffence;
        }

        public void setTrafficOffence(String trafficOffence) {
            this.trafficOffence = trafficOffence;
        }

        public static class ParamsDTO {
        }
    }
}
