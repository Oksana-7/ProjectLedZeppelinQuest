import com.javarush.kalichinskaia.QuestServlet;
import com.javarush.kalichinskaia.quest.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuestServletTest extends BaseIT {
    private QuestServlet questServlet;

    @BeforeEach
    void setUp() {
        questServlet = new QuestServlet();
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    void moveToQuestPage(int stepIndex) throws Exception {
        when(req.getMethod()).thenReturn("GET");
        when(session.getAttribute("stepIndex")).thenReturn(stepIndex);
        when(req.getRequestDispatcher("/quest.jsp")).thenReturn(dispatcher);

        questServlet.service(req, resp);

        verify(req).setAttribute("question", Step.values()[stepIndex].getQuestion());
        verify(req).setAttribute("answer1", Step.values()[stepIndex].getAnswer1());
        verify(req).setAttribute("answer2", Step.values()[stepIndex].getAnswer2());
        verify(req).getRequestDispatcher("/quest.jsp");
        verify(dispatcher).forward(req, resp);
    }

    @Test
    void moveToQuestPageWithStepIndexNull() throws Exception {
        int stepIndex = 0;

        when(req.getMethod()).thenReturn("GET");
        when(session.getAttribute("stepIndex")).thenReturn(null);
        when(req.getRequestDispatcher("/quest.jsp")).thenReturn(dispatcher);

        questServlet.service(req, resp);

        verify(req).setAttribute("question", Step.values()[stepIndex].getQuestion());
        verify(req).setAttribute("answer1", Step.values()[stepIndex].getAnswer1());
        verify(req).setAttribute("answer2", Step.values()[stepIndex].getAnswer2());
        verify(req).getRequestDispatcher("/quest.jsp");
        verify(dispatcher).forward(req, resp);
    }
}
