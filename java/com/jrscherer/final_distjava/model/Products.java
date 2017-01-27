/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jrscherer.final_distjava.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *  Used to create products objects
 * @author schereja
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductDesc", query = "SELECT p FROM Products p WHERE p.productDesc = :productDesc"),
    @NamedQuery(name = "Products.findByProductPrice", query = "SELECT p FROM Products p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "Products.findByQtyInStock", query = "SELECT p FROM Products p WHERE p.qtyInStock = :qtyInStock")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "product_desc")
    private String productDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_price")
    private float productPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyInStock")
    private int qtyInStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<OrdersProducts> ordersProductsCollection;
/**
 * Basic Constructor for a products Object
 * 
 */
    public Products() {
    }
/**
 * Makes a products object with an integer value for the productID
 * 
 * @param productId Requires an Integer for the productID
 */
    public Products(Integer productId) {
        this.productId = productId;
    }
/**
 * Creates a products object based on the inputs
 * 
 * @param productId Requires an integer Value for the product Id
 * @param productName Requires a String value for the productName
 * @param productDesc Requires a String value for the productDesc
 * @param productPrice Requires a float for the product price
 * @param qtyInStock Requires an int value for the qty in stock
 */
    public Products(Integer productId, String productName, String productDesc, float productPrice, int qtyInStock) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.qtyInStock = qtyInStock;
    }
/**
 * Getter for the productId
 * 
 * @return Returns an integer for the productId
 */
    public Integer getProductId() {
        return productId;
    }
/**
 * Setter for the productId
 * 
 * @param productId Requires an Integer for the productId
 */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
/**
 * Getter for the product Name
 * 
 * @return Returns a String value of the productName
 */
    public String getProductName() {
        return productName;
    }
/**
 * Setter for the product Name
 * 
 * @param productName Requires a String value for the product name
 */
    public void setProductName(String productName) {
        this.productName = productName;
    }
/**
 * Getter for the product Description
 * 
 * @return Returns a string value for the description
 */
    public String getProductDesc() {
        return productDesc;
    }
/**
 * Setter for the product Description
 * 
 * @param productDesc Requires a String value for the desc
 */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
/**
 * Getter for the product price
 * 
 * @return Returns a float value for the product price
 */
    public float getProductPrice() {
        return productPrice;
    }
/**
 * Setter for the product price
 * @param productPrice Requires a float for the product
 */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
/**
 * Getter for the qty in stock
 * 
 * @return Returns an int for the qty in stock
 */
    public int getQtyInStock() {
        return qtyInStock;
    }
/**
 * Setter for the qty in stock
 * 
 * @param qtyInStock Requires an int for the qty in stock
 */
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
/**
 * Getter for the collection of orderProducts
 * 
 * @return Returns a collection of orderProducts
 */
    @XmlTransient
    public Collection<OrdersProducts> getOrdersProductsCollection() {
        return ordersProductsCollection;
    }
/**
 * Setter for ordersProducts 
 * 
 * @param ordersProductsCollection Requires a collection of order Products
 */
    public void setOrdersProductsCollection(Collection<OrdersProducts> ordersProductsCollection) {
        this.ordersProductsCollection = ordersProductsCollection;
    }
/**
 * Override of the hashcode
 * 
 * @return Returns an int value for the hashcode
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }
/**
 * override of the equals method
 * 
 * @param object Requires an object
 * @return Returns a boolean if equal
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }
/**
 * override of the toString
 * 
 * @return Returns a String of the object.
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.Products[ productId=" + productId + " ]";
    }
    
}
