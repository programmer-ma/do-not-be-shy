package com.mogo.main.model;

public class Personal {

    String id;//识别码
    String choice;//选择
    String nickName;//昵称
    String favId;//最优匹配

    public Personal(String id, String choice, String nickName) {
        this.id = id;
        this.choice = choice;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
