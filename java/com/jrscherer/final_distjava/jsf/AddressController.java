package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.AddressFacade;
import com.jrscherer.final_distjava.model.Address;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Address controller is used to allow jsf to interact with jpa.
 *
 * @author schereja
 */
@Named("addressController")
@SessionScoped
public class AddressController implements Serializable {

    private List<Address> addresses;
    private Address address;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private int zipCode;
    @Inject
    private AddressFacade addressEao;

    /**
     * Basic Constructor to be used to create AddressController objects
     *
     */
    public AddressController() {
    }

    /**
     * Method used to Load all the Addresses. Also used as a PostConstruct
     *
     */
    @PostConstruct
    public void loadAddresses() {
        addresses = getAddressEao().findAll();
    }

    /**
     * Method used to add a new address. Takes values that were gotten from jsf
     * page to create address
     *
     *
     */
    public void addAddress() {
        address = new Address(null, line1, line2, city, state, zipCode);
        getAddressEao().create(address);
    }

    /**
     * Getter for the Addresses
     *
     * @return Returns a list of Address objects
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Setter for the addresses
     *
     * @param addresses Requires a list of Addresses
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Getter for the address object
     *
     * @return Returns an address object
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for the address object
     *
     * @param address Requires an address object
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for the addressFacade
     *
     * @return Returns the addressFacade being used
     */
    public AddressFacade getAddressEao() {
        return addressEao;
    }

    /**
     * Setter for the addressFacade
     *
     * @param addressEao Requires an AddressFacade
     */
    public void setAddressEao(AddressFacade addressEao) {
        this.addressEao = addressEao;
    }

}
