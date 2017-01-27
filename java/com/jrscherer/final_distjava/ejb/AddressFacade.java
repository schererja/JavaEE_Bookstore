package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Address Facade that extends the AbstractFacade. Has all the methods from
 * AbstractFacade
 *
 * @author schereja
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {

    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    /**
     * Override method for the getEntityManager to Facades entity manager
     *
     * @return EntityManager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Constructor for the AddressFacade.
     *
     */
    public AddressFacade() {
        super(Address.class);
    }

}
