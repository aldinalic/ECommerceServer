package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

public interface Customers {
    CustomerEntity getSingleCustomer(int id);
    CustomerEntity getCustomerByLogin(String username, String password);
}