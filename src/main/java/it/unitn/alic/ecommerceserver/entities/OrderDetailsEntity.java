package it.unitn.alic.ecommerceserver.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetailsEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ODseq")
    @SequenceGenerator(name = "ODseq", sequenceName = "ORDER_DETAILS_SEQUENCE", allocationSize = 1)
    private Integer id;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order; // defining the relationship between this table and order table
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product; // defining the relationship between this table and product table

    public OrderDetailsEntity() {}

    public OrderDetailsEntity(Integer quantity, BigDecimal price, OrderEntity order, ProductEntity product) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsEntity order_details = (OrderDetailsEntity) o;
        return id.equals(order_details.id) && order.equals(order_details.order) && product.equals(order_details.product) && quantity.equals(order_details.quantity) && price.equals(order_details.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, product, quantity, price);
    }
}