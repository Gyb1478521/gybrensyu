/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fudosanrepository;

/**
 *物件情報をインスタンス化
 * @author yb
 */
public class BukenBean {
       private String id;
    private String buken_name;
    private String address;
    private String eki;
    private String grade;
    private String create_date;
    private String modify_date;

    public String getid() {
        return id;
    }

    public void setid(String homeid) {
        this.id = homeid;
    }


    public BukenBean() {

    }


    public String getBuken_name() {
        return buken_name;
    }

    public String getAddress() {
        return address;
    }

    public String getEki() {
        return eki;
    }

    public String getGrade() {
        return grade;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setBuken_name(String buken_name) {
        this.buken_name = buken_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEki(String eki) {
        this.eki = eki;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }
    
}
