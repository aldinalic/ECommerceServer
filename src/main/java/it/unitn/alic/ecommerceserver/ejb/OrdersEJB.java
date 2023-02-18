package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.OrdersEntity;

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
    public List<OrdersEntity> getCustomerOrders(int costumer_id) {
        try {
            Query q = entityManager.createQuery(
                    "From CustomerEntity where customer.id = " + costumer_id
            );
            List<OrdersEntity> orders = q.getResultList();
            if (orders.isEmpty()) System.out.println("Customer does not have orders!");
            return orders;
        } catch (NoResultException e) {
            System.out.println("Customer Orders were not found");
            return null;
        }
    }
}