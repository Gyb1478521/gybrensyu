/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fudosanservice;

import daojdbcconn.JdbcConn;
import fudosanrepository.BukenBean;
import fudosanrepository.HeyaBean;
import fudosanrepository.NyuKyoSyaInfoBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *管理用一覧
 * @author yb
 */
public class KanriService {

    public List<NyuKyoSyaInfoBean> kanrilistInfo() {
        JdbcConn jc = new JdbcConn();
        List<NyuKyoSyaInfoBean> list = new ArrayList<NyuKyoSyaInfoBean>();
        try {
            jc.getDbcom();
            String sql = "select buken_name ,room_num , name ,checkdate ,  room_money    from buken_info  "
                    + "left join room_info on buken_info.homeid = room_info.room_id "
                    + "left join user_info on room_info.room_num = user_info.user_room order by room_num";

            ResultSet resultSet;
            try {
                resultSet = jc.tt(sql);
                            while (resultSet.next()) {
                NyuKyoSyaInfoBean nyuKyoSyaInfoBean = new NyuKyoSyaInfoBean();
                BukenBean bukenBean = new BukenBean();
                HeyaBean heyaBean = new HeyaBean();
                bukenBean.setBuken_name("buken_name");
                heyaBean.setRoom_num("room_num");
                nyuKyoSyaInfoBean.setUser_name("name");
                nyuKyoSyaInfoBean.setUserCheckdate("checkdate");
                heyaBean.setRoom_money("room_money");
                

            }
            } catch (SQLException ex) {
                Logger.getLogger(KanriService.class.getName()).log(Level.SEVERE, null, ex);
            }



        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KanriService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String checkSatat(String sta) {
        String x;
        if (sta != null) {
            x = "入居者いる";
            return x;
        } else {
            x = "空室";
            return x;
        }
    }

    //管理
    public String kanRi(int kr) {
        String x;
        x = kr + "";
        x = "+1000";
        return x;
    }

    
    public String maxMin(int price) {
        String x;
        if (price > 30000) {
            //強制タイプ転換
            x = price + "";
            return x;
        } else {
            x = "" + price;
            return x;
        }
    }
   //税金計算メソッド
    public String money(int price, int prices) {
        String x;
        x = (price + prices) / 10 + "";
        return x;
    }
    //月額残高
    public String getMoney(int price, int prices) {
        String x;
        x = (price + 1000) - prices + "";
        return x;
    }
}
