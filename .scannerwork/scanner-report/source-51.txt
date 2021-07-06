package fr.cnam.pdatabase.managment.dao;

import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.penums.ErrorMessage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DateActivityDAO implements DAO<DateActivityItem> {

    /**
     * @param connection
     * Constructeur
     */
    public DateActivityDAO(Connection connection) {
        super();
        this.connection = connection;
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(DateActivityDAO.class.getSimpleName());

    /**
     * Connection
     */
    private transient Connection connection;



    /**
     *
     * @param dateValue
     * @param connection
     * @return DateActivityItem
     */
    public DateActivityItem findByDate(java.sql.Date dateValue, Connection connection) {

        this.connection = connection;

        // **** convertion du format 'Date' -> 'Long' pour la BDD:
        Long convertedDateToLong = dateValue.getTime();

        // *** création d'un nouvel objet 'DateActivityItem'
        DatePart datePart = new DatePart();
        DateActivityItem dateActivityItem = new DateActivityItem();
        dateActivityItem.setDatePart(datePart);


        String sql = "SELECT DISTINCT d.DATEPART_ID, d.DATEPART_VALUE, da.DATE_ACTIVITY_ID, da.DATE_ACTIVITY_DESCRIPTION, da.DATE_ACTIVITY_STATUS "+
                "FROM DATEPART d LEFT JOIN DATE_ACTIVITY da "+
                "ON d.DATEPART_ID = da.DATEPART_ID "+
                "WHERE d.DATEPART_VALUE = ?;";

        try (PreparedStatement selectPrepared = connection.prepareStatement(sql)) {

            selectPrepared.setLong(1, convertedDateToLong);
            ResultSet rsSelect = selectPrepared.executeQuery();

            while(rsSelect.next()) {
                if(dateActivityItem.getDatePart() != null) {
                    dateActivityItem.getDatePart().setDatePartId(rsSelect.getInt(1));
                    dateActivityItem.getDatePart().setDatePartValue(rsSelect.getLong(2));
                    dateActivityItem.setDateActivityDescription(rsSelect.getString(4));
                    dateActivityItem.setDateActivityStatus(rsSelect.getString(5));
                }
            }

            rsSelect.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
        }

        return dateActivityItem;
    }


    /**
     *
     * @param dateActivityItem
     * @return boolean
     */
    @Override
    public boolean create(DateActivityItem dateActivityItem) {

        boolean response = false;

        String sql =  "INSERT INTO DATEPART (DATEPART_VALUE) VALUES(?); "+
                "INSERT INTO DATE_ACTIVITY (DATEPART_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS) "+
                "VALUES (LAST_INSERT_ID(), ?, ?)";

        try (PreparedStatement insertSQL = connection.prepareStatement(sql)) {

            insertSQL.setLong(1, dateActivityItem.getDatePart().getDatePartValue());
            insertSQL.setString(2, dateActivityItem.getDateActivityDescription());
            insertSQL.setString(3, dateActivityItem.getDateActivityStatus());

            int nbrCreate = insertSQL.executeUpdate();

            response = (nbrCreate > 0);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            response = false;
        }
        return response;
    }


    /**
     * @param formatedNewDateAsLong
     * @return boolean
     */
//    @Override
    public boolean delete(Long formatedNewDateAsLong) {

        boolean response;

        // *** première requête sur une seule table, sinon souci...
        String sql = "DELETE FROM DATE_ACTIVITY WHERE DATEPART_ID = (SELECT DATEPART_ID FROM DATEPART WHERE DATEPART_VALUE = ? LIMIT 1); DELETE FROM DATEPART WHERE DATEPART_VALUE = ?;";

        try (PreparedStatement deleteSQL = connection.prepareStatement(sql)) {

            deleteSQL.setLong(1, formatedNewDateAsLong);
            deleteSQL.setLong(2, formatedNewDateAsLong);

            int nbrUpdate = deleteSQL.executeUpdate();

            response = (nbrUpdate > 0);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            response = false;
        }

        return response;
    }


    /**
     * @param dateActivityItem
     * @return boolean
     */
    @Override
    public boolean update(DateActivityItem dateActivityItem) {

        boolean response;

        String sql = "UPDATE DATEPART SET DATEPART_VALUE = ? WHERE DATEPART_ID = ?; "+
                "UPDATE DATE_ACTIVITY SET DATE_ACTIVITY_DESCRIPTION = ?, DATE_ACTIVITY_STATUS = ? "+
                "WHERE DATEPART_ID = ?; ";

        try (PreparedStatement updatePrepared = connection.prepareStatement(sql)) {

            // *** on 'set' tout sauf 'getEmployee_id()',car c'est un update:
            updatePrepared.setLong(1, dateActivityItem.getDatePart().getDatePartValue());
            updatePrepared.setInt(2, dateActivityItem.getDatePart().getDatePartId());
            updatePrepared.setString(3, dateActivityItem.getDateActivityDescription());
            updatePrepared.setString(4, dateActivityItem.getDateActivityStatus());
            updatePrepared.setInt(5, dateActivityItem.getDatePart().getDatePartId());

            int nbrUpdate = updatePrepared.executeUpdate();
            response = (nbrUpdate > 0);

        } catch(SQLException e) {
            logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            response  = false;
        }

        boolean finalResponse = response;
        this.logger.log(Level.INFO, () -> ErrorMessage.BDD_CONNECT_ERROR + finalResponse);

        return finalResponse;
    }


    @Override
    public boolean delete(DateActivityItem obj) {
        /**
         * pas utilisée mais obligatoire (implémentation d'interface)
          */
        return false;
    }


    @Override
    public DateActivityItem find(int datePartId) {
        /**
         * pas utilisée ici mais obligatoire (implémentation d'interface)
         */
        return null;
    }

}
