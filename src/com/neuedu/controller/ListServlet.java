package com.neuedu.controller;
import com.neuedu.pojo.Product;
import com.neuedu.pojo.ResultData;
import com.neuedu.pojo.User;
import com.neuedu.service.IProductService;
import com.neuedu.service.IUserService;
import com.neuedu.service.ProductServiceImpl;
import com.neuedu.service.UserServiceImpl;
import com.neuedu.untiltest.CookieUntil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IUserService uservice = new UserServiceImpl();
    private IProductService service = new ProductServiceImpl();

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");
        System.out.println(text);
        if (text==null){
            List<Product> lists = service.getLists();
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }else{
            List<Product> lists = service.getresult(text);
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = 3;
        ResultData data = service.getlists(pageNo,pageSize);
        data.setUrl("list");
        req.setAttribute("data",data);
        req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);

        /*req.setCharacterEncoding("utf-8");
        String text = req.getParameter("text");
        if (text==""||text=="  "){
            List<Product> lists = service.getLists();
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }else{
            List<Product> lists = service.getresult(text);
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }*/


        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> maps = CookieUntil.getCookie(cookies);
        Cookie coo = maps.get("username");
        String uname= coo.getValue();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        List<Product> lists = service.getLists();
        req.setAttribute("lists",lists);
        if(u==null){
            User user = uservice.getOne(uname);
            session.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);

        }else{
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");
        System.out.println(text);
        if (text==""||text.equals("  ")){
            List<Product> lists = service.getLists();
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }else{
            List<Product> lists = service.getresult(text);
            req.setAttribute("lists",lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }
    }
}
