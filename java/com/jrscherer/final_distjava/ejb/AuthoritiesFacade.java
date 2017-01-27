package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.Authorities;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * AuthoritiesFacade class made to extend the AbstractFacade
 *
 * @author schereja
 */
@Stateless
public class AuthoritiesFacade extends AbstractFacade<Authorities> {

    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    /**
     * Override of the getEntityManager to return the entityManager of the
     * facade
     *
     * @return Returns the entity manager for this facade
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Constructor for Authorities Facade
     *
     */
    public AuthoritiesFacade() {
        super(Authorities.class);
    }

}
