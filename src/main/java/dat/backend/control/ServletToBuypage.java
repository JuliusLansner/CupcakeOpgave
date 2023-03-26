package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletToBuypage", value = "/ServletToBuypage")
public class ServletToBuypage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");

        if(ifloggedin==false){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        request.getRequestDispatcher("buypage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
