package dat.backend.model.persistence;

import dat.backend.model.entities.TopCake;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TopCakeFacadeTest {
    private ConnectionPool connectionPool;

    @BeforeAll
    void setup() throws SQLException {
        this.connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }

    @Test
    void topCakeList() throws DatabaseException {
        ArrayList<TopCake>list = TopCakeFacade.topCakeList(connectionPool);
        System.out.println(list);
    }
}