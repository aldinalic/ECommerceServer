package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.OrdersEntity;
import java.util.List;

public interface Orders {
    List<OrdersEntity> getCustomerOrders(int costumer_id);
}