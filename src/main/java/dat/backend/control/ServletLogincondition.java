package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "ServletLogincondition", value = "/ServletLogincondition")
public class ServletLogincondition extends HttpServlet {


    @Override


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.setContentType("text/html");
        HttpSession session = request.getSession();
       // session.setAttribute("user", null); // invalidating user object in session scope
          session = request.getSession();
            // adding user object to session scope
                User user = (User) session.getAttribute("user");
        //System.out.println(user.getRole());
           if (user.getRole().equals("admin")){
               request.getRequestDispatcher("WEB-INF/welcomeAdmin.jsp").forward(request, response);
            } else if (!user.getRole().equals("admin")){

                request.getRequestDispatcher("WEB-INF/welcomeUser.jsp").forward(request,response);
            }



    }


}


