package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.ServiceLocator;
import it.unitn.alic.ecommerceserver.entities.*;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import java.util.List;

@Stateless
@Remote(Facade.class)
public class FacadeEJB implements Facade {

    Customers customersEJB;
    Orders ordersEJB;
    Products productsEJB;

    public void ejbCreate() {
        try {
            customersEJB = (Customers) ServiceLocator.getService("java:module/CustomersEJB!it.unitn.alic.ecommerceserver.ejb.Customers");
            ordersEJB = (Orders) ServiceLocator.getService("java:module/OrdersEJB!it.unitn.alic.ecommerceserver.ejb.Orders");
            productsEJB = (Products) ServiceLocator.getService("java:module/ProductsEJB!it.unitn.alic.ecommerceserver.ejb.Products");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerEntity getCustomer(int id) {
        System.out.println("getSingleCustomer was requested with id: " + id);
        CustomerEntity customerAfterObtaining = customersEJB.getCustomer(id);
        System.out.println("Obtained customer " + customerAfterObtaining.getUsername());
        return customerAfterObtaining;
    }

    @Override
    public CustomerEntity customerLogin(String username, String password) {
        System.out.println("getCustomerByLogin was requested by " + username);
        return customersEJB.customerLogin(username, password);
    }

    @Override
    public ProductEntity getProduct(int id) {
        System.out.println("getSingleProduct was requested with " + id);
        return productsEJB.getProduct(id);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        System.out.println("getAllProducts was requested ");
        return productsEJB.getAllProducts();
    }

    @Override
    public List<OrdersEntity> getCustomerOrders(int costumer_id) {
        System.out.println("getOrdersByCustomerId was requested with customer " + costumer_id);
        return ordersEJB.getCustomerOrders(costumer_id);
    }
}