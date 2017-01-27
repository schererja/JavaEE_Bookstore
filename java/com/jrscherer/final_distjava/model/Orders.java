/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jrscherer.final_distjava.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Orders class for finding orders and creating orders objects
 * @author schereja
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orders.findByDateOrdered", query = "SELECT o FROM Orders o WHERE o.dateOrdered = :dateOrdered"),
    @NamedQuery(name = "Orders.findByCustomerId", query = "SELECT o FROM Orders o WHERE o.customerId = :customerId")})
    
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_ordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrdered;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
    private OrdersProducts ordersProducts;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @OneToOne(optional = false)
    private Customers customerId;
/**
 * Basic Constructor
 * 
 */
    public Orders() {
    }
/**
 * Constructor with a requirement of an order id
 * 
 * @param orderId Requires an Interger value 
 */
    public Orders(Integer orderId) {
        this.orderId = orderId;
    }
/**
 * Constructor that requires an order ID and a Date
 * 
 * @param orderId Requires an Integer for the orderId
 * @param dateOrdered Requires a Date for the dateOrdered
 */
    public Orders(Integer orderId, Date dateOrdered) {
        this.orderId = orderId;
        this.dateOrdered = dateOrdered;
    }
/**
 * Getter for orderID
 * 
 * @return Returns an Int for the orderID
 */
    public Integer getOrderId() {
        return orderId;
    }
/**
 * Setter for the orderID
 * 
 * @param orderId Requires an interger for the orderId
 */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
/**
 * Getter for the dateOrdered
 * 
 * @return Returns a Date object of the dateOrdered
 */
    public Date getDateOrdered() {
        return dateOrdered;
    }
/**
 * Setter for the dateOrdered
 * 
 * @param dateOrdered Requires a Date for the dateOrdered
 */
    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
/**
 * Getter for the ordersProducts
 * 
 * @return Returns an ordersProduct
 */
    public OrdersProducts getOrdersProducts() {
        return ordersProducts;
    }
/**
 * Setter for the ordersProducts
 * 
 * @param ordersProducts Requires an ordersProducts
 */
    public void setOrdersProducts(OrdersProducts ordersProducts) {
        this.ordersProducts = ordersProducts;
    }
/**
 * Getter for the customerId
 * 
 * @return Returns a Customers object
 */
    public Customers getCustomerId() {
        return customerId;
    }
/**
 * Setter for the customerId
 * 
 * @param customerId Requires a customer object
 */
    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }
/**
 * Hashcode override
 * 
 * @return Returns an Int value for the hashcode
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }
/**
 * Finds if object is equal.  Override method
 * 
 * @param object Requires an Object
 * @return Returns a boolean if equal
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }
/**
 * Override of the to string method 
 * 
 * @return Returns a String Value
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.Orders[ orderId=" + orderId + " ]";
    }
    
}
