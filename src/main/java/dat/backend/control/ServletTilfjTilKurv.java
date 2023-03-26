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
        HttpSession session = request.getSession(); //Henter session

        boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");

        if (ifloggedin == false) { //Sørger for at man kun kan lave bestilling hvis man er logget ind
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        //Henter variable fra index.jsp.
        String topCake = request.getParameter("top");
        String bottomCake = request.getParameter("bottom");
        String antal = request.getParameter("antal");
        User user = (User) session.getAttribute("user");
        int ordreId = (int) session.getAttribute("orderId");


        // Henter lister ned med objekter
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


        // Laver tomme objekter
        TopCake topCake1 = null;
        BottomCake bottomCake1 = null;


        for (TopCake cake : topcakeList) { //Henter topcake objektet
            if (cake.getNavn().equalsIgnoreCase(topCake)) {
                topCake1 = cake;
            }
        }

        for (BottomCake cake : bottomcakeList) { //Henter bottomcake objektet
            if (cake.getNavn().equals(bottomCake)) {
                System.out.println("navn på kage"+cake.getNavn());
                bottomCake1 = cake;
            }
        }


        if (ifloggedin == false) { //Sørger for at man kun kan lave bestilling hvis man er logget ind
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }




        int productId = ProduktFacade.createProduct(topCake1.getNavn(), bottomCake1.getNavn(), bottomCake1.getPris() + topCake1.getPris(), ordreId, antal);

        ArrayList<Product>kurvIndhold = new ArrayList<>();

        ArrayList<Product>products = ProduktFacade.findProduct(ordreId); //Finder produkt vi lige har lavet

        kurvIndhold = products; //Adder produkter til vores kurv

        session.setAttribute("kurvindhold",kurvIndhold);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
