package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.CustomersFacade;
import com.jrscherer.final_distjava.ejb.OrdersFacade;
import com.jrscherer.final_distjava.ejb.OrdersProductsFacade;
import com.jrscherer.final_distjava.ejb.ProductsFacade;
import com.jrscherer.final_distjava.model.Customers;
import com.jrscherer.final_distjava.model.Orders;
import com.jrscherer.final_distjava.model.OrdersProducts;
import com.jrscherer.final_distjava.model.Products;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Used to create a new order
 *
 * @author schereja
 */
@Named(value = "newOrderService")
@SessionScoped
public class NewOrderService implements Serializable {

    private List<Products> productsOrdered;
    private Products product;
    private double priceBeforeTax;
    private double tax = .056;
    private double totalPrice;
    private Orders order;
    private Customers customer;
    private OrdersProducts ordersProducts;
    private String username;

    @Inject
    private ProductsFacade productsEao;
    @Inject
    private OrdersFacade ordersEao;
    @Inject
    private CustomersFacade customerEao;
    @Inject
    private OrdersProductsFacade ordersProductsEao;
    private String addToOrderMsg = "Added to Order: ";
    private String orderSubmit = "Order Submitted: ";
    /**
     * Creates a new instance of NewCustomerService
     */
    public NewOrderService() {
    }

    /**
     * Sets up a new order by creating the needed objects. Run as a
     * PostConstruct
     *
     */
    @PostConstruct
    public void setUpOrder() {
        product = new Products();
        productsOrdered = new ArrayList<>();
        order = new Orders(null, new Date());
        customer = new Customers();
        ordersProducts = new OrdersProducts();
    }

    /**
     * Adds a product to the order
     *
     * @param productId Requires an integer for the productId
     */
    public void addToOrder(Integer productId) {

        product = getProductsEao().find(productId);
        productsOrdered.add(product);
        priceBeforeTax += product.getProductPrice();
        FacesMessage msg = new FacesMessage(addToOrderMsg, product.getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Used for being able to confirm the order
     *
     * @return Returns null to reload page
     */
    public String confirmOrder() {
        username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Customers> customers = getCustomerEao().findCustomerByUserName(username);
        customer = customers.get(0);
        order.setCustomerId(customer);
        getOrdersEao().create(order);
        for (int i = 0; i < productsOrdered.size(); i++) {
            ordersProducts.setOrderId(order.getOrderId());
            ordersProducts.setProductId(productsOrdered.get(i));
            ordersProducts.setQty(1);
        }
        getOrdersProductsEao().create(ordersProducts);
        FacesMessage msg = new FacesMessage(orderSubmit, ordersProducts.getOrderId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        productsOrdered = new ArrayList<>();
        totalPrice = 0.0;
        return null;

    }

    /**
     * Getter for productsOrdered
     *
     * @return Returns the list<Products>
     */
    public List<Products> getProductsOrdered() {
        return productsOrdered;
    }

    /**
     * Setter for the productsOrdered
     *
     * @param productsOrdered Requires a list<Products>
     */
    public void setProductsOrdered(List<Products> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    /**
     * Getter for the product
     *
     * @return Returns Products object
     */
    public Products getProduct() {
        return product;
    }

    /**
     * Setter for product.
     *
     * @param product Requires a Products object
     */
    public void setProduct(Products product) {
        this.product = product;
    }

    /**
     * Getter for productsEao
     *
     * @return Returns ProductsFacade
     */
    public ProductsFacade getProductsEao() {
        return productsEao;
    }

    /**
     * Setter for the productsEao
     *
     * @param productsEao Requires a ProductsFacade
     */
    public void setProductsEao(ProductsFacade productsEao) {
        this.productsEao = productsEao;
    }

    /**
     * Getter for ordersEao
     *
     * @return Returns ordersEao OrdersFacade object
     */
    public OrdersFacade getOrdersEao() {
        return ordersEao;
    }

    /**
     * Setter for ordersEao
     *
     * @param ordersEao Requires an OrdersFacade
     */
    public void setOrdersEao(OrdersFacade ordersEao) {
        this.ordersEao = ordersEao;
    }

    /**
     * Getter for the totalPrice
     *
     * @return Returns a double of the totalPrice
     */
    public double getTotalPrice() {

        return (priceBeforeTax * tax) + priceBeforeTax;
    }

    /**
     * Setter for totalPrice
     *
     * @param totalPrice Requires a double
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Getter for Tax
     *
     * @return Double of Tax Value
     */
    public double getTax() {
        return tax;
    }

    /**
     * Setter for tax
     *
     * @param tax Requires double
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * Getter for priceBeforeTax
     *
     * @return Returns a double of the price before tax
     */
    public double getPriceBeforeTax() {
        return priceBeforeTax;
    }

    /**
     * Setter for pricebeforeTax
     *
     * @param priceBeforeTax Requires a double
     */
    public void setPriceBeforeTax(double priceBeforeTax) {
        this.priceBeforeTax = priceBeforeTax;
    }

    /**
     * getter for order
     *
     * @return Returns an Orders object
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * Setter for order
     *
     * @param order Requires an Orders object
     */
    public void setOrder(Orders order) {
        this.order = order;
    }

    /**
     * Getter for ordersProducts
     *
     * @return Returns OrdersProducts object
     */
    public OrdersProducts getOrdersProducts() {
        return ordersProducts;
    }

    /**
     * Setter for ordersProduct
     *
     * @param ordersProducts Requires an OrdersProducts
     */
    public void setOrdersProducts(OrdersProducts ordersProducts) {
        this.ordersProducts = ordersProducts;
    }

    /**
     * Getter for customerEao
     *
     * @return Returns CustomersFacade
     */
    public CustomersFacade getCustomerEao() {
        return customerEao;
    }

    /**
     * Setter for customerEao
     *
     * @param customerEao Requires a CustomersFacade
     */
    public void setCustomerEao(CustomersFacade customerEao) {
        this.customerEao = customerEao;
    }

    /**
     * Getter for customer
     *
     * @return Returns a Customers object
     */
    public Customers getCustomer() {
        return customer;
    }

    /**
     * Setter for customer
     *
     * @param customer Requires a Customers
     */
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    /**
     * Getter for username
     *
     * @return Returns a String of the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for username
     *
     * @param username Requires a String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for ordersProductsEao
     *
     * @return Returns OrdersProductsFacade
     */
    public OrdersProductsFacade getOrdersProductsEao() {
        return ordersProductsEao;
    }

    /**
     * Setter for ordersProductsEao
     *
     * @param ordersProductsEao Requires a OrdersProductsFacade
     */
    public void setOrdersProductsEao(OrdersProductsFacade ordersProductsEao) {
        this.ordersProductsEao = ordersProductsEao;
    }

}
