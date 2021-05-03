package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface ProductCrudRepository extends CrudRepository<Product, Long> {

}
