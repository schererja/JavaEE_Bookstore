package com.jrscherer.final_distjava.jsf;


import com.jrscherer.final_distjava.ejb.OrdersFacade;
import com.jrscherer.final_distjava.model.Orders;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Orders controller to use with jsf and jpa
 * 
 * @author schereja
 */
@Named("ordersController")
@SessionScoped
public class OrdersController implements Serializable {
    private List<Orders> orders;
    private Orders order;
    
    @Inject
    private OrdersFacade ordersEao;
/**
 * Basic constructor
 * 
 */
    public OrdersController() {
    }
    /**
     * Loads all the orders into orders list
     * 
     */
    @PostConstruct
    public void loadOrders(){
        orders = getOrdersEao().findAll();
        
    }
/**
 * Getter for orders
 * 
 * @return Returns a List<Orders>
 */
    public List<Orders> getOrders() {
        return orders;
    }
/**
 * Setter for orders
 * 
 * @param orders Requires a List<Orders>
 */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
/**
 * Getter for orders
 * 
 * @return Returns an Orders object
 */
    public Orders getOrder() {
        return order;
    }
    /**
     * Setter for order
     * 
     * @param order Requires an Orders object
     */
    public void setOrder(Orders order) {
        this.order = order;
    }
/**
 * Getter for ordersEao
 * 
 * @return Returns an OrdersFacade object
 */
    public OrdersFacade getOrdersEao() {
        return ordersEao;
    }
/**
 * Setter for ordersEao
 * 
 * @param ordersEao Requires an OrdersFacade object
 */
    public void setOrdersEao(OrdersFacade ordersEao) {
        this.ordersEao = ordersEao;
    }

}
