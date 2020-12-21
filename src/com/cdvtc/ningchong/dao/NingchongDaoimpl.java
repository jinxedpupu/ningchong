package com.cdvtc.ningchong.dao;

import com.cdvtc.ningchong.db.DBConnection;
import com.cdvtc.ningchong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NingchongDaoimpl implements NingchongDao{

    DBConnection db = new DBConnection();

    @Override
    public User getUser(String userzhanghao, String userpassword) {

        try {
            Connection con = db.getConnection();
            //执行查询
            PreparedStatement pst = con.prepareStatement("select  * from  user where  userzhanghao = ? and userpassword = ?");
            pst.setString(1,userzhanghao);
            pst.setString(2,userpassword);

            ResultSet rs = pst.executeQuery();

            //处理结果集
            if(rs.next()){
                //获取行数据封装成管理员对象
                User user = new User();
                user.setUserzhanghao(userzhanghao);
                //System.out.println(user.getUserzh());
                user.setUserpassword(userpassword);
                user.setUserid(rs.getInt("userid"));
                user.setUserdianhua(rs.getString("userdianhua"));
                user.setUserdizhi(rs.getString("userdizhi"));
                user.setUseryue(rs.getInt("useryue"));
                // 关闭连接，释放资源
                rs.close();
                pst.close();
                con.close();
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;//未找到对象
    }

    @Override
    public void addUser(User user) {
        try {
            // 获取连接
            Connection con = db.getConnection();

            // 执行SQL语句
            PreparedStatement pst = con.prepareStatement("insert into user(userzhanghao,userpassword,userdianhua,userdizhi,useryue) values(?,?,?,?,0)");
            pst.setString(1, user.getUserzhanghao());
            pst.setString(2, user.getUserpassword());
            pst.setString(3, user.getUserdianhua());
            pst.setString(4, user.getUserdizhi());

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
