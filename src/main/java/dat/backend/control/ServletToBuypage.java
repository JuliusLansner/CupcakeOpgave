package dat.backend.control;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        HttpSession session = request.getSession();
        // brugernavn = Null ... -.-
        User brugernavn = (User) session.getAttribute("brugernavn");
        int belob = Integer.parseInt(request.getParameter("belob"));
        int currentSaldo = (Integer) session.getAttribute("userSaldo");

        if (currentSaldo >= belob) {
            int opdateretSaldo = currentSaldo - belob;
            try {
                UserFacade.updateSaldo(brugernavn.getUsername(),opdateretSaldo);
            } catch (SQLException | DatabaseException sqlException) {
                sqlException.printStackTrace();
                System.out.println("you are trying to pass something that is Null");
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
