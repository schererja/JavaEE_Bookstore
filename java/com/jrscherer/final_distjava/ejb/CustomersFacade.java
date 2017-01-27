package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.Customers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * CustomersFacade that extends AbstractFacade. This also has a
 * findCustomerByUserName Method
 *
 * @author schereja
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {

    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private String namedQuery = "Customers.findByCustomerEmail";
    private String parameter = "customerEmail";
    /**
     * Override of the getEntityManager method.
     *
     * @return Returns entity manager for this facade
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Basic constructor for the customers facade
     *
     */
    public CustomersFacade() {
        super(Customers.class);
    }

    /**
     * Custom Method that uses a named query to find the customer based on the
     * username
     *
     * @param userName Requires a String value for the username
     * @return Returns a list of Customers based on the username imported
     */
    public List<Customers> findCustomerByUserName(String userName) {
        TypedQuery<Customers> queryCustomerByUserName = getEntityManager().createNamedQuery(namedQuery, Customers.class);
        queryCustomerByUserName.setParameter(parameter, userName);
        List<Customers> customer = queryCustomerByUserName.getResultList();
        return customer;
    }
}
