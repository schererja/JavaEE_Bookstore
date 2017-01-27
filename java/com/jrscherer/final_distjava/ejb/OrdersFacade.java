package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * OrdersFacade used to interact with the Orders table in the database. Extends
 * from AbstractFacade
 *
 * @author schereja
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> {

    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private String queryOrderParameter = "orderId";
    private String namedQuery = "Orders.findByOrderId";
    /**
     * Override of the get entity manager method
     *
     * @return Returns the entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Constructor used for ordersFacade
     *
     */
    public OrdersFacade() {
        super(Orders.class);
    }

    /**
     * Method used to find order by order Id
     *
     * @param orderId Requires an integer value to find the order by orderId
     * @return Returns List of Orders
     */
    public List<Orders> findOrderByOrderID(Integer orderId) {
        TypedQuery<Orders> queryOrderById = getEntityManager().createNamedQuery(namedQuery, Orders.class);
        queryOrderById.setParameter(queryOrderParameter, orderId);
        List<Orders> order = queryOrderById.getResultList();
        return order;
    }
}
