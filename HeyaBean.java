/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fudosanrepository;

/**
 *部屋情報インスタンス化
 * @author yb
 */
public class HeyaBean {
        //
    private String id;
    private String room_id;
    //ルーム番号
    private String room_num;
    private String room_money;
    //ルーム面積
    private String room_area;
    //ルームサービス
    private String room_service;
    private String create_date;
    private String modify_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_num() {
        return room_num;
    }

    public void setRoom_num(String room_num) {
        this.room_num = room_num;
    }

    public String getRoom_money() {
        return room_money;
    }

    public void setRoom_money(String rom_money) {
        this.room_money = rom_money;
    }

    public String getRoom_area() {
        return room_area;
    }

    public void setRoom_area(String room_area) {
        this.room_area = room_area;
    }

    public String getRoom_service() {
        return room_service;
    }

    public void setRoom_service(String room_service) {
        this.room_service = room_service;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }
    
    
}
