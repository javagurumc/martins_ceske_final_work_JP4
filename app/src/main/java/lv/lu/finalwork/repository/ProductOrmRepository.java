package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductOrmRepository implements lv.lu.finalwork.repository.Repository<Product> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Long save(Product productEntity) {
        entityManager.persist(productEntity);
        return productEntity.getId();
    }

    @Override
    public List<Product> findAll() {
        CriteriaQuery<Product> criteriaQuery = entityManager.getCriteriaBuilder()
                .createQuery(Product.class);
        criteriaQuery.from(Product.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
