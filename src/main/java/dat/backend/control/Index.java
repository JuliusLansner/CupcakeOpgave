package dat.backend.control;

import dat.backend.model.entities.BottomCake;
import dat.backend.model.entities.TopCake;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BottomCakeFacade;
import dat.backend.model.persistence.TopCakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Index", value = "/index")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ArrayList<BottomCake> bottomCakes = new ArrayList<>();
        boolean ifloggedin = false;

        try {
            bottomCakes = BottomCakeFacade.bottomlist();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        ArrayList<TopCake> topcakes = new ArrayList<>();
        try {
            topcakes = TopCakeFacade.topCakeList();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        session.setAttribute("ifloggedin",ifloggedin);
        session.setAttribute("topliste",topcakes);
        session.setAttribute("bottomliste",bottomCakes);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
