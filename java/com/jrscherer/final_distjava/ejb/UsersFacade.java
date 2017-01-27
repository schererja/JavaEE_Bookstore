package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User facade used to interact with a database and the table users
 * 
 * @author schereja
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;
/**
 * Used to override the getEntityManager
 * 
 * @return Returns the entityManager
 */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
/**
 * Constructor used to create a userFacade object
 * 
 * 
 */
    public UsersFacade() {
        super(Users.class);
    }
    
}
