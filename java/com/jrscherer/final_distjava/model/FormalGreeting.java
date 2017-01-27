/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jrscherer.final_distjava.model;

import java.io.Serializable;

/**
 * Formal Greeting used by the interface Greeting 
 * @author schereja
 */
@Formal
public class FormalGreeting implements Greeting, Serializable{
/**
 * Override for the getGreeting
 * 
 * @param customer Requires a customer object
 * @return Returns a String
 */
    @Override
    public String getGreeting(Customers customer) {
        return "Welcome Mr/Mrs. " + customer.getFirstName() + " " +customer.getLastName() + ". Enjoy your stay.";
    }
    
}
