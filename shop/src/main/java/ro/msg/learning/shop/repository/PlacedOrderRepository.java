package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.model.PlacedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacedOrderRepository extends JpaRepository<PlacedOrder, Integer> {
}