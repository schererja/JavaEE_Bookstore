package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.CustomersFacade;
import com.jrscherer.final_distjava.model.Customers;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Customers Controller Used for an interaction between jpa and jsf
 *
 * @author schereja
 */

@Named("customersController")
@SessionScoped
public class CustomersController implements Serializable {

    private List<Customers> customers;
    private Customers customer;
    private String firstName;
    private String lastName;
    private String customerEmail;
    @Inject
    private CustomersFacade customerEao;

    /**
     * Constructor for the customercontroller to create an instance
     *
     */
    public CustomersController() {
    }

    /**
     * Loads all the customers with the Eao. Also used as a PostConstruct to
     * load customers as soon as being used
     *
     */
    @PostConstruct
    public void loadCustomers() {
        customers = getCustomerEao().findAll();
    }

    /**
     * Used to add a new customer. Uses the First name, Last Name, and customer
     * Email to create the customer account
     *
     */
    public void addCustomer() {
        customer = new Customers(null, firstName, lastName, customerEmail);
        getCustomerEao().create(customer);

    }

    /**
     * Getter for the first name
     *
     * @return Returns a String of the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the first name
     *
     * @param firstName Requires a String for the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the last name
     *
     * @return Returns a String of the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the last name
     *
     * @param lastName Requires a String value for the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the customerEmail
     *
     * @return Returns the string value of the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Setter for the customer Email
     *
     * @param customerEmail Requires a String value for the customeremail
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Getter for the list<Customers>
     *
     * @return Returns a list of customers
     */
    public List<Customers> getCustomers() {
        return customers;
    }

    /**
     * Setter for the customers
     *
     * @param customers Requires a list<customers>
     */
    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    /**
     * Getter for the customer
     *
     * @return Returns the Customer
     */
    public Customers getCustomer() {
        return customer;
    }

    /**
     * Setter for the customer
     *
     * @param customer Requires a Customers object
     */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    /**
     * \
     * Getter for the customerFacade
     *
     * @return Returns the customersFacade
     */
    public CustomersFacade getCustomerEao() {
        return customerEao;
    }

    /**
     * Setter for the customersEao
     *
     * @param customerEao Requires a customerFacade
     */
    public void setCustomerEao(CustomersFacade customerEao) {
        this.customerEao = customerEao;
    }

}
