package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.AddressFacade;
import com.jrscherer.final_distjava.ejb.CustomersFacade;
import com.jrscherer.final_distjava.model.Address;
import com.jrscherer.final_distjava.model.Customers;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 * Class used to interact with both Customer and Address tables in the database
 * 
 * @author schereja
 */
@Named(value = "customerAddressDto")
@SessionScoped
public class CustomerAddressDto implements Serializable {

    private List<Customers> customers;
    private List<Address> addresses;
    private Customers customer;
    private Address address;
    @Inject
    private CustomersFacade customerEao;
    @Inject
    private AddressFacade addressEao;
    private String onEditMsg = "Customer Edited: ";
     private String onCancelMsg = "Customer Edit Cancelled ";
/**
 * Basic Constructor to create customerAddressDto objects
 * 
 */
    public CustomerAddressDto() {
    }
/**
 * Loads all the customers, used as a PostConstruct
 * 
 */
    @PostConstruct
    public void loadCustomers() {
        customers = getCustomerEao().findAll();

    }
/**
 * OnEdit method which takes the click from the primefaces datable and edits the row
 * 
 * @param event Requires a roweditevent object
 */
    public void onEdit(RowEditEvent event) {
        getCustomerEao().edit(customer);
        getAddressEao().edit(address);
        FacesMessage msg = new FacesMessage(this.onEditMsg, ((Customers) event.getObject()).getCustomerId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
/**
 * OnCancel method which is used when the primefaces cancel button is hit
 * 
 * @param event Requires a RowEditEvent object
 */
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(onCancelMsg, ((Customers) event.getObject()).getCustomerId().toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
////  Was going to add in until thought about how a real store would not want to delete a customer if it has orders.
////  Also was unable to get fully working
//    public void deleteCustomer(Customers customer){
//        address = customerAddress(customer.getCustomerId());
//        getAddressEao().remove(address);
//        getCustomerEao().remove(customer);
//        loadCustomers();
//        FacesMessage msg = new FacesMessage("Deleted Record: ", customer.getCustomerEmail());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    
/**
 *  Used to find the address of the customer by the Id
 * 
 * @param customerId Requires an Integer for the customerId
 * @return Returns an Address object
 */
    public Address customerAddress(int customerId) {
        address = getAddressEao().find(customerId);
        return address;
    }
/**
 * Getter for the list of Customers
 * 
 * @return Returns a list of Customers
 */
    public List<Customers> getCustomers() {
        return customers;
    }
/**
 * Setter for the list of Customers
 * 
 * @param customers Requires a List of Customers
 */
    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
/**
 * Getter for the list of address
 * 
 * @return Returns the list of Address objects
 */
    public List<Address> getAddresses() {
        return addresses;
    }
/**
 * Setter for addresses 
 * 
 * @param addresses Requires a list of Address objects
 */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
/**
 * Getter used for the customer 
 * 
 * @return Returns the customer Object
 */
    public Customers getCustomer() {
        return customer;
    }
/**
 * 
 * Setter for the customer
 * 
 * @param customer Requires a customer object
 */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
/**
 * Getter for the address
 * 
 * @return Returns the address object
 */
    public Address getAddress() {
        return address;
    }
/**
 * Setter for the address 
 * 
 * @param address Requires an address object
 */
    public void setAddress(Address address) {
        this.address = address;
    }
/**
 * Getter for the customerEao
 * 
 * @return Returns the CustomersFacade
 */
    public CustomersFacade getCustomerEao() {
        return customerEao;
    }
/**
 * Setter for the customerEao
 * 
 * @param customerEao Requires a customersFacade
 */
    public void setCustomerEao(CustomersFacade customerEao) {
        this.customerEao = customerEao;
    }
/**
 * Getter for addressEao
 * 
 * @return Returns the addressEao
 */
    public AddressFacade getAddressEao() {
        return addressEao;
    }
/**
 * Setter for the adddressEao
 * 
 * @param addressEao Requires an AddressFacade object
 */
    public void setAddressEao(AddressFacade addressEao) {
        this.addressEao = addressEao;
    }

}
