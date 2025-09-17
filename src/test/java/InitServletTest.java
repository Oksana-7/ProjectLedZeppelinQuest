import com.javarush.kalichinskaia.InitServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InitServletTest extends BaseIT {
    private InitServlet initServlet;

    @BeforeEach
    void setUp() {
        initServlet = new InitServlet();
    }

    @Test
    void moveToIndexPage() throws Exception {
        when(req.getMethod()).thenReturn("GET");
        when(req.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);

        initServlet.service(req, resp);

        verify(req).getRequestDispatcher("/index.jsp");
        verify(dispatcher).forward(req, resp);
    }

}