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
 * Users entity class
 * 
 * @author schereja
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = :enabled")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Authorities> authoritiesCollection;
/**
 * Basic constructor to create a Users object
 * 
 */
    public Users() {
    }
/**
 * Basic constructor to create a Users object requiring a String for username
 * @param username Requires a String for the username
 */
    public Users(String username) {
        this.username = username;
    }
/**
 * Getter for the username
 * 
 * @return Returns a String value
 */
    public String getUsername() {
        return username;
    }
/**
 * Setter for the userName
 * 
 * @param username Requires a username String
 */
    public void setUsername(String username) {
        this.username = username;
    }
/**
 * Getter for the password
 * 
 * @return Returns the password
 */
    public String getPassword() {
        return password;
    }
/**
 * Setter for the password
 * 
 * @param password Requires a String for the password
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Getter for the enabled boolean 
 * 
 * @return Returns a boolean of enabled
 */
    public Boolean getEnabled() {
        return enabled;
    }
/**
 * Setter for enabled
 * 
 * @param enabled Requires a boolean value for if it's enabled or not
 */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
/**
 * Getter for the collection of Authorities
 * 
 * @return Returns the collection of authorities
 */
    @XmlTransient
    public Collection<Authorities> getAuthoritiesCollection() {
        return authoritiesCollection;
    }
/**
 * Setter for the authorities collection 
 * 
 * @param authoritiesCollection Requires a collection of authorities
 */
    public void setAuthoritiesCollection(Collection<Authorities> authoritiesCollection) {
        this.authoritiesCollection = authoritiesCollection;
    }
/**
 * Hashcode override method
 * 
 * @return Returns an int value of the hashcode
 */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }
/**
 * Equals override method
 * 
 * @param object Requires an object 
 * @return Returns a boolean if equal
 */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }
/**
 * Override of the toString
 * 
 * @return Returns a String value
 */
    @Override
    public String toString() {
        return "com.jrscherer.final_distjava.model.Users[ username=" + username + " ]";
    }
    
}
