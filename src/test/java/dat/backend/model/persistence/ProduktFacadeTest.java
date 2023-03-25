package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduktFacadeTest {

    @Test
    void createProduct() throws DatabaseException {

        ProduktFacade.createProduct("jordbær","chokolade",20,50,"3");
    }
}