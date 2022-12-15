import java.sql.*;

public class ExeSql {

    public void getSql (String sql, int type){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:music.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate(sql);
            if(type==0){
                System.out.println("Execute delete sql!!!");
            }else{
                System.out.println("Execute add sql!!!");
            }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
    public ResultSet getSql(String sql){
        Connection connection = null;
        ResultSet rs = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:music.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("nAlbums = " + rs.getString("nAlbums"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("nSongs = " + rs.getString("nSongs"));
            }
            System.out.println("Execute select sql!!!");
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return rs;
    }
}
