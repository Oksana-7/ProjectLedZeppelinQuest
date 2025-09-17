import com.javarush.kalichinskaia.IntroduceServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IntroduceServletTest extends BaseIT {
    private IntroduceServlet introduceServlet;

    @BeforeEach
    void setUp() {
        introduceServlet = new IntroduceServlet();
    }

    @Test
    void redirectToQuestPage() throws Exception {
        when(req.getMethod()).thenReturn("POST");
        when(req.getRemoteAddr()).thenReturn("0:0:0:0:0:0:0:1");
        when(req.getParameter("username")).thenReturn("user");

        introduceServlet.service(req, resp);

        verify(session).setAttribute("ip", "0:0:0:0:0:0:0:1");
        verify(session).setAttribute("username", "user");
        verify(resp).sendRedirect("/quest");

    }
}
