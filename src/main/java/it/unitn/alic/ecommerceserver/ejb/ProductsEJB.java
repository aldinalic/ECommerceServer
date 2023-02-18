package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.ProductEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(Products.class)
public class ProductsEJB implements Products {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public ProductEntity getProduct(int id) {
        try {
            Query q = entityManager.createQuery("From ProductEntity where id = " + id);
            return (ProductEntity) (q.getSingleResult());
        } catch (NoResultException e) {
            System.out.println("Product was not found!");
            return null;
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        try {
            return entityManager.createQuery("SELECT p FROM ProductEntity p").getResultList();
        } catch (NoResultException e) {
            System.out.println("Products were not found!");
            return null;
        }
    }
}