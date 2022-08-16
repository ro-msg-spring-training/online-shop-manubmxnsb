package ro.msg.learning.shop.repository;

import ro.msg.learning.shop.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findAllByProductProductId(int productId);
    List<Stock> findAllByLocationId(int locationId);
}