package fr.cnam.pdatabase;

import java.util.*;

/**
 * 
 */
public interface DaoInterface<T> {

    /**
     * @param obj 
     * @return
     */
    public boolean create(T obj);

    /**
     * @param obj 
     * @return
     */
    public boolean update(T obj);

    /**
     * @param obj 
     * @return
     */
    public boolean delete(T obj);

    /**
     * @param id 
     * @return
     */
    public T find(int id);

}