package com.javarush.kalichinskaia;

import com.javarush.kalichinskaia.quest.Step;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        Integer savedStepIndex = (Integer) session.getAttribute("stepIndex");
        int stepIndex = savedStepIndex == null ? 0 : savedStepIndex;

        session.setAttribute("stepIndex", stepIndex);

        Step step = Step.values()[stepIndex];
        req.setAttribute("question", step.getQuestion());
        req.setAttribute("answer1", step.getAnswer1());
        req.setAttribute("answer2", step.getAnswer2());
        req.getRequestDispatcher("/quest.jsp").forward(req, resp);
    }
}
