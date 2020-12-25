package com.cdvtc.ningchong.servlet;

import com.cdvtc.ningchong.dao.NingchongDao;
import com.cdvtc.ningchong.dao.NingchongDaoimpl;
import com.cdvtc.ningchong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserRechargeServlet" ,urlPatterns = "/UserRechargeServlet")
public class UserRechargeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取参数
        request.setCharacterEncoding("UTF-8"); //设置编码，只针对POST提交有效
        String useryues = request.getParameter("useryue");
        int useryue = Integer.parseInt(useryues);

        NingchongDao dao = new NingchongDaoimpl();
        User user = new User();
        user.setUseryue(useryue);

        //将数据写入数据库
        dao.addUser(user);

        response.sendRedirect("index.jsp");//页面跳转到 - 首页

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}