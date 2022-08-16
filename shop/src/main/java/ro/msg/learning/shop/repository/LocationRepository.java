package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}