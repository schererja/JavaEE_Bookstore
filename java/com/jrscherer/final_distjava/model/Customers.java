/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jrscherer.final_distjava.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author schereja
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustomerId", query = "SELECT c FROM Customers c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customers.findByFirstName", query = "SELECT c FROM Customers c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customers.findByLastName", query = "SELECT c FROM Customers c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customers.findByCustomerEmail", query = "SELECT c FROM Customers c WHERE c.customerEmail = :customerEmail")})
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "customer_email")
    private String customerEmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Orders orders;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address addressId;
/**
 * Basic Constructor for a customers object
 * 
 */
    public Customers() {
    }
/**
 * Constructor with a needed customerId 
 * 
 * @param customerId Requires a Integer Value for the customer ID
 */
    public Customers(Integer customerId) {
        this.customerId = customerId;
    }
/**
 * Customers consturctor used to create a customer object with all needed values
 * 
 * @param customerId Requires an integer for the customer ID
 * @param firstName Requires a String for the first name
 * @param lastName Requires a string for the last name
 * @param customerEmail Requires a String for the customerEmail
 */
    public Customers(Integer customerId, String firstName, String lastName, String customerEmail) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
    }
/**
 * Getter for the customer ID
 * 
 * @return Returns an integer of the customerId
 */
    public Integer getCustomerId() {
        return customerId;
    }
/**
 * Setter for the customerID
 * 
 * @param customerId Requires a customerID as an integer
 */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
/**
 * Getter for the firstname
 * 
 * @return Returns a String of the first name
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Setter for the first Name
 * 
 * @param firstName Requires a string value for the firstname
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Getter for the last Name
 * @return Returns the last Name as a String
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Setter for the last name
 * 
 * @param lastName Requires a string value for the last name
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * Getter for customerEmail
 * 
 * @return Returns a String value of the customerEmail
 */
    public String getCustomerEmail() {
        return customerEmail;
    }
/**
 * Setter for the customer Email
 * 
 * @param customerEmail Requires a String for the customer Email
 */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
/**
 * Getter for the Orders
 * 
 * @return Returns an orders object
 */
    public Orders getOrders() {
        return orders;
    }
/**
 * Setter for the orders object
 * 
 * @param orders Requires an orders object
 */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }
/**
 * Getter for the address
 * 
 * @return Returns an address object
 */
    public Address getAddressId() {
        return addressId;
    }
/**
 * Setter for the address
 * 
 * @param addressId Requires an address object
 */
    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }
/**
 * Override of the hashcode function
 * 
 * @return Returns an int value of the hashcode
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }
/**
 * Over ride for the equals method
 * 
 * @param object Requires an object
 * @return Returns a boolean if equal or not.
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }
/**
 * Override of the to String
 * 
 * @return Returns a String of the method.
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.Customers[ customerId=" + customerId + " ]";
    }
    
}
