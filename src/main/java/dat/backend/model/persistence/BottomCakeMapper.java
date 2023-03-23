package dat.backend.model.persistence;

import dat.backend.model.entities.BottomCake;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BottomCakeMapper {

    static ArrayList<BottomCake> bottomList(ConnectionPool connectionPool) throws DatabaseException {
        String sql ="SELECT * FROM bund";
        ArrayList<BottomCake> bundlist = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()){

            try(PreparedStatement pre = connection.prepareStatement(sql)){
                ResultSet rs = pre.executeQuery();

                while(rs.next()){
                    BottomCake bottomCake = new BottomCake(null,0);


                    bottomCake.setNavn(rs.getString(1));
                    bottomCake.setPris(rs.getInt(2));

                    bundlist.add(bottomCake);
                }
            }catch (SQLException ex){
                throw new DatabaseException(ex, "Something with the sql or the java syntax is wrong");
            }

        }catch(SQLException e){
            throw new DatabaseException(e, "Error logging in. Something went wrong with the database");
        }

        return bundlist;
    }
}
