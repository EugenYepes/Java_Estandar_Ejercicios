import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType(("text/html"));
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Java</title></head>");
            out.println("<body style = 'text-alingn: center'>");
            out.println("<h1>hola lpm</h1>");
            out.println("</body></html>");
        } finally{
            out.close();
        }
    }
}