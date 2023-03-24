package dat.backend.control;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.OrdreFacade;
import dat.backend.model.persistence.ProduktFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTilføjTilKurv", value = "/ServletTilføjTilKurv")
public class ServletTilfjTilKurv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();
    TopCake topCake = (TopCake) request.getAttribute("top");
    BottomCake bottomCake = (BottomCake) request.getAttribute("bund");
    int antal = Integer.parseInt(request.getParameter("antal"));
    int ordreId = 0;

    User user = (User) session.getAttribute("user");

    boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");



    if(ifloggedin == false){
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


        try {
            ordreId = OrdreFacade.createordre(user.getUsername());
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        ProduktFacade.createProduct(topCake.getNavn(),bottomCake.getNavn(), bottomCake.getPris()+topCake.getPris(),ordreId,antal);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
