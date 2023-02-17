package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.OrderEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(Orders.class)
public class OrdersEJB implements Orders {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public OrderEntity getSingleOrder(int id) {
        try {
            Query q = entityManager.createQuery("From OrderEntity where id = " + id);
            return (OrderEntity) (q.getSingleResult());
        } catch (NoResultException e) {
            System.out.println("Order was not found!");
            return null;
        }
    }

    @Override
    public List<OrderEntity> getOrdersByCustomerId(int costumer_id) {
        try {
            return entityManager.createQuery("From OrderEntity where customer_id = " + costumer_id).getResultList();
        } catch (NoResultException e) {
            System.out.println("Order was not found!");
            return null;
        }
    }
}