package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;
import it.unitn.alic.ecommerceserver.entities.OrderDetailsEntity;
import it.unitn.alic.ecommerceserver.entities.OrderEntity;
import it.unitn.alic.ecommerceserver.entities.ProductEntity;

import java.util.List;

public interface Facade {

    CustomerEntity getSingleCustomer(int id);
    CustomerEntity getCustomerByLogin(String username, String password);
    OrderDetailsEntity getSingleOrderDetails(int id);
    List<OrderDetailsEntity> getOrderDetailsByOrderId(int order_id);
    List<OrderDetailsEntity> getOrderDetailsByProductId(int product_id);
    OrderEntity getSingleOrder(int id);
    List<OrderEntity> getOrdersByCustomerId(int costumer_id);
    ProductEntity getSingleProduct(int id);
    List<ProductEntity> getAllProducts();
}