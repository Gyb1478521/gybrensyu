/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fudosanservice;

import daojdbcconn.JdbcConn;
import fudosanrepository.BukenBean;
import fudosanrepository.HeyaBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *部屋一覧
 * @author yb
 */
public class HeyaService {

    public List<HeyaBean> heyalistInfo() {
        JdbcConn jc = new JdbcConn();
        List<HeyaBean> list = new ArrayList<HeyaBean>();

        try {
            try {
                jc.getDbcom();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "select * from room_info ";

            ResultSet resultSet = jc.tt(sql);

            while (resultSet.next()) {
                HeyaBean HeyaBeanlist = new HeyaBean();
                HeyaBeanlist.setId(String.valueOf(resultSet.getInt("id")));
                HeyaBeanlist.setRoom_id(String.valueOf(resultSet.getInt("room_id")));
                HeyaBeanlist.setRoom_num(resultSet.getString("room_num"));
                HeyaBeanlist.setRoom_money(resultSet.getString("room_money"));
                HeyaBeanlist.setRoom_area(resultSet.getString("room_area"));
                HeyaBeanlist.setRoom_service(resultSet.getString("room_service"));
                list.add(HeyaBeanlist);

                try {
                    jc.closeDbcom();
                } catch (SQLException ex) {
                    Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    /**
     * 部屋削除メソッド
     * @param hb 
     */

    public void heyaDelete(HeyaBean hb) {
        JdbcConn jc = new JdbcConn();
        try {
            jc.getDbcom();
            StringBuffer sb = new StringBuffer();
            sb.append("delete from room_info ");
            sb.append(" where ");
            sb.append(" id = '" + hb.getId() + "'");
            sb.append(";");
            System.out.println(sb.toString());
            try {
                jc.cud(sb.toString());
            } catch (SQLException ex) {
                Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * 部屋情報更新
     * @param hb 
     */
    public void heyaUpdate(HeyaBean hb){
        JdbcConn jc = new JdbcConn();
        
        try {
            jc.getDbcom();
            StringBuffer sb = new StringBuffer();
            sb.append("Update Room_info set ");
            sb.append("room_num = ' " + hb.getRoom_num() + "',");
            sb.append("room_money = '" + hb.getRoom_money() + "',");
            sb.append("room_area = '" + hb.getRoom_area() + "',");
            sb.append("room_service = '" + hb.getRoom_service() + "'");
            sb.append(" where ");
            sb.append(" id = " + hb.getId());
            sb.append(";");
            System.out.println(sb.toString());
            try {
                jc.cud(sb.toString());
            } catch (SQLException ex) {
                Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jc.cud(sb.toString());
            } catch (SQLException ex) {
                Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    /**
     * 部屋情報挿入メソッド
     * @param room_num
     * @param room_money
     * @param room_area
     * @param room_service 
     */
    public void heyaInsert(String room_num, String room_money , String room_area , String room_service){
            JdbcConn jdbcConn = new JdbcConn();
               LocalDateTime date = LocalDateTime.now();
            
            
        try {
            jdbcConn.getDbcom();
           String sql = "insert into room_info( room_id , room_num , room_money , room_area , room_service , create_date , modify_date) "
                    + "values(" + "(select xnum from roomid)" + ",'" + room_num + "','" + room_money + "','" + room_area + "','" + room_service + " ','" + date + "','" + date + "'" + ")";
           
                try {
                    jdbcConn.cud(sql);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HeyaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
