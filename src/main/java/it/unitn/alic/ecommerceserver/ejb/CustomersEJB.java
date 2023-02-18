package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(Customers.class)
public class CustomersEJB implements Customers {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    public CustomerEntity getCustomer(int id) {
        System.out.println("ENTERED GET SINGLE CUSTOMER METHOD");
        try {
            System.out.println("ENTERED GET SINGLE CUSTOMER METHOD");
            Query q = entityManager.createQuery("From CustomerEntity where id = " + id);
            CustomerEntity customerTest = (CustomerEntity) q.getSingleResult();

            System.out.println("AND HIS INFO IS " + customerTest.toString());
            return customerTest;
        } catch (NoResultException e) {
            System.out.println("Customer was not found!");
            return null;
        }
    }

    @Override
    public CustomerEntity customerLogin(String username, String password) {
        try {
            Query q = entityManager.createQuery("From CustomerEntity where username = " + username + " AND password = " + password);
            return (CustomerEntity) (q.getSingleResult());
        } catch (NoResultException e) {
            System.out.println("Customer " + username + " was not found!");
            return null;
        }
    }
}