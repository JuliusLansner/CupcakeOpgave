package dat.backend.control;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BottomCakeFacade;
import dat.backend.model.persistence.OrdreFacade;
import dat.backend.model.persistence.ProduktFacade;
import dat.backend.model.persistence.TopCakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletTilføjTilKurv", value = "/ServletTilføjTilKurv")
public class ServletTilfjTilKurv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //22-26 henter variable.
        String topCake = request.getParameter("top");
        String bottomCake = request.getParameter("bund");
        String antal = request.getParameter("antal");
        int ordreId = 0;
        HttpSession session = request.getSession(); //Henter session
        User user = (User) session.getAttribute("user");
        boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");


        // 31-32 Henter lister ned med objekter
        ArrayList<TopCake> topcakeList = new ArrayList<>();
        try {
            topcakeList = TopCakeFacade.topCakeList();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        ArrayList<BottomCake> bottomcakeList = new ArrayList<>();
        try {
            bottomcakeList = BottomCakeFacade.bottomlist();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        System.out.println("1");
        // 35-36 Laver tomme objekter
        TopCake topCake1 = null;
        BottomCake bottomCake1 = null;
        System.out.println("2");
        for (TopCake cake : topcakeList) { //Laver topcake objekt
            if (cake.getNavn().equalsIgnoreCase(topCake)) {
                topCake1 = cake;
            }
        }

        for (BottomCake cake : bottomcakeList) { //Laver bottomcake objekt
            if (cake.getNavn().equals(bottomCake)) {
                System.out.println("navn på kage"+cake.getNavn());
                bottomCake1 = cake;
            }
        }
        System.out.println("3");

        if (ifloggedin == false) { //Sørger for at man kun kan lave bestilling hvis man er logget ind
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        System.out.println("4");
        try {
            ordreId = OrdreFacade.createordre(user.getUsername());
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        System.out.println("5");
        ProduktFacade.createProduct(topCake1.getNavn(), bottomCake1.getNavn(), bottomCake1.getPris() + topCake1.getPris(), ordreId, antal);
        System.out.println("6");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
