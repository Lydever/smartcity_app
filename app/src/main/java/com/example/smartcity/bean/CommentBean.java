package com.example.smartcity.bean;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: CommentBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/3 23:57
 */
public class CommentBean  {

    /**
     * total : 29730
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-12 17:14:36","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":2,"pressId":1,"content":"台媒今日援引香港《南华早报》报道指出，解放军昨天(26日)上午朝南海发射两枚导弹，其中一枚是东风21D航母杀手反舰导弹，此举在于要对美国提出警告。","nickName":"???","userName":"zhangsan","avatar":"/profile/2021/04/03/8fb1c481-9fc5-4a85-a257-5ba3de3cce35.jpg"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 17:14:54","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":3,"pressId":1,"content":"国家主席习近平10月3日致电美国总统特朗普，就特朗普总统夫妇感染新冠病毒致以慰问。习近平在慰问电中表示，得知总统先生和梅拉尼娅女士感染新冠病毒，我和我夫人彭丽媛谨向你和你夫人表示慰问，祝你们早日康复。","nickName":null,"userName":null,"avatar":null},{"searchValue":null,"createBy":null,"createTime":"2020-10-17 12:02:41","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"pressId":1,"content":"中新网沈阳9月25日电(记者 刘欢)\u201c以前住在小区，从来不下楼，和邻居\u2018老死不相往来\u2019；现在的院里非常有生气，居民有活力，邻里之间和谐、融洽，见面都是眉开眼笑的。\u201d住在沈阳市和平新村社区的居民王永伟这样对记者说。","nickName":"宋哥","userName":"admin","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-c16a341558c7.png"},{"searchValue":null,"createBy":null,"createTime":"2020-10-27 14:54:50","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"pressId":1,"content":"\u201c国庆\u201d\u201c中秋\u201d双节将至，据首都机场预测，9月28日至10月11日，首都机场计划起降航班1.43万架次，日均1021架次;运送旅客218.9万人次，日均15.64万人次。首都机场提醒，携带月饼坐飞机，需确认月饼礼盒内是否配有刀叉(包括塑料刀叉)或者红酒，以提前办理托运手续。","nickName":"宋哥","userName":"admin","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-c16a341558c7.png"},{"searchValue":null,"createBy":null,"createTime":"2020-10-27 14:56:03","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"pressId":1,"content":"汪文斌：关于中国驻休斯敦总领馆馆员的有关情况，相信你已经从媒体上看到了。我这里要说的是，对于中国驻休斯敦总领馆的人员，中方将会作出妥善的安排。","nickName":"宋哥","userName":"admin","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-c16a341558c7.png"},{"searchValue":null,"createBy":null,"createTime":"2020-10-27 15:57:31","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":12,"pressId":1,"content":"台媒今日援引香港《南华早报》报道指出，解放军昨天(26日)上午朝南海发射两枚导弹，其中一枚是东风21D航母杀手反舰导弹，此举在于要对美国提出警告。","nickName":"hui","userName":"xiaozhang","avatar":"/profile/2020/10/27/b8c38d7b-34f3-4f9c-a0ce-55e07ca35821.jpg"},{"searchValue":null,"createBy":null,"createTime":"2021-03-04 15:15:55","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":1,"pressId":1,"content":"hhhh","nickName":"宋哥","userName":"admin","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-c16a341558c7.png"},{"searchValue":null,"createBy":null,"createTime":"2021-03-04 20:15:57","updateBy":null,"updateTime":null,"remark":null,"params":{},"userId":57,"pressId":1,"content":"这个新闻是我读过最好的新闻","nickName":"434","userName":"66","avatar":"/profile/2021/03/31/5428d88a-59d6-44a7-877d-c25b0a844185.jpg"}]
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
         * createTime : 2020-10-12 17:14:36
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * userId : 2
         * pressId : 1
         * content : 台媒今日援引香港《南华早报》报道指出，解放军昨天(26日)上午朝南海发射两枚导弹，其中一枚是东风21D航母杀手反舰导弹，此举在于要对美国提出警告。
         * nickName : ???
         * userName : zhangsan
         * avatar : /profile/2021/04/03/8fb1c481-9fc5-4a85-a257-5ba3de3cce35.jpg
         */

        private String createTime;
        private Object updateBy;
        private ParamsDTO params;
        private String content;
        private String nickName;
        private String userName;
        private String avatar;


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


        public ParamsDTO getParams() {
            return params;
        }

        public void setParams(ParamsDTO params) {
            this.params = params;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public static class ParamsDTO {
        }

        @Override
        public String toString() {
            return "RowsDTO{" +
                    "createTime='" + createTime + '\'' +
                    ", content='" + content + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", userName='" + userName + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }

        public RowsDTO(String createTime, String content, String nickName, String userName, String avatar) {
            this.createTime = createTime;
            this.content = content;
            this.nickName = nickName;
            this.userName = userName;
            this.avatar = avatar;
        }
    }
}
