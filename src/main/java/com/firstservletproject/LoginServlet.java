package com.firstservletproject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet",
        urlPatterns = {"/LoginServlet"},
        initParams ={
                @WebInitParam(name="user",value = "Prajakta"),
                @WebInitParam(name="password", value= "14Praju@")
        }
)

public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        String userRegex = "^[A-Z]{1}+[a-z]{2,}"; // pattern for valid name
        String pwdRegex = "^.*(?=.*[A-Z])(?=.*[0-9])([a-z])(?=.*[@#$%^&+=])(?=.{8,}).*$"; //pattern for valid passwprd

        String userId  = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if(Pattern.matches(pwdRegex, pwd) && Pattern.matches(userRegex, user))
        {
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginServlet.jsp").forward(req,response);
        }
        else
        {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> Either username or password is incorrect.</font>");
            requestDispatcher.include(req,response);
        }
    }
}