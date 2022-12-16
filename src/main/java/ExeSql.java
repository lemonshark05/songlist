import java.sql.*;
/**
 * @author zhimin
 * @version 1.1
 */
public class ExeSql {
    /**
     * @param sql
     * @param type
     */
    public void getSql (String sql, int type){
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:songlist.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate(sql);
            if(type!=0){
                System.out.println(sql);
                System.out.println("Execute add sql!!!");
            };
        }catch (SQLException e) {
            System.out.println(e.getMessage());
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

    /**
     * @param sql
     */
    public void showSql(String sql){
        Connection connection = null;
        ResultSet rs = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:songlist.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("artist = " + rs.getString("artist"));
                System.out.println("album = " + rs.getString("album"));
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
    }

    /**
     * @param sql
     * @return
     */
    public Playlist getSqllist(String sql){
        Connection connection = null;
        ResultSet rs = null;
        Playlist play = new Playlist();
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:songlist.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            rs = statement.executeQuery(sql);
            play.getInfo(rs);
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
        return play;
    }
}
