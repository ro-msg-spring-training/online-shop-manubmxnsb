package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Supplier, Integer> {
}