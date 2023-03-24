package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduktFacadeTest {

    @Test
    void createProduct() throws DatabaseException {
        int ordreid = OrdreFacade.createordre("user");
        ProduktFacade.createProduct("jordbær","chokolade",11,ordreid,2);
    }
}