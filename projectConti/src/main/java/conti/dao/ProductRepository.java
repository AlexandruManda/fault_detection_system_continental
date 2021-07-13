package conti.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conti.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
