package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class ProductOrmRepository implements Repository<Product> {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Product productEntity) {
        return (Long) this.sessionFactory.getCurrentSession().save(productEntity);
    }

    @Override
    public List<Product> findAll() {
        //Criteria API
//        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
//        Root<Product> rootEntry = cq.from(Product.class);
//        CriteriaQuery<Product> all = cq.select(rootEntry);
//
//        TypedQuery<Product> allQuery = sessionFactory.getCurrentSession().createQuery(all);
//        return allQuery.getResultList();
        //JPQL
//        return sessionFactory.getCurrentSession()
//                .createQuery("FROM PRODUCTS p", Product.class)
//                .getResultList();

        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Product> cq = session.getCriteriaBuilder().createQuery(Product.class);
        cq.from(Product.class);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
