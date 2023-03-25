package dat.backend.model.persistence;

import dat.backend.model.entities.Product;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduktFacadeTest {

    @Test
    void createProduct() throws DatabaseException {

        int id = ProduktFacade.createProduct("jordbær","chokolade",20,50,"3");
        System.out.println(id);
    }

    @Test
    void findProduct() {
        Product product = ProduktFacade.findProduct(3);
        System.out.println(product.getOrderId());
    }
}