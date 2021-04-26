package lv.lu.finalwork.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
//    @Transactional
    Long save(T entity);
    @Transactional
    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(Long id);
}
