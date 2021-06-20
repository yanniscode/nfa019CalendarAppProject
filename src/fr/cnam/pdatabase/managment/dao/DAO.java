package fr.cnam.pdatabase.managment.dao;

import java.sql.Connection;

/**
 * @author Yannis Guéguen
 */
public abstract class DAO<T> implements DAOInterface<T> {


    /**
     * Constructeur 2
     * @param connection
     */
    public DAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Default constructor
     */
    public DAO() {
    }

    /**
     * Connection
     */
    private Connection connection = null;

    /**
     * MysqlConnexion
     */
//    private MysqlConnexion mysqlConnexion = null;

    /**
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * @param id
     * @return boolean
     */
    public abstract T find(int id);

}