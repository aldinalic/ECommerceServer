package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.ServiceLocator;
import it.unitn.alic.ecommerceserver.entities.CustomerEntity;
import it.unitn.alic.ecommerceserver.entities.OrderDetailsEntity;
import it.unitn.alic.ecommerceserver.entities.OrderEntity;
import it.unitn.alic.ecommerceserver.entities.ProductEntity;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import java.util.List;

@Stateless
@Remote(Facade.class)
public class FacadeEJB implements Facade {

    CustomersEJB customersEJB;
    OrderDetailsEJB orderDetailsEJB;
    OrdersEJB ordersEJB;
    ProductsEJB productsEJB;

    public void ejbCreate() {
        try {
            customersEJB = (CustomersEJB) ServiceLocator.getService("ejb:/ECommerceServer-1.0-SNAPSHOT/CustomersEJB!it.unitn.alic.ecommerceserver.ejb.Customers");
            orderDetailsEJB = (OrderDetailsEJB) ServiceLocator.getService("ejb:/ECommerceServer-1.0-SNAPSHOT/OrderDetailsEJB!it.unitn.alic.ecommerceserver.ejb.OrderDetails");
            ordersEJB = (OrdersEJB) ServiceLocator.getService("ejb:/ECommerceServer-1.0-SNAPSHOT/OrdersEJB!it.unitn.alic.ecommerceserver.ejb.Orders");
            productsEJB = (ProductsEJB) ServiceLocator.getService("ejb:/ECommerceServer-1.0-SNAPSHOT/ProductsEJB!it.unitn.alic.ecommerceserver.ejb.Products");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerEntity getSingleCustomer(int id) {
        System.out.println("getSingleCustomer was requested with " + id);
        return customersEJB.getSingleCustomer(id);
    }

    @Override
    public CustomerEntity getCustomerByLogin(String username, String password) {
        System.out.println("getCustomerByLogin was requested by " + username);
        return customersEJB.getCustomerByLogin(username, password);
    }

    @Override
    public OrderDetailsEntity getSingleOrderDetails(int id) {
        System.out.println("getSingleOrderDetails was requested with " + id);
        return orderDetailsEJB.getSingleOrderDetails(id);
    }

    @Override
    public List<OrderDetailsEntity> getOrderDetailsByOrderId(int order_id) {
        System.out.println("getOrderDetailsByOrderId was requested with order " + order_id);
        return orderDetailsEJB.getOrderDetailsByOrderId(order_id);
    }

    @Override
    public List<OrderDetailsEntity> getOrderDetailsByProductId(int product_id) {
        System.out.println("getOrderDetailsByOrderId was requested with product " + product_id);
        return orderDetailsEJB.getOrderDetailsByOrderId(product_id);
    }

    @Override
    public OrderEntity getSingleOrder(int id) {
        System.out.println("getSingleOrder was requested with " + id);
        return ordersEJB.getSingleOrder(id);
    }

    @Override
    public List<OrderEntity> getOrdersByCustomerId(int costumer_id) {
        System.out.println("getOrdersByCustomerId was requested with customer " + costumer_id);
        return ordersEJB.getOrdersByCustomerId(costumer_id);
    }

    @Override
    public ProductEntity getSingleProduct(int id) {
        System.out.println("getSingleProduct was requested with " + id);
        return productsEJB.getSingleProduct(id);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        System.out.println("getAllProducts was requested ");
        return productsEJB.getAllProducts();
    }
}