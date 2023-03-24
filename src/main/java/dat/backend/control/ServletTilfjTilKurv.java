package dat.backend.control;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.OrdreFacade;
import dat.backend.model.persistence.OrdreMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.text.html.CSS.getAttribute;

@WebServlet(name = "ServletTilføjTilKurv", value = "/ServletTilføjTilKurv")
public class ServletTilfjTilKurv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    TopCake topCake = (TopCake) request.getAttribute("top");
    BottomCake bottomCake = (BottomCake) request.getAttribute("bund");
    String antal = request.getParameter("antal");
    User user = (User) session.getAttribute("user");

    boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");



    if(ifloggedin == false){
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

        OrdreFacade.createordre(user.getUsername()); // Laver ordre

        ArrayList<Ordre>ordrelist = new ArrayList<>(); // Til at holde ordren (Den skal hentes fra databasen igen da id skal bruges).

        try {
            ordrelist = OrdreFacade.getOrdrelist(); // Henter ordreliste og sætter lig arrayliste.
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        for(Ordre ordre:ordrelist){ //Går igennem alle ordre for at finde ordren

        }



    //Product product = new Product(topCake.getNavn(),bottomCake.getNavn(), bottomCake.getPris()+topCake.getPris(),);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
