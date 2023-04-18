/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fudosanrepository;

/**
 *入居者情報インスタンス化
 * @author yb
 */
public class NyuKyoSyaInfoBean {
        private String id ;
    private String user_name ;
    private String user_tel;
    private String user_buken;
    private String user_room;
    private String Usercheckdate ;

    public String getUserCheckdate() {
        return Usercheckdate;
    }

    public void setUserCheckdate(String checkdate) {
        this.Usercheckdate = checkdate;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_buken() {
        return user_buken;
    }

    public void setUser_buken(String user_buken) {
        this.user_buken = user_buken;
    }

    public String getUser_room() {
        return user_room;
    }

    public void setUser_room(String user_room) {
        this.user_room = user_room;
    }
}
