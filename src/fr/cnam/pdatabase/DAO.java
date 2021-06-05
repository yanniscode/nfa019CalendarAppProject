package fr.cnam.pdatabase;

import java.util.*;

/**
 * @author Yannis Guéguen
 */
public abstract class DAO<T> implements DaoInterface<T> {

    /**
     * Default constructor
     */
    public DAO() {
    }

    /**
     * 
     */
    private MysqlConnexion mysqlConnexion = null;

//    /**
//     * @param obj
//     * @return
//     */
//    public abstract boolean create(T obj);
//
//    /**
//     * @param obj
//     * @return
//     */
//    public abstract boolean update(T obj);
//
//    /**
//     * @param obj
//     * @return
//     */
//    public abstract boolean delete(T obj);
//
//    /**
//     * @param id
//     * @return
//     */
//    public abstract T find(int id);

    /**
     * @param obj 
     * @return
     */
    public boolean create(T obj) {
        // TODO implement here
        return false;
    }

    /**
     * @param obj 
     * @return
     */
    public boolean update(T obj) {
        // TODO implement here
        return false;
    }

    /**
     * @param obj 
     * @return
     */
    public boolean delete(T obj) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public T find(int id) {
        // TODO implement here
        return null;
    }

}