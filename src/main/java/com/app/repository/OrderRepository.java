package com.app.repository;

import com.app.model.Order;
import com.app.model.OrderIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, OrderIdentity> {
    List<Order> findByOrderIdentityCustomerId(Long customerId);
}
