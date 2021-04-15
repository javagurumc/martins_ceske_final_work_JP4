package lv.lu.finalwork.service;

import lv.lu.finalwork.model.ItemNotFoundException;
import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductRepository repository;

    public ProductService() {
        this.repository = new ProductRepository();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public Product findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product Id can't be null");
        }

        Optional<Product> result = repository.findById(id);
        if (!result.isPresent()) {
            throw new ItemNotFoundException(
                    String.format("Product by id: %d is not found", id));
        }

        return result.get();
    }

    public List<Product> findAll() {
        return null;
    }

    public void delete(Long id) {

    }
}
