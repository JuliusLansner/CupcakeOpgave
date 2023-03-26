package dat.backend.control;

import dat.backend.model.entities.Product;
import dat.backend.model.persistence.ProduktFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletRemoveFromBasket", value = "/ServletRemoveFromBasket")
public class ServletRemoveFromBasket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();

    String order = request.getParameter("order");
    int productId = Integer.parseInt(order);


    ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("kurvindhold");

    for(Product product:products){
        if(product.getProductId()==productId){
            products.remove(product);
            ProduktFacade.deleteProductWithProductId(productId);
        }
    }

    session.setAttribute("kurvindhold",products);
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
