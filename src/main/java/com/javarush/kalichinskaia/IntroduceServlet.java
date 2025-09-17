package com.javarush.kalichinskaia;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "IntroduceServlet", value = "/introduce")
public class  IntroduceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession(true);
        String ip = req.getRemoteAddr();
        currentSession.setAttribute("ip", ip);
        String username = req.getParameter("username");
        currentSession.setAttribute("username", username);
        resp.sendRedirect("/quest");
    }
}
