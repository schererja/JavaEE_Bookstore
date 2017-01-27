package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.OrdersFacade;
import com.jrscherer.final_distjava.ejb.OrdersProductsFacade;
import com.jrscherer.final_distjava.ejb.ProductsFacade;
import com.jrscherer.final_distjava.model.Orders;
import com.jrscherer.final_distjava.model.OrdersProducts;
import com.jrscherer.final_distjava.model.Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *  Used for getting the info from an order
 * @author schereja
 */
@Named(value = "ordInfoService")
@SessionScoped
public class OrdInfoService implements Serializable{
    private String parameter = "id";
    private Orders order;
    private List<OrdersProducts> lineItems;
    private List<Products> productsOrdered;
    private int id;
    @Inject
    private OrdersFacade ordersEao;
    @Inject
    private ProductsFacade productsEao;
    @Inject
    private OrdersProductsFacade opEao;
     /**
      * Basic Constructor 
      * 
      */
    public OrdInfoService() {
    }
    /**
     * Gets info about order and sends to a new page
     * 
     * @return Returns a string which moves to the orderinfo page
     */
    public String viewOrder(){
        String orderPassed = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parameter);
        id =Integer.parseInt(orderPassed);
        order = (getOrdersEao().findOrderByOrderID(id)).get(0);
                
        lineItems = getOpEao().findOrderProductsByOrderId(id);
        productsOrdered = new ArrayList<>();
        
        for (OrdersProducts lT  : lineItems) {
            productsOrdered.add(lT.getProductId());
                    }
        
         return "orderInfo";
   
    }

/**
 * Getter for order
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
 * @return Returns OrdersFacade
 */
    public OrdersFacade getOrdersEao() {
        return ordersEao;
    }
/**
 * Setter for OrdersEao
 * 
 * @param ordersEao Requires an OrdersFacade object
 */
    public void setOrdersEao(OrdersFacade ordersEao) {
        this.ordersEao = ordersEao;
    }
/**
 * Getter for productsEao
 * 
 * @return Returns ProductsFacade
 */
    public ProductsFacade getProductsEao() {
        return productsEao;
    }
/**
 * Setter for productsEao
 * 
 * @param productsEao Requires a ProductsFacade object
 */
    public void setProductsEao(ProductsFacade productsEao) {
        this.productsEao = productsEao;
    }
/**
 * Getter for opEao
 * 
 * @return Returns OrdersProductsFacade
 */
    public OrdersProductsFacade getOpEao() {
        return opEao;
    }
/**
 * Setter for OpEao
 * 
 * @param opEao Requires an OrdersProductsFacade
 */
    public void setOpEao(OrdersProductsFacade opEao) {
        this.opEao = opEao;
    }
/**
 * Getter for Parameter
 * 
 * @return Returns a String
 */
    public String getParameter() {
        return parameter;
    }
/**
 * Setter for parameter
 * 
 * @param parameter Requires a String
 */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
/**
 * Getter for LineItems
 * 
 * @return Returns a List<OrdersProducts>
 */
    public List<OrdersProducts> getLineItems() {
        return lineItems;
    }
/**
 * Setter for lineItems
 * 
 * @param lineItems Requires a List<OrdersProducts>
 */
    public void setLineItems(List<OrdersProducts> lineItems) {
        this.lineItems = lineItems;
    }
/**
 * Getter for ProductsOrdered
 * 
 * @return Returns a List<Products>
 */
    public List<Products> getProductsOrdered() {
        return productsOrdered;
    }
/**
 * Setter for productsOrdered
 * 
 * @param productsOrdered Requires a List<Products>
 */
    public void setProductsOrdered(List<Products> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }
/**
 * Getter for Id
 * 
 * @return Returns an Int of the Id
 */
   

    public int getId() {
        return id;
    }
/**
 * Setter for id
 * 
 * @param id Requires an Int
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * To string method override
 * 
 * @return Returns a String of all fields
 */
    @Override
    public String toString() {
        return "OrdInfoService{" + "parameter=" + parameter + ", order=" + order + ", ordersEao=" + ordersEao + ", productsEao=" + productsEao + ", opEao=" + opEao + '}';
    }
/**
 * Override of hashcode method
 * 
 * @return Returns an int
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.parameter);
        return hash;
    }
/**
 * Override of equals
 * 
 * @param obj Requires an object
 * @return Return true or false boolean
 */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdInfoService other = (OrdInfoService) obj;
        if (!Objects.equals(this.parameter, other.parameter)) {
            return false;
        }
        return true;
    }
    
}
