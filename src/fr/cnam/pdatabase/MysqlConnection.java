package fr.cnam.pdatabase;

import java.sql.*;
import java.sql.DriverManager;


/**
 * @author Yannis Guéguen
 */
public class MysqlConnection implements MysqlConnectionInterface {

    /**
     * Default constructor
     */
    public MysqlConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * Connection
     */
    private Connection connection;


    /**
     *
     * @return boolean
     * @throws SQLException
     */
    public boolean connection() throws SQLException {

        boolean response = false;

        try {

            String driverName = "com.mysql.cj.jdbc.Driver";
            String typeBase = "jdbc:mysql";
            String ip = "127.0.0.1";
            String port = "3306";
            String databaseName = "NFA019_CALENDAR_APP";
            String databaseOption = "?allowMultiQueries=true";
            String login = "root";
            String password = "test";

            String url = typeBase + "://"+ ip +": "+ port +"/"+ databaseName + databaseOption;

            Class.forName(driverName);

            this.connection = DriverManager.getConnection(url, login, password);
            response = true;

        } catch (Exception e) {
            System.out.println(e);
            response = false;
        }

        return response;
    }


    /**
     * @return Connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * @param connection
     * @return void
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    /**
     * @return
     */
    public boolean getMysqlConnexionInstance() {
        // TODO implement here
        return false;
    }

}