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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
//        String userzh= user.getUserzhanghao();

        String error_useryue =null;
        //验证
        if(useryues == null){
            error_useryue = "请输入充值金额！";
        }


        if(error_useryue == null){//成功：将数据写入数据库，返回首页
            NingchongDao dao = new NingchongDaoimpl();
            user.setUseryue(useryue);
            System.out.println(user.getUserzhanghao());
            System.out.println(user.getUseryue());

            //将数据写入数据库
            dao.adduseryue(user);

            response.sendRedirect("index.jsp");//页面跳转到 - 首页

        }else{//失败：返回注册页面，增加错误提示
            request.setAttribute("error_useryue",error_useryue);//将错误信息写入请求对象中，用于注册页面进行错误信息提示
            request.getRequestDispatcher("recharge.jsp").forward(request, response);//前转至页面：注册页面
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}