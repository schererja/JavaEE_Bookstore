package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Used to interface with the table Products in the database
 *
 * @author schereja
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> {

    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private String queryUsed = "Products.findByProductId";
    private String parameter = "productId";
    /**
     * Override of the getEntityManager
     *
     * @return Returns the entityManager object
     *
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Basic constructor used to create productsFacade object
     *
     */
    public ProductsFacade() {
        super(Products.class);
    }

    /**
     * Method used to find the product by order ID
     *
     * NOTE:Only returns one
     *
     * @param id Requires an Integer value for the productID
     * @return Returns a list of products
     */
    public List<Products> findProductsById(Integer id) {
        TypedQuery<Products> queryProductsByProductId = getEntityManager().createNamedQuery(queryUsed, Products.class);
        queryProductsByProductId.setParameter(parameter, id);

        return queryProductsByProductId.getResultList();
    }
/**
 * Getter for query used
 * 
 * @return Returns a String of the query used
 */
    public String getQueryUsed() {
        return queryUsed;
    }
/**
 * Setter for queryUsed
 * 
 * @param queryUsed Requires a String for the query used
 */
    public void setQueryUsed(String queryUsed) {
        this.queryUsed = queryUsed;
    }
    
}
