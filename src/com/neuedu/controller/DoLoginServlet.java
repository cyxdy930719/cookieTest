package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/dologin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = service.getOne(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                /*长时间存贮 有session*/
                Cookie coo = new Cookie("username",username);
                Cookie coop = new Cookie("password",password);
                coo.setMaxAge(60*60*24*7);
                coo.setMaxAge(60*60*24*7);
                resp.addCookie(coo);
                resp.addCookie(coop);
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect("list");
            }
        }

    }
}
