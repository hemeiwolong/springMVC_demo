package com.hmb.controller;

import com.hmb.entity.vo.MessageObject;
import com.hmb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hhh");
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        MessageObject messageObject = userService.userLogin(uname, upwd);

        if (messageObject.getCode() == 1) {
            req.getSession().setAttribute("messageObject", messageObject);
            resp.sendRedirect("index.jsp");
        } else {
            req.setAttribute("messageObject", messageObject);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }
}
