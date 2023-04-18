/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fudosanservice;

import daojdbcconn.JdbcConn;
import fudosanrepository.BukenBean;
import fudosanrepository.HeyaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *物件一覧を取得
 * @author yb
 */
public class BukenService {

    public List<BukenBean> listInfo() {
        JdbcConn jc = new JdbcConn();
        List<BukenBean> list = new ArrayList<BukenBean>();

        try {
            jc.getDbcom();

            String sql = "SELECT * FROM buken_info";

            try {
                ResultSet resultSet = jc.tt(sql);
                while (resultSet.next()) {
                    BukenBean bukenBeanlist = new BukenBean();
                    bukenBeanlist.setid(String.valueOf(resultSet.getInt("homeid")));
                    bukenBeanlist.setBuken_name(resultSet.getString("buken_name"));
                    bukenBeanlist.setAddress(resultSet.getString("address"));
                    bukenBeanlist.setEki(resultSet.getString("eki"));
                    bukenBeanlist.setGrade(resultSet.getString("grade"));
                    bukenBeanlist.setCreate_date(resultSet.getString("create_date"));
                    bukenBeanlist.setModify_date(resultSet.getString("modify_date"));
                    list.add(bukenBeanlist);

                    jc.closeDbcom();
                }

            } catch (SQLException ex) {
                Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    /**
     * 物件情報を挿入
     * @param bukenname
     * @param address
     * @param eki
     * @param grade
     * @throws SQLException 
     */
    public void bukenInsert(String bukenname, String address, String eki, String grade) throws SQLException {
        LocalDateTime date = LocalDateTime.now();
        JdbcConn jc = new JdbcConn();

        try {
            jc.getDbcom();

            int bukenid = select();
            String sql = "insert into buken_info( homeid , buken_name , address , eki , grade , create_date , modify_date) "
                    + "values('" + bukenid + "','" + bukenname + "','" + address + "','" + eki + "','" + grade + " ','" + date + "','" + date + "'" + ")";

            jc.cud(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     *物件情報の番号を取得
     * @return 
     */
    public int select() {
        try {
            String url = "jdbc:postgresql://localhost:5432/GYBYB";
            String user = "postgres";
            String password = "postgres";
            //データベーステーブル連接
            Connection conn = DriverManager.getConnection(url, user, password);
            //queryを作成する
            Statement query = conn.createStatement();
            String sql = "(select max (homeid)  from buken_info )";
            //只有在使用查询语句的时候 用的是ResultSet 查询结果后返回值
            //クエリー構文を使用する時、結果をクエリーしたを戻す値
            ResultSet resultSet = query.executeQuery(sql);
            //resultSetが次行があれば
            while (resultSet.next()) {
                //aを定義する　INT MAXの取得　
                int modosi = resultSet.getInt("max");
                //戻す値は　modosi+1
                return modosi + 1;
            }

            query.execute(sql);
            System.out.println(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return 10;

    }
    /**
     * 物件情報更新
     * @param bb
     * @throws SQLException 
     */
    public void bukenUpdate(BukenBean bb) throws SQLException {
        JdbcConn jc = new JdbcConn();

        try {
            jc.getDbcom();

            StringBuffer sb = new StringBuffer();
            sb.append("Update buken_info set ");
//            sb.append("homeid =  " + bk.getHomeid() + ",");
            sb.append("buken_name = ' " + bb.getBuken_name() + "',");
            sb.append("address = '" + bb.getAddress() + "',");
            sb.append("eki = '" + bb.getEki() + "',");
            sb.append("grade = '" + bb.getGrade() + "'");
            sb.append(" where ");
            sb.append(" homeid = " + bb.getid());
            sb.append(";");
            System.out.println(sb.toString());
            jc.cud(sb.toString());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 物件情報削除
     * @param bb
     * @throws SQLException 
     */
    public void bukenDelete(BukenBean bb) throws SQLException {
        JdbcConn jc = new JdbcConn();
        try {
            jc.getDbcom();
            StringBuffer sb = new StringBuffer();
            sb.append("delete from buken_info ");
            sb.append(" where ");
            sb.append(" homeid = '" + bb.getid() + "'");
            sb.append(";");
            System.out.println(sb.toString());
            jc.cud(sb.toString());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
