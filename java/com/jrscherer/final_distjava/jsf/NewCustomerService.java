package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.AddressFacade;
import com.jrscherer.final_distjava.ejb.AuthoritiesFacade;
import com.jrscherer.final_distjava.ejb.CustomersFacade;
import com.jrscherer.final_distjava.ejb.UsersFacade;
import com.jrscherer.final_distjava.model.Address;
import com.jrscherer.final_distjava.model.Authorities;
import com.jrscherer.final_distjava.model.Customers;
import com.jrscherer.final_distjava.model.Formal;
import com.jrscherer.final_distjava.model.Greeting;
import com.jrscherer.final_distjava.model.Users;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

@Named(value = "newCustomerService")
@SessionScoped
public class NewCustomerService implements Serializable {

    private List<Customers> customers;
    private List<Address> addresses;
    private Customers customer;
    private Address address;
    private String password;
    private Users user;
    private Authorities authority;
    @Inject
    private CustomersFacade customerEao;
    @Inject
    private AddressFacade addressEao;
    @Inject
    private UsersFacade userEao;
    @Inject
    private AuthoritiesFacade authoritiesEao;
    @Inject
    @Formal
    private Greeting greeting;
    private String addNewMsgExists = "Record Exists";
    private String addNewMsg = "New User Created: ";
    private String baseRole = "ROLE_CUSTOMER";
    /**
     * Creates a new instance of NewCustomerService
     */
    public NewCustomerService() {
    }

    /**
     * Used to setup a new customer Also has a PostConstruct to automatically
     * set up the objects and the customers
     *
     */
    @PostConstruct
    public void setUpCustomer() {
        customer = new Customers();
        address = new Address();
        customers = getCustomerEao().findAll();
    }

    /**
     * AddNewcustomer method is used to submit the new customer and the address
     *
     * @return Returns Null to load the same page, also has a greeting sent to
     * page
     */
    public String addNewCustomer() {
        for (int i = 0; i < customers.size(); i++) {
            if (customer.getCustomerEmail().equals(customers.get(i).getCustomerEmail())) {
                FacesMessage msg = new FacesMessage(addNewMsgExists, customer.getCustomerEmail());
                FacesContext.getCurrentInstance().addMessage(null, msg);

                return null;
            }
        }
        customer.setCustomerId(null);
        customer.setAddressId(null);
        getCustomerEao().create(customer);
        address.setAddressId(null);
        getAddressEao().create(address);
        customer.setAddressId(address);
        getCustomerEao().edit(customer);
        createUserAndPassword(customer.getCustomerEmail(), getPassword());
        FacesMessage msg = new FacesMessage(addNewMsg, greeting.getGreeting(customer));
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return null;

    }

    /**
     * Used to sha and salt the password
     *
     * @param userName Requires a string of the username
     * @param password Requires a string of the Password
     * @return Returns a string of the sha and salted password
     */
    public String createUserAndPassword(String userName, String password) {
        String pwd = sha512(password, userName);
        user = new Users(userName);
        user.setPassword(pwd);
        user.setEnabled(Boolean.TRUE);

        getUserEao().create(user);
        authority = new Authorities(null, baseRole);
        authority.setUsername(user);
        getAuthoritiesEao().create(authority);
        return null;
    }

    /**
     * Getter for the User
     *
     * @return Returns the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * Setter for User
     *
     *
     * @param user Requires a Users object
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * Getter for the password
     *
     * @return Returns a string of the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the password
     *
     * @param password requires a string value for the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the userEao
     *
     * @return Returns the UsersFacade
     */
    public UsersFacade getUserEao() {
        return userEao;
    }

    /**
     * Setter for the usersEao
     *
     * @param userEao Requires a usersFacade
     */
    public void setUserEao(UsersFacade userEao) {
        this.userEao = userEao;
    }

    /**
     * Getter for the authoritiesEao
     *
     * @return Returns an AuthoritiesFacade
     */
    public AuthoritiesFacade getAuthoritiesEao() {
        return authoritiesEao;
    }

    /**
     * Setter for AuthoritiesEao
     *
     * @param authoritiesEao Requires an AuthoritiesFacade
     */
    public void setAuthoritiesEao(AuthoritiesFacade authoritiesEao) {
        this.authoritiesEao = authoritiesEao;
    }

    /**
     * Getter for customers
     *
     * @return Returns a list<customers>
     */
    public List<Customers> getCustomers() {
        return customers;
    }

    /**
     * Setter for the customers
     *
     *
     * @param customers Requires a List<Customers>
     */
    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    /**
     * Getter for addresses
     *
     * @return Returns a List<Address>
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Setter for addresses
     *
     * @param addresses Requires a List<Address>
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Getter for customer
     *
     * @return returns Customers object
     */
    public Customers getCustomer() {
        return customer;
    }

    /**
     * Setter for customer
     *
     * @param customer Requires a customers object
     */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    /**
     * Getter for address
     *
     * @return Returns the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for address
     *
     * @param address Requires Address object
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for customerEao
     *
     * @return Returns customerEao CustomersFacade object
     */
    public CustomersFacade getCustomerEao() {
        return customerEao;
    }

    /**
     * Setter for customerEao
     *
     * @param customerEao Requires a CustomersFacade object
     */
    public void setCustomerEao(CustomersFacade customerEao) {
        this.customerEao = customerEao;
    }

    /**
     * Getter for addressEao
     *
     *
     * @return Returns an AddressFacade object
     */
    public AddressFacade getAddressEao() {
        return addressEao;
    }

    /**
     * Setter for addressEao
     *
     * @param addressEao Requires an AddressFacade
     */
    public void setAddressEao(AddressFacade addressEao) {
        this.addressEao = addressEao;
    }

    /**
     * Sha512 function to sha a password
     *
     * @param pwd requires a String of the password
     * @param salt requires a String of the salt
     * @return Returns a String for the sha password
     */
    public static String sha512(String pwd, String salt) {

        ShaPasswordEncoder pe = new ShaPasswordEncoder(512);
        pe.setIterations(1024);
        String hash = pe.encodePassword(pwd, salt);

        return hash;

    }

}
