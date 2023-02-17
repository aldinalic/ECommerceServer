package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.OrderDetailsEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(OrderDetails.class)
public class OrderDetailsEJB implements OrderDetails {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public OrderDetailsEntity getSingleOrderDetails(int id) {
        try {
            Query q = entityManager.createQuery("From OrderDetailsEntity where id = " + id);
            return (OrderDetailsEntity) (q.getSingleResult());
        } catch (NoResultException e) {
            System.out.println("Order Details were not found!");
            return null;
        }
    }
    @Override
    public List<OrderDetailsEntity> getOrderDetailsByOrderId(int order_id) {
        try {
            return entityManager.createQuery("From OrderDetailsEntity where order_id = " + order_id).getResultList();
        } catch (NoResultException e) {
            System.out.println("Order Details for the Order were not found!");
            return null;
        }
    }
    @Override
    public List<OrderDetailsEntity> getOrderDetailsByProductId(int product_id) {
        try {
            return entityManager.createQuery("From OrderDetailsEntity where product_id = " + product_id).getResultList();
        } catch (NoResultException e) {
            System.out.println("Order Details for the Product were not found!");
            return null;
        }
    }
}