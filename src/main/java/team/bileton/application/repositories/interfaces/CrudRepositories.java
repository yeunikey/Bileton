package team.bileton.application.repositories.interfaces;

import java.util.List;

public interface CrudRepositories<T, K> {

    void init();

    T findById(K k);
    List<T> findAll();

    void save(T t);
    void delete(K k);

}
