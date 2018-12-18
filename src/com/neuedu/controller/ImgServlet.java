package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/img.jsp").forward(req,resp);
        Part part = req.getPart("file");
        String str = "D:\\cookieTest\\web\\img\\"+part.getSubmittedFileName();
        File file = new File("D:\\cookieTest\\web\\img\\"+part.getSubmittedFileName());
        String url= str.substring(str.indexOf("img"));
        System.out.println(url);
        OutputStream os = new FileOutputStream(file);
        byte[] b = new byte[1024];
        InputStream is = part.getInputStream();
        int a = is.read(b,0,b.length);
        while(a!=-1){
            os.write(b);
            a=is.read(b,0,b.length);
        }
    }
}
