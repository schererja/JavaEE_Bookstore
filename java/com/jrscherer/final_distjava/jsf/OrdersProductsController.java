package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.ejb.OrdersFacade;
import com.jrscherer.final_distjava.ejb.OrdersProductsFacade;
import com.jrscherer.final_distjava.ejb.ProductsFacade;
import com.jrscherer.final_distjava.model.Orders;
import com.jrscherer.final_distjava.model.OrdersProducts;
import com.jrscherer.final_distjava.model.Products;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * Used for the ordersProducts Table with jsf and JPA
 *
 * @author schereja
 */
@Named("ordersProductsController")
@SessionScoped
public class OrdersProductsController implements Serializable {

    private List<OrdersProducts> orderProducts;
    private OrdersProducts orderProduct;
    private Orders order;
    private Products product;
    private List<Products> products;
    private List<OrdersProducts> foundProducts;
    @Inject
    private OrdersProductsFacade orderProductsEao;

    @Inject
    private ProductsFacade productsEao;

    @Inject
    private OrdersFacade orderEao;
    private String onEditMsg = "Order ID Edited: ";
private String onCancelMsg = "Cancel Edit: ";
private String onDeleteMsg = "Order Deleted:";
    /**
     * Loads all the orderProducts and makes products an arrayList
     *
     */
    @PostConstruct
    public void loadOrderProducts() {

        orderProducts = getOrderProductsEao().findAll();
        products = new ArrayList<>();
    }

    /**
     * Basic constructor
     *
     */
    public OrdersProductsController() {
    }

    /**
     * OnEdit Method to edit the orderProducts
     *
     * @param event Requires a RowEditEvent
     */
    public void onEdit(RowEditEvent event) {
        orderProduct = (OrdersProducts) event.getObject();
        getOrderProductsEao().edit(orderProduct);
        FacesMessage msg = new FacesMessage(onEditMsg, ((OrdersProducts) event.getObject()).getOrderId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * OnCancel method for when cancel button hit
     *
     * @param event Requires RowEditEvent
     */
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(onCancelMsg, ((OrdersProducts) event.getObject()).getOrderId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Used for deleting OrderProducts
     *
     * @param product Requires an OrdersProduct object
     */
    public void deleteOrdProducts(OrdersProducts product) {
        getOrderProductsEao().remove(product);
        loadOrderProducts();
        FacesMessage msg = new FacesMessage(onDeleteMsg, orderProduct.getOrderId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    /**
     * Used to find products by order id
     *
     * @param id Requires an int for the order Id
     * @return Returns a List<Products>
     */

    public List<Products> findProductsByOrderID(int id) {
        products = new ArrayList<>();
        List<OrdersProducts[]> booksOrdered = new ArrayList<>();
       

        for (OrdersProducts ordersProducts : orderProducts) {
            products.add(ordersProducts.getProductId());
        }

        return products;
    }

    /**
     * Getter for orderProducts
     *
     * @return Returns OrdersProducts
     */
    public List<OrdersProducts> getOrderProducts() {
        return orderProducts;
    }
/**
 * Setter for orderProducts
 * 
 * @param orderProducts Requires List<OrdersProducts>
 */
    public void setOrderProducts(List<OrdersProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }
/**
 * Getter for OrderProduct
 * 
 * @return Returns an OrdersProducts object
 */
    public OrdersProducts getOrderProduct() {
        return orderProduct;
    }
/**
 * Setter for OrderProduct
 * 
 * @param orderProduct Requires an OrdersProducts object
 */
    public void setOrderProduct(OrdersProducts orderProduct) {
        this.orderProduct = orderProduct;
    }
/**
 * Getter for orderProductsEao
 * 
 * @return Returns OrdersProductsFacade object
 */
    public OrdersProductsFacade getOrderProductsEao() {
        return orderProductsEao;
    }
/**
 * Setter for orderProductsEao
 * 
 * @param orderProductsEao Requires an OrdersProductsFacade
 */
    public void setOrderProductsEao(OrdersProductsFacade orderProductsEao) {
        this.orderProductsEao = orderProductsEao;
    }
/**
 * Getter for order
 * 
 * @return Returns orders object
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
 * Getter for product
 * 
 * @return Returns a Products object
 */
    public Products getProduct() {
        return product;
    }
/**
 * Setter for product
 * 
 * @param product Requires a Products
 */
    public void setProduct(Products product) {
        this.product = product;
    }
/**
 * Getter for products
 * 
 * @return Returns a List<Products>
 */
    public List<Products> getProducts() {
        return products;
    }
/**
 * Setter for Products
 * 
 * @param products Requires a List<Products>
 */
    public void setProducts(List<Products> products) {
        this.products = products;
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
 * Setter for productsEao
 * 
 * @param productsEao Requires a ProductsFacade
 */
    public void setProductsEao(ProductsFacade productsEao) {
        this.productsEao = productsEao;
    }
/**
 * Getter for OrderEao
 * 
 * @return Returns OrdersFacade
 */
    public OrdersFacade getOrderEao() {
        return orderEao;
    }
/**
 * Setter for orderEao
 * 
 * @param orderEao Requires an OrdersFacade
 */
    public void setOrderEao(OrdersFacade orderEao) {
        this.orderEao = orderEao;
    }

}
