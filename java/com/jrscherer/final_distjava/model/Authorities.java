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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Entity Authorities to communicate with database
 * @author schereja
 */
@Entity
@Table(name = "authorities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authorities.findAll", query = "SELECT a FROM Authorities a"),
    @NamedQuery(name = "Authorities.findByAuthority", query = "SELECT a FROM Authorities a WHERE a.authority = :authority"),
    @NamedQuery(name = "Authorities.findByAuthoritiesId", query = "SELECT a FROM Authorities a WHERE a.authoritiesId = :authoritiesId")})
public class Authorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "authority")
    private String authority;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authorities_id")
    private Integer authoritiesId;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users username;
/**
 * Basic Constructor
 * 
 */
    public Authorities() {
    }
/**
 * Constructor that creates an object with the authoritiesID as set
 * 
 * @param authoritiesId Requires an Integer Value for the authorities ID
 */
    public Authorities(Integer authoritiesId) {
        this.authoritiesId = authoritiesId;
    }
/**
 * Constructor with authoritiesID and authority that need to be passed
 * 
 * @param authoritiesId Requires a Int of the ID
 * @param authority Requires a String value
 */
    public Authorities(Integer authoritiesId, String authority) {
        this.authoritiesId = authoritiesId;
        this.authority = authority;
    }
/**
 * Getter for authority
 * 
 * @return Returns a String value of the authority
 */
    public String getAuthority() {
        return authority;
    }
/**
 * Setter for authority
 * @param authority  Requires a String value
 */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
/**
 * Getter for authoritiesId
 * 
 * @return Returns a String value of the
 */
    public Integer getAuthoritiesId() {
        return authoritiesId;
    }
/**
 * Setter for authoritiesId
 * 
 * @param authoritiesId  Requires an Integer
 */
    public void setAuthoritiesId(Integer authoritiesId) {
        this.authoritiesId = authoritiesId;
    }
/**
 * Getter for username
 * 
 * @return Returns a User object of the username
 */
    public Users getUsername() {
        return username;
    }

    /**
     * Setter for username
     * @param username Requires a Users Object
     */
    public void setUsername(Users username) {
        this.username = username;
    }
/**
 *  Basic hashcode override
 * 
 * @return Returns hash as an Int
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authoritiesId != null ? authoritiesId.hashCode() : 0);
        return hash;
    }
/**
 * Equals method override
 * 
 * @param object Requires an object
 * @return Returns a boolean
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.authoritiesId == null && other.authoritiesId != null) || (this.authoritiesId != null && !this.authoritiesId.equals(other.authoritiesId))) {
            return false;
        }
        return true;
    }
/**
 * Basic toString override
 * 
 * @return Returns the String of the object
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.Authorities[ authoritiesId=" + authoritiesId + " ]";
    }
    
}
