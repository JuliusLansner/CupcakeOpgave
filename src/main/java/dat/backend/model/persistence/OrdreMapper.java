package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdreMapper {

static ArrayList<Ordre> ordreliste(ConnectionPool connectionPool) throws DatabaseException {
String sql ="SELECT * FROM ordre";
ArrayList<Ordre> ordreliste = new ArrayList<>();

    try(Connection connection = connectionPool.getConnection()){

        try(PreparedStatement pre = connection.prepareStatement(sql)){
            ResultSet rs = pre.executeQuery(); //Laver resultset baseret på ordre fra databasen

            while(rs.next()){
                Ordre ordre = new Ordre(0,"null",null); //Laver et ordre objekt.

                //Sætter ordre til at passe med ordre fra databasen.
                ordre.setOrdreId(rs.getInt(1));
                ordre.setBrugernavn(rs.getString(2));
                ordre.setDato(rs.getTimestamp(3));

                ordreliste.add(ordre); //Adder ordre til ArrayList.
            }
        }catch (SQLException ex){
            throw new DatabaseException(ex, "Something with the sql or the java syntax is wrong");
        }

    }catch(SQLException e){
        throw new DatabaseException(e, "Error logging in. Something went wrong with the database");
    }

    return ordreliste;
}
}
