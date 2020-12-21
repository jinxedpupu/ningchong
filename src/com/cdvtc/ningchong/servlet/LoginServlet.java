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

@WebServlet(name = "LoginServlet" ,urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取参数
        request.setCharacterEncoding("UTF-8"); //设置编码，只针对POST提交有效
        String userzhanghao = request.getParameter("userzhanghao");
        String userpassword = request.getParameter("userpassword");

        // 验证
        NingchongDao dao = new NingchongDaoimpl();
        User user = dao.getUser(userzhanghao, userpassword);
        if (user != null) {
            //成功//通过request获取session// 将信息保存在Session中（向其它页面共享数据）
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("homepage.jsp");
            // 重置页面（前转）：首面
        } else {
            //失败
            request.setAttribute("error", "账户或密码错误！");
            request.getRequestDispatcher("login_user.jsp").forward(request, response);
            // 前面页面：登陆页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}