package it.unitn.alic.ecommerceserver.ejb;

import it.unitn.alic.ecommerceserver.entities.OrderDetailsEntity;

import java.util.List;

public interface OrderDetails {
    OrderDetailsEntity getSingleOrderDetails(int id);
    List<OrderDetailsEntity> getOrderDetailsByOrderId(int order_id);
    List<OrderDetailsEntity> getOrderDetailsByProductId(int product_id);
}
