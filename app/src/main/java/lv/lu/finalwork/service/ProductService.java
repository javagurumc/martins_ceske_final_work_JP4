package lv.lu.finalwork.service;

import lv.lu.finalwork.model.ItemNotFoundException;
import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void save(ProductInputData productInputData) {
        final Product product = mapper.mapFrom(productInputData);
        repository.save(product);
    }

    public List<ProductData> findAll() {
//        List<ProductData> result = new ArrayList<>();
//        for (Product product : repository.findAll()) {
//            ProductData productData = mapper.mapFrom(product);
//            result.add(productData);
//        }
//        return result;

        return repository.findAll().stream()
                .map(mapper::mapFrom)
                .collect(Collectors.toList());
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

    public void delete(Long id) {

    }
}
