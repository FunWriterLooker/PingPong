package ie.mtu.cs.oo.ass1.Database;

import ie.mtu.cs.oo.ass1.model.Game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public Game getGame(String name) throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from game where name='"+name+"';";
        System.out.println(sql);
        ResultSet rs= statement.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getString("player1Name"));
            System.out.println(rs.getString("player1Name"));
// just to compile and use
        }
        return null;
    }
}