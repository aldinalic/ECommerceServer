package it.unitn.alic.ecommerceserver.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pseq")
    @SequenceGenerator(name = "Pseq", sequenceName = "PRODUCT_SEQUENCE", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "CATEGORY", nullable = false)
    private String category;
    @Column(name = "STOCK", nullable = false)
    private Integer stock;
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<OrderDetailsEntity> orderDetails;

    public ProductEntity() {}

    public ProductEntity(String name, String description, String category, Integer stock, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return id.equals(product.id) && name.equals(product.name) && description.equals(product.description) && category.equals(product.category) && stock.equals(product.stock) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, stock, price);
    }
}