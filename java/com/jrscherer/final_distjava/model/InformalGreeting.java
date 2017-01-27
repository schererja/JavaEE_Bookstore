/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jrscherer.final_distjava.model;

import java.io.Serializable;

/**
 * Class for the informal greeting
 * @author schereja
 */
@Informal
public class InformalGreeting implements Greeting, Serializable{
/**
 * Override of the getGreeting method
 * 
 * @param customer Requires a customers object
 * @return Returns a String of the greeting
 */
    @Override
    public String getGreeting(Customers customer) {
        return "Welcome to JRS Bookstore: " + customer.getFirstName() + " " + customer.getLastName();
    }
    
}
