package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class ProductOrmRepository implements Repository<Product>{

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Product productEntity) {
        Product storedEntity = (Product) this.sessionFactory.getCurrentSession().save(productEntity);
        return storedEntity.getId();
    }

    @Override
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Products b", Product.class)
                .getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
