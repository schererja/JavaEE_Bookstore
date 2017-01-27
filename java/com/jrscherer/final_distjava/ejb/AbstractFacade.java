package com.jrscherer.final_distjava.ejb;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * AbstractFacade, used as an abstract class for all facades. Allows for create,
 * edit, remove and find of objects.
 *
 * @author schereja
 */
public abstract class AbstractFacade<T> {

    /**
     * Class that will be used for the facade.
     *
     */
    private Class<T> entityClass;

    /**
     * Constructor to be used with the abstractFacade. This will allow other
     * Facades to be used
     *
     * @param entityClass Requires a class object
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Abstract method used to be overridden by other classes to return objects
     * entityManager
     *
     * @return Returns an EntityManager
     */
    protected abstract EntityManager getEntityManager();

    /**
     * Create method used to create an object and be sent to a database.
     *
     * @param entity Requires an object, specified in the extended class
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Edit method used to merge the data from one object to another
     *
     * @param entity Requires an object, specified in the extended class
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Remove method used to remove data from a database.
     *
     * @param entity Requires an object, specified in the extended class
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Finds an object of certain type by ID
     *
     * @param id - requires an object to find the object in the database
     * @return Returns an object of specified type
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Finds all objects in the database.
     *
     * @return Returns List of objects from the database
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Finds a range of objects by an int array
     *
     * @param range Requires an array of integers
     * @return Returns a list of objects from database that match the integer
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Count method to find out how many records are in database
     *
     * @return Returns an int of the number of records in database
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
