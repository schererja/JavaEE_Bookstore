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
 *  Address entity to be used to interact with database
 * 
 * @author schereja
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "Address.findByLine1", query = "SELECT a FROM Address a WHERE a.line1 = :line1"),
    @NamedQuery(name = "Address.findByLine2", query = "SELECT a FROM Address a WHERE a.line2 = :line2"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = :state"),
    @NamedQuery(name = "Address.findByZipCode", query = "SELECT a FROM Address a WHERE a.zipCode = :zipCode")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "address_id")
    private Integer addressId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "line_1")
    private String line1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "line_2")
    private String line2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zip_code")
    private int zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Customers> customersCollection;
/**
 * Basic Constructor 
 * 
 */
    public Address() {
    }
/**
 * Constructor used with Address ID
 * 
 * @param addressId Requires an integer value for the addressId
 */
    public Address(Integer addressId) {
        this.addressId = addressId;
    }
/**
 * Constructor to be used to create an Address object 
 * 
 * @param addressId Requires an Integer value for the address ID
 * @param line1 Requires a String value for line 1 of the address
 * @param line2 Requires a String value for line 2 of the address
 * @param city Requires a String value for the city
 * @param state Requires a String value for the state
 * @param zipCode Requires an int value for the zipcode
 */
    public Address(Integer addressId, String line1, String line2, String city, String state, int zipCode) {
        this.addressId = addressId;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
/**
 * Getter for the address ID
 * 
 * @return Returns an Integer Value 
 */
    public Integer getAddressId() {
        return addressId;
    }
/**
 * Setter for the address ID
 * 
 * @param addressId Requires an integer for the address ID
 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
/**
 * Getter for line 1
 * 
 * @return Returns a String value for Line 1
 */
    public String getLine1() {
        return line1;
    }
/**
 * Setter for line 1 of the address
 * @param line1  Requires a String value for line 1
 */
    public void setLine1(String line1) {
        this.line1 = line1;
    }
/**
 * Getter for line 2 of the address
 * 
 * @return A String value of line 2
 */
    public String getLine2() {
        return line2;
    }
/**
 * Setter for Line 2 of the address
 * 
 * @param line2 Requires a String value
 */
    public void setLine2(String line2) {
        this.line2 = line2;
    }
/**
 * Getter for city
 * 
 * @return Returns city as a String
 */
    public String getCity() {
        return city;
    }
/**
 * Setter for city
 * 
 * @param city Requires a String value for city
 * 
 */
    public void setCity(String city) {
        this.city = city;
    }
/**
 * Getter for state
 * 
 * @return Returns a string of the state
 */
    public String getState() {
        return state;
    }
/**
 * Setter for the state
 * 
 * @param state Requires a String value for the state
 */
    public void setState(String state) {
        this.state = state;
    }
/**
 * Getter for the zipcode
 * 
 * @return Returns an int value for the zipcode
 */
    public int getZipCode() {
        return zipCode;
    }
/**
 * Setter for the zip code
 * 
 * @param zipCode Requires an Int value for the zipcode
 */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
/**
 * Getter for the customerscollection
 * @return Returns a collection of customers
 */
    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }
/**
 * Setter for the customersCollection
 * @param customersCollection Requires a Collection of customers
 */
    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }
/**
 * Override of the hashcode
 * 
 * @return Returns an Int value for the hashcode
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }
/**
 * Equals method for address ID
 * 
 * @param object Requires an object
 * @return Returns a boolean
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }
/**
 * toString Override
 * 
 * @return Returns a string 
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.Address[ addressId=" + addressId + " ]";
    }
    
}
