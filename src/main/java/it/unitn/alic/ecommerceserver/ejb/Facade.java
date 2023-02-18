package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.*;
import java.util.List;

public interface Facade {

    CustomerEntity getCustomer(int id);
    CustomerEntity customerLogin(String username, String password);
    ProductEntity getProduct(int id);
    List<ProductEntity> getAllProducts();
    List<OrdersEntity> getCustomerOrders(int id);
}