package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.CustomerEntity;

public interface Customers {
    CustomerEntity getCustomer(int id);
    CustomerEntity customerLogin(String username, String password);
}