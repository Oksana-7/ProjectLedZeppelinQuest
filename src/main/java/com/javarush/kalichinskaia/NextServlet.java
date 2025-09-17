package com.javarush.kalichinskaia;

import com.javarush.kalichinskaia.quest.Step;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/step"})
public class NextServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Integer stepIndex = (Integer) session.getAttribute("stepIndex");
        int answer = Integer.parseInt(req.getParameter("answer"));

        if (answer == 0) {
            cleanSession(session);
            req.setAttribute("message", Step.values()[stepIndex].getEndMessage());
            req.getRequestDispatcher("/end.jsp").forward(req, resp);
            return;
        }

        stepIndex++;

        if (stepIndex >= Step.values().length) {
            cleanSession(session);
            req.setAttribute("message", "Тебя вернули домой. Победа");
            req.getRequestDispatcher("/end.jsp").forward(req, resp);
        } else {
            session.setAttribute("stepIndex", stepIndex);
            Step step = Step.values()[stepIndex];
            req.setAttribute("question", step.getQuestion());
            req.setAttribute("answer1", step.getAnswer1());
            req.setAttribute("answer2", step.getAnswer2());
            req.getRequestDispatcher("/quest.jsp").forward(req, resp);
        }
    }

    private void cleanSession(HttpSession session) {
        session.removeAttribute("stepIndex");
        session.removeAttribute("username");
    }
}
