package com.cdvtc.ningchong.servlet;

import com.cdvtc.ningchong.dao.NingchongDao;
import com.cdvtc.ningchong.dao.NingchongDaoimpl;
import com.cdvtc.ningchong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet" ,urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取参数
        request.setCharacterEncoding("UTF-8"); //设置编码，只针对POST提交有效
        String userzhanghao = request.getParameter("userzhanghao");
        String userpassword = request.getParameter("userpassword");
        String userdianhua = request.getParameter("userdianhua");
        String userdizhi = request.getParameter("userdizhi");

        String error_userzh =null;
        String error_userdh = null;
        //验证
        if(userzhanghao == null || userzhanghao.length()<2){
            error_userzh = "账号不能为空！";
        }

        if(userdianhua == null || userdianhua.length()<11){
            error_userdh = "手机号码格式不对！";
        }

        if(error_userzh == null && error_userdh == null){//成功：将数据写入数据库，返回首页
            NingchongDao dao = new NingchongDaoimpl();
            User user = new User();
            user.setUserzhanghao(userzhanghao);
            user.setUserpassword(userpassword);
            user.setUserdianhua(userdianhua);
            user.setUserdizhi(userdizhi);

            //将数据写入数据库
            dao.addUser(user);

            response.sendRedirect("index.jsp");//页面跳转到 - 首页
        }else{//失败：返回注册页面，增加错误提示
            request.setAttribute("error_userzh",error_userzh);//将错误信息写入请求对象中，用于注册页面进行错误信息提示
            request.setAttribute("error_userdh",error_userdh);
            request.getRequestDispatcher("register_uesr.jsp").forward(request, response);//前转至页面：注册页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}