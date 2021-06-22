package fr.cnam.pdatabase.managment.dao;

import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;

import java.sql.*;

public class DateActivityDAO extends DAO<DateActivityItem> {

    // *** ajout perso:
    private Connection connection;

    public DateActivityDAO(Connection conn) {
        super(conn);
        // *** ajout perso:
        this.connection = conn;
    }

    // *****************************

    /**
     *
     * @param dateValue
     * @param connection
     * @return DateActivityItem
     */
    public DateActivityItem findByDate(Date dateValue, Connection connection) {  // datePartId passée ici... (= recherche sur la date)

        this.connection = connection;

//        System.out.println(dateValue);

        // **** convertion du format 'Date' -> 'Long' pour la BDD:
        Long convertedDateToLong = dateValue.getTime();
//        System.out.println("Converted Date du jour to Long : "+ convertedDateToLong); // ex: (date actuelle) 1622449832100L
        java.sql.Date ConvertedDateJour = new java.sql.Date(convertedDateToLong);
//        System.out.println("Converted Date du jour from Long : "+ ConvertedDateJour);   // date actuelle - ex: '2021-05-31' = premier jour de la page de juin

        DatePart datePart = new DatePart();
        DateActivityItem dateActivityItem = new DateActivityItem();
        dateActivityItem.setDatePart(datePart);
//        System.out.println(dateActivityItem);
//        System.out.println("getDatePart : "+ dateActivityItem.getDatePart());
//        System.out.println(this.connection);

        String sql = "SELECT DISTINCT d.DATEPART_ID, d.DATEPART_VALUE, da.DATE_ACTIVITY_ID, da.DATE_ACTIVITY_DESCRIPTION, da.DATE_ACTIVITY_STATUS "+
                "FROM DATEPART d INNER JOIN DATE_ACTIVITY da "+
                "ON d.DATEPART_ID = da.DATEPART_ID "+
                "WHERE d.DATEPART_VALUE = ?;";

        try (PreparedStatement selectPrepared = connection.prepareStatement(sql)) {
            // REQUÊTE GÉNÉRALE:
//            SELECT d.DATEPART_ID, DATEPART_VALUE, DATE_ACTIVITY_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS FROM DATEPART d INNER JOIN DATE_ACTIVITY da ON d.DATEPART_ID = da.DATEPART_ID WHERE d.DATEPART_ID = 45;

            selectPrepared.setLong(1, convertedDateToLong);
//            selectPrepared.setLong(1, convertedDateToLong);
            ResultSet rsSelect = selectPrepared.executeQuery();

            while(rsSelect.next()) {
                System.out.println(dateActivityItem.getDatePart());
                if(dateActivityItem.getDatePart() != null) {
                    dateActivityItem.getDatePart().setDatePartId(rsSelect.getInt(1));
                    dateActivityItem.getDatePart().setDatePartValue(rsSelect.getLong(2));
                    dateActivityItem.setDateActivityId(rsSelect.getInt(3));
                    dateActivityItem.setDateActivityDescription(rsSelect.getString(4));
                    dateActivityItem.setDateActivityStatus(rsSelect.getString(5));
                }
            }

            rsSelect.close();
            selectPrepared.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dateActivityItem;
    }



    // *****************************

    /**
     *
     * @param dateActivityItem
     * @return boolean
     */
    @Override
    public boolean create(DateActivityItem dateActivityItem) {

        boolean response = false;

        // *** BONNE VERSION :
        String sql =  "INSERT INTO DATEPART (DATEPART_VALUE) VALUES(?); "+
                "INSERT INTO DATE_ACTIVITY (DATEPART_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS) "+
                "VALUES (LAST_INSERT_ID(), ?, ?)";
//            String sql = "INSERT INTO DATEPART (DATEPART_VALUE) VALUES(?); "+
//                    "INSERT INTO DATE_ACTIVITY (DATEPART_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS) "+
//                    "VALUES (LAST_INSERT_ID(), 'my activity description', '\"En Définition\"')";
        // *** en dur:
//        INSERT INTO DATEPART (DATEPART_VALUE) VALUES(1622412000000); INSERT INTO DATE_ACTIVITY (DATEPART_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS) VALUES (LAST_INSERT_ID(), 'my activity description', '\"En Définition\"')

        try (PreparedStatement insertSQL = connection.prepareStatement(sql)) {
            // l'enum par le num - ex: 'En définition' = 1 (de 1 à 4)
//            "INSERT INTO DATEPART (DATEPART_VALUE) VALUES(2021-06-19); INSERT INTO DATE_ACTIVITY (DATEPART_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS) VALUES (LAST_INSERT_ID(), 'my new activity description', 0);" // l'enum par le num - ex: 'En définition' = 1 (de 1 à 4)

            insertSQL.setLong(1, dateActivityItem.getDatePart().getDatePartValue());
            insertSQL.setString(2, dateActivityItem.getDateActivityDescription());
            insertSQL.setString(3, dateActivityItem.getDateActivityStatus());

//            if(employee.getHire_date() == null) {
//                insertSQL.setNull(6, java.sql.Types.DATE);
//            } else {
//                insertSQL.setDate(6, employee.getHire_date());
//            }

            int nbrCreate = insertSQL.executeUpdate();

            response = (nbrCreate > 0);
            insertSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
            response = false;
        }
        return response;
    }


    /**
     *
     * @param dateActivityItem
     * @return boolean
     */
    @Override
    public boolean delete(DateActivityItem dateActivityItem) {

//        System.out.println("######### "+ dateActivityItem.getDatePart().getDatePartId());

        boolean response;

        String sql = "DELETE FROM DATE_ACTIVITY WHERE DATEPART_ID = ?; "+
                "DELETE FROM DATEPART WHERE DATEPART_ID = ?;";

        try (PreparedStatement deleteSQL = connection.prepareStatement(sql)) {

            deleteSQL.setInt(1, dateActivityItem.getDatePart().getDatePartId());
            deleteSQL.setInt(2, dateActivityItem.getDatePart().getDatePartId());

            int nbrUpdate = deleteSQL.executeUpdate();

            response = (nbrUpdate > 0);
            deleteSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
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
        boolean response = false;

        String sql = "UPDATE DATEPART SET DATEPART_VALUE = ? WHERE DATEPART_ID = ?; "+
                "UPDATE DATE_ACTIVITY SET DATE_ACTIVITY_DESCRIPTION = ?, DATE_ACTIVITY_STATUS = ? "+
                "WHERE DATEPART_ID = ?; ";

        try (PreparedStatement updatePrepared = connection.prepareStatement(sql)) {

            // *** on 'set' tout sauf 'getEmployee_id()', logique... c'est un update:
            updatePrepared.setLong(1, dateActivityItem.getDatePart().getDatePartValue());
            updatePrepared.setInt(2, dateActivityItem.getDatePart().getDatePartId());
            updatePrepared.setString(3, dateActivityItem.getDateActivityDescription());
            updatePrepared.setString(4, dateActivityItem.getDateActivityStatus());
            updatePrepared.setInt(5, dateActivityItem.getDatePart().getDatePartId());

            int nbrUpdate = updatePrepared.executeUpdate();
            response = (nbrUpdate > 0);
            updatePrepared.close();

        } catch(SQLException e) {
            e.printStackTrace();
            response  = false;
        }
        return response;
    }


    /**
     * @param datePartId
     * @return DateActivityItem
     */
    @Override
    public DateActivityItem find(int datePartId) {  // datePartId passée ici... (= recherche sur la date)
//        System.out.println(datePartId);
        DatePart datePart = new DatePart();
        DateActivityItem dateActivityItem = new DateActivityItem();
        dateActivityItem.setDatePart(datePart);
//        System.out.println(dateActivityItem);
//        System.out.println("getDatePart : "+ dateActivityItem.getDatePart());


        String sql = "SELECT d.DATEPART_ID, d.DATEPART_VALUE, da.DATE_ACTIVITY_ID, da.DATE_ACTIVITY_DESCRIPTION, da.DATE_ACTIVITY_STATUS "+
                "FROM DATEPART d INNER JOIN DATE_ACTIVITY da "+
                "ON d.DATEPART_ID = da.DATEPART_ID "+
                "WHERE d.DATEPART_ID = ?;";
        try (PreparedStatement selectPrepared = connection.prepareStatement(sql)) {
            // REQUÊTE GÉNÉRALE:
//            SELECT d.DATEPART_ID, DATEPART_VALUE, DATE_ACTIVITY_ID, DATE_ACTIVITY_DESCRIPTION, DATE_ACTIVITY_STATUS FROM DATEPART d INNER JOIN DATE_ACTIVITY da ON d.DATEPART_ID = da.DATEPART_ID WHERE d.DATEPART_ID = 45;

//            String sql = "SELECT d.DATEPART_ID, d.DATEPART_VALUE, da.DATE_ACTIVITY_ID, da.DATE_ACTIVITY_DESCRIPTION, da.DATE_ACTIVITY_STATUS "+
//                    "FROM DATEPART d INNER JOIN DATE_ACTIVITY da "+
//                    "ON d.DATEPART_ID = da.DATEPART_ID "+
//                    "WHERE d.DATEPART_ID = ?;";

//            PreparedStatement selectPrepared = connection.prepareStatement(sql);

            selectPrepared.setInt(1, datePartId);
            ResultSet rsSelect = selectPrepared.executeQuery();

            while(rsSelect.next()) {
                System.out.println(dateActivityItem.getDatePart());
                if(dateActivityItem.getDatePart() != null) {
                    dateActivityItem.getDatePart().setDatePartId(rsSelect.getInt(1));
                    dateActivityItem.getDatePart().setDatePartValue(rsSelect.getLong(2));
                    dateActivityItem.setDateActivityId(rsSelect.getInt(3));
                    dateActivityItem.setDateActivityDescription(rsSelect.getString(4));
                    dateActivityItem.setDateActivityStatus(rsSelect.getString(5));
                }
            }

            rsSelect.close();
            selectPrepared.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dateActivityItem;
    }

}
