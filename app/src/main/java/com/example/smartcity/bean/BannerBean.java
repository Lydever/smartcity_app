package com.example.smartcity.bean;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: BannerBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/24 12:41
 */
public class BannerBean {

    /**
     * total : 4
     * rows : [{"id":10,"imgUrl":"/profile/home2.png","type":"45","createTime":"2020-10-12T22:55:17.000+0800","sort":"2","display":"N"},{"id":11,"imgUrl":"/profile/home3.png","type":"45","createTime":"2020-10-12T22:55:17.000+0800","sort":"3","display":"N"},{"id":12,"imgUrl":"/profile/home4.png","type":"45","createTime":"2020-10-12T22:55:17.000+0800","sort":"4","display":"N"},{"id":13,"imgUrl":"/profile/home1.png","type":"45","createTime":"2020-10-12T22:55:17.000+0800","sort":"1","display":"N"}]
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
         * id : 10
         * imgUrl : /profile/home2.png
         * type : 45
         * createTime : 2020-10-12T22:55:17.000+0800
         * sort : 2
         * display : N
         */


        private int id;

        private String imgUrl;

        private String type;

        private String createTime;

        private String sort;

        private String display;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public RowsDTO(String imgUrl, String type) {
            this.imgUrl = imgUrl;
            this.type = type;
        }

        @Override
        public String toString() {
            return "RowsDTO{" +
                    "id=" + id +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", type='" + type + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", sort='" + sort + '\'' +
                    ", display='" + display + '\'' +
                    '}';
        }
    }
}
