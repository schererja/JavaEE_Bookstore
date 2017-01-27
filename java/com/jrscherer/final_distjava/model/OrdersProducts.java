/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jrscherer.final_distjava.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class to work with orders_products database table.
 * @author schereja
 */
@Entity

@Table(name = "orders_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersProducts.findAll", query = "SELECT o FROM OrdersProducts o"),
    @NamedQuery(name = "OrdersProducts.findByOrderId", query = "SELECT o FROM OrdersProducts o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrdersProducts.findByQty", query = "SELECT o FROM OrdersProducts o WHERE o.qty = :qty"),
})
public class OrdersProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Products productId;
    /**
     * Basic Constructor
     * 
     */
    public OrdersProducts() {
    }
/**
 * Constructor requiring the orderId
 * 
 * @param orderId Requires an Integer for the orderId
 */
    public OrdersProducts(Integer orderId) {
        this.orderId = orderId;
    }
/**
 * Constructor requiring orderId and qty
 * 
 * @param orderId Requires an integer value for the orderId
 * @param qty Requires an int for the qty
 */
    public OrdersProducts(Integer orderId, int qty) {
        this.orderId = orderId;
        this.qty = qty;
    }
/**
 * Getter for orderId
 * 
 * @return Returns an integer for the orderid
 */

    public Integer getOrderId() {
        return orderId;
    }
/**
 * Setter for the orderid
 * 
 * @param orderId Requires an integer for the orderId
 */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
/**
 * Getter for the Qty
 * 
 * @return Returns the Qty as an int
 */
    public int getQty() {
        return qty;
    }
/**
 * Setter for the qty
 * 
 * @param qty Requires an int value for the qty
 */
    public void setQty(int qty) {
        this.qty = qty;
    }
/**
 * Getter for the orders
 * 
 * @return Returns an orders object
 */
    public Orders getOrders() {
        return orders;
    }
/**
 * Setter for the orders
 * 
 * @param orders Requires an orders object
 */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
/**
 * Getter for the productID
 * 
 * @return Returns a Products object
 */
    public Products getProductId() {
        return productId;
    }
/**
 * Setter for the productId
 * 
 * @param productId Requires a Products object
 */
    public void setProductId(Products productId) {
        this.productId = productId;
    }


/**
 * Override of the hashcode function
 * 
 * @return Returns an int value of the hashcode
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }
/**
 * Override of the equals method
 * 
 * @param object Requires an Object
 * @return Returns a boolean if the object is equal
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersProducts)) {
            return false;
        }
        OrdersProducts other = (OrdersProducts) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }
/**
 * Override of the to string method
 * 
 * @return Returns a String value
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.OrdersProducts[ orderId=" + orderId + " ]";
    }
    
}
