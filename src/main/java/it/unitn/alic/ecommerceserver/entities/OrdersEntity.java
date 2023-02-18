package it.unitn.alic.ecommerceserver.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class OrdersEntity implements Serializable {

    @Id
    @JoinColumn(name = "customer_id", nullable = false)
    @ManyToOne
    private CustomerEntity customer;

    @Id
    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne
    private ProductEntity product;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;
    @Column(name = "SHIPPING_ADDRESS", nullable = false)
    private String shipping_address;
    @Column(name = "STATUS", nullable = false)
    private String status;


    public OrdersEntity() {}

    public OrdersEntity(CustomerEntity customer, ProductEntity product, int amount, String shipping_address, String status) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.shipping_address = shipping_address;
        this.status = status;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity order = (OrdersEntity) o;
        return customer.equals(order.customer) && product.equals(order.product) && amount == order.amount && shipping_address.equals(order.shipping_address) && status.equals(order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, product, amount, shipping_address, status);
    }
}