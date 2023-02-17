package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.OrderEntity;

import java.util.List;

public interface Orders {
    OrderEntity getSingleOrder(int id);
    List<OrderEntity> getOrdersByCustomerId(int costumer_id);
}
