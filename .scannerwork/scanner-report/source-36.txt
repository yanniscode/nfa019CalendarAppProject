package fr.cnam.pdatabase;


/**
 * 
 */
public interface DaoInterface<T> {

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