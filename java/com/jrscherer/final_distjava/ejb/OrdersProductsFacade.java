package com.jrscherer.final_distjava.ejb;

import com.jrscherer.final_distjava.model.OrdersProducts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Java class used to interact with the database for OrderProducts. Extends
 * AbstractFacade
 *
 * @author schereja
 */
@Stateless
public class OrdersProductsFacade extends AbstractFacade<OrdersProducts> {

    @PersistenceContext(unitName = "com.jrscherer_final_distjava_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    /**
     * Override of the Entity Manager get method from Abstract Facade
     *
     * @return Returns the entityManager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Constructor used to create OrderProducts objects
     *
     */
    public OrdersProductsFacade() {
        super(OrdersProducts.class);
    }

    /**
     * Method used to find orderProducts by the OrderId.
     *
     * @param id Requires an integer value for the orderId
     * @return Returns a list of OrderProducts
     */
    public List<OrdersProducts> findOrderProductsByOrderId(Integer id) {
        String sqlStatement = "SELECT order_id, product_id FROM bookstore_final.orders_products where orders_products.order_id ='" + id + "'";
        Query queryOrderProductsByOrderId = getEntityManager().createNativeQuery(sqlStatement, OrdersProducts.class);
        
        List<Object[]> temp = queryOrderProductsByOrderId.getResultList();
        List<OrdersProducts> tempOrderProd = new ArrayList<>();
        
        Iterator itr = temp.iterator();
        
        while(itr.hasNext()){
            OrdersProducts obj = (OrdersProducts)itr.next();
            tempOrderProd.add(obj);
        }
       
        return tempOrderProd;
    }
    
}
