package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);

}
