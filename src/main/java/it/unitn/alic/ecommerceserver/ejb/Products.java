package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.ProductEntity;

import java.util.List;

public interface Products {
    ProductEntity getSingleProduct(int id);
    List<ProductEntity> getAllProducts();
}