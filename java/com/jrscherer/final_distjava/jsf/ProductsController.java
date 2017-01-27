package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.model.Products;
import com.jrscherer.final_distjava.ejb.ProductsFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 * Products controller used for jpa and jsf connnection
 *
 * @author schereja
 */
@Named("productsController")
@SessionScoped
public class ProductsController implements Serializable {

    private List<Products> products;
    private Products product;
    private String productName;
    private String productDesc;
    private float productPrice;
    private int qtyInStock;
    private String onEditMsg = "Product Edited: ";
    private String onCancelMsg = "Action Cancelled";
    private String deleteMsg = "Product Deleted: ";
    private String addedMsg = "Product Added: ";
    @Inject
    private ProductsFacade productsEao;

    /**
     * Loads all the products, with PostConstruct. NOTE:Timer seems to not work
     * correctly
     *
     */
    @Schedule(minute = "2/60", hour = "*", dayOfWeek = "*", persistent = false)
    @PostConstruct
    public void loadProducts() {
        products = getProductsEao().findAll();
    }

    /**
     * Basic constructor for a new productsController object
     *
     */
    public ProductsController() {
    }

    /**
     * OnEdit method to be used with primefaces row editor
     *
     * @param event Requires a RowEditEvent
     */
    public void onEdit(RowEditEvent event) {
        product = (Products) event.getObject();
        getProductsEao().edit(product);
        FacesMessage msg = new FacesMessage(onEditMsg, ((Products) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * OnCancel method to be used with primefaces row editor
     *
     * @param event Requires a RowEditEvent
     */
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(onCancelMsg, ((Products) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Allows to delete an object
     *
     * @param product Reqiores a Products object
     */
    public void deleteProduct(Products product) {
        getProductsEao().remove(product);
        loadProducts();
        FacesMessage msg = new FacesMessage(deleteMsg, product.getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    /**
     * Adds a new product into the database
     *
     */
    public void addProduct() {
        product = new Products(null, this.productName, this.productDesc, this.productPrice, this.qtyInStock);
        getProductsEao().create(product);
        loadProducts();
        FacesMessage msg = new FacesMessage(addedMsg, product.getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);

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
     * Setter for products
     *
     * @param products Requires a List<Products>
     */
    public void setProducts(List<Products> products) {
        this.products = products;
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
 * @param product Requires a Products object
 */
    public void setProduct(Products product) {
        this.product = product;
    }
/**
 * Getter for productsEao
 * 
 * @return Returns a ProductsFacade
 */
    public ProductsFacade getProductsEao() {
        return productsEao;
    }
/**
 * Setter for ProductsEao
 * 
 * @param productsEao Requires a ProductsFacade
 */
    public void setProductsEao(ProductsFacade productsEao) {
        this.productsEao = productsEao;
    }
/**
 * Getter for productName
 * 
 * @return Returns a String of the productName
 */
    public String getProductName() {
        return productName;
    }
/**
 * Setter for productName
 * 
 * @param productName Requires a String value
 */
    public void setProductName(String productName) {
        this.productName = productName;
    }
/**
 * Getter for productDesc
 * 
 * @return Returns a String of the productDesc
 */
    public String getProductDesc() {
        return productDesc;
    }
/**
 * Setter for the ProductDesc
 * 
 * @param productDesc Requires a String of the productDesc
 */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
/**
 * Getter for the product Price
 * @return Returns a float of the productPrice
 */
    public float getProductPrice() {
        return productPrice;
    }
/**
 * Setter for the productPrice
 * 
 * @param productPrice Requires a Float of the product Price
 */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
/**
 * Getter for QtyInStock
 * 
 * @return Returns the qtyInStock
 */
    public int getQtyInStock() {
        return qtyInStock;
    }
/**
 * Setter for QtyInStock
 * 
 * @param qtyInStock Requires an int of the qtyInStock
 */
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

}
