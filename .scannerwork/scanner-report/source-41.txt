package fr.cnam.pdatabase.managment.dao;

import java.util.*;

/**
 * 
 */
public interface DAOInterface<T> {

    /**
     * @param obj 
     * @return boolean
     */
    public boolean create(T obj);

    /**
     * @param obj 
     * @return boolean
     */
    public boolean update(T obj);

    /**
     * @param obj 
     * @return boolean
     */
    public boolean delete(T obj);

    /**
     * @param id 
     * @return boolean
     */
    public T find(int id);

}