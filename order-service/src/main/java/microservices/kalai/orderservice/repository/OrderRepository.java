package microservices.kalai.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservices.kalai.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
