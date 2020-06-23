package com.laikacode.reservation.service.util;

import java.util.List;
import java.util.Optional;

/**
 * <h3>Interface with crud methods</h3>
 * @param <T> extension of {@link Object}
 * @param <ID> extension of {@link Object}
 * @author Francisco
 * */

public interface CrudService<T, ID>{

    T save(T t);

    List<T> saveAll(List<T> list);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    long count();

    void deleteById(ID id);

    void delete(T t);

    void deleteAll(List<T> list);

    void deleteAll();
}
