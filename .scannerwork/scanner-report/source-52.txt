package fr.cnam.pdatabase;

import fr.cnam.pdatabase.managment.dao.DateActivityDAO;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


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
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(DateActivityDAO.class.getSimpleName());

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
            // ****** A CONFIGURER (PAS ENCORE TESTÉ COMME ÇA...)
            String password = System.getProperty("database.password");

            String url = typeBase + "://"+ ip +": "+ port +"/"+ databaseName + databaseOption;

            Class.forName(driverName);

            this.connection = DriverManager.getConnection(url, login, password);
            response = true;

        } catch (Exception e) {
            this.logger.log(Level.INFO, () -> "Something went wrong: "+ e);
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
        this.logger.log(Level.INFO, () -> "info (getMysqlConnexionInstance): "+ this.connection);
        return false;
    }

}