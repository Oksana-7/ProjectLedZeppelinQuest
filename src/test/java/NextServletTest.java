import com.javarush.kalichinskaia.NextServlet;
import com.javarush.kalichinskaia.quest.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.*;

public class NextServletTest extends BaseIT {
    private NextServlet nextServlet;

    @BeforeEach
    void setUp() {
        nextServlet = new NextServlet();
    }

    @ParameterizedTest
    @CsvSource({"0", "1",})
    void moveToNextStep(int stepIndex) throws Exception {
        when(req.getMethod()).thenReturn("POST");
        when(session.getAttribute("stepIndex")).thenReturn(stepIndex);
        when(req.getParameter("answer")).thenReturn("1");
        when(req.getRequestDispatcher("/quest.jsp")).thenReturn(dispatcher);

        nextServlet.service(req, resp);

        int nextStepIndex = stepIndex + 1;
        verify(session).setAttribute("stepIndex", nextStepIndex);
        verify(req).setAttribute("question", Step.values()[nextStepIndex].getQuestion());
        verify(req).setAttribute("answer1", Step.values()[nextStepIndex].getAnswer1());
        verify(req).setAttribute("answer2", Step.values()[nextStepIndex].getAnswer2());
        verify(req).getRequestDispatcher("/quest.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    void moveToEndWithNegativeAnswer(int stepIndex) throws Exception {
        when(req.getMethod()).thenReturn("POST");
        when(session.getAttribute("stepIndex")).thenReturn(stepIndex);
        when(req.getParameter("answer")).thenReturn("0");
        when(req.getRequestDispatcher("/end.jsp")).thenReturn(dispatcher);

        nextServlet.service(req, resp);

        verify(req).setAttribute("message", Step.values()[stepIndex].getEndMessage());
        verify(req).getRequestDispatcher("/end.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    void transitionFromStepTwoToThreeWithPositiveAnswer() throws Exception {
        int stepIndex = 2;
        when(req.getMethod()).thenReturn("POST");
        when(session.getAttribute("stepIndex")).thenReturn(stepIndex);
        when(req.getParameter("answer")).thenReturn("1");
        when(req.getRequestDispatcher("/end.jsp")).thenReturn(dispatcher);

        nextServlet.service(req, resp);

        verify(req).setAttribute("message", "Тебя вернули домой. Победа");
        verify(req).getRequestDispatcher("/end.jsp");
        verify(dispatcher).forward(req, resp);
    }
}
