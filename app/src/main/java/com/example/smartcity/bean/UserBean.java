package com.example.smartcity.bean;


/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: UserInfo
 * @Description: 用户注册信息
 * @Author: liyingxia
 * @CreateDate: 2021/3/16 18:01
 */
public class UserBean{

    /**
     * userName : liyingxia2
     * nickName : 李四2
     * phonenumber : 1234567898
     * sex : 0
     * password : 123456
     */

    private String userName;
    private String nickName;
    private String phonenumber;
    private String sex;
    private String password;

    public UserBean(String nickName) {
        this.nickName = nickName;
    }

    public UserBean() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean(String userName, String nickName, String phonenumber, String sex, String password) {
        this.userName = userName;
        this.nickName = nickName;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
