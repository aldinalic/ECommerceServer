package it.unitn.alic.ecommerceserver.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class OrderEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Oseq")
    @SequenceGenerator(name = "Oseq", sequenceName = "ORDERS_SEQUENCE", allocationSize = 1)
    private Integer id;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;
    @Column(name = "SHIPPING_ADDRESS", nullable = false)
    private String shipping_address;
    @Column(name = "STATUS", nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    public OrderEntity() {}

    public OrderEntity(Integer amount, String shipping_address, String status, CustomerEntity customer) {
        this.amount = amount;
        this.shipping_address = shipping_address;
        this.status = status;
        this.customer = customer;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity order = (OrderEntity) o;
        return id.equals(order.id) && customer.equals(order.customer) && amount.equals(order.amount) && shipping_address.equals(order.shipping_address) && status.equals(order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, amount, shipping_address, status);
    }
}