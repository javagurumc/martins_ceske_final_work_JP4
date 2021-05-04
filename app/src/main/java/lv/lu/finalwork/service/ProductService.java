package lv.lu.finalwork.service;

import lv.lu.finalwork.model.ItemNotFoundException;
import lv.lu.finalwork.domain.Product;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.repository.ProductCrudRepository;
import lv.lu.finalwork.validation.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private final ProductCrudRepository repository;
    private final ProductMapper mapper;
    private final ProductValidator productValidator;

    @Autowired
    public ProductService(ProductCrudRepository repository,
                          ProductMapper mapper,
                          ProductValidator productValidator) {
        this.repository = repository;
        this.mapper = mapper;
        this.productValidator = productValidator;
    }

    public void save(ProductInputData productInputData) {
        productValidator.validate(productInputData);
        final Product product = mapper.mapFrom(productInputData);
        repository.save(product);
    }

    //for REST repository simplified method
    public Product save(Product product) {
        return repository.save(product);
    }

    public List<ProductData> findAll() {
//        List<ProductData> result = new ArrayList<>();
//        for (Product product : repository.findAll()) {
//            ProductData productData = mapper.mapFrom(product);
//            result.add(productData);
//        }
//        return result;

        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::mapFrom)
                .collect(Collectors.toList());

//        return repository.findAll().stream()
//                .map(mapper::mapFrom)
//                .collect(Collectors.toList());
    }

    public Product findAll(Product product) {
        return (Product) repository.findAll();
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
