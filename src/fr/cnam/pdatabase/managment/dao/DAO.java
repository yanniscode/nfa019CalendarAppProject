package fr.cnam.pdatabase.managment.dao;


/**
 * @author Yannis Guéguen
 */
public interface DAO<T> extends DAOInterface<T> {

    /**
     * @param obj
     * @return boolean
     */
    boolean create(T obj);

    /**
     * @param obj
     * @return boolean
     */
    boolean update(T obj);

    /**
     * @param obj
     * @return boolean
     */
    boolean delete(T obj);

    /**
     * @param id
     * @return boolean
     */
    T find(int id);

}