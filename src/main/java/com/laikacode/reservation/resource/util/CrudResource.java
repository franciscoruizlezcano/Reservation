package com.laikacode.reservation.resource.util;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * <h3>Interface with crud methods</h3>
 * @param <T> extension of {@link Object}
 * @param <D> extension of {@link Object}
 * @param <I> extension of {@link Object}
 * @author Francisco
 * */

public interface CrudResource<T, D, I>{

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(I id);

    ResponseEntity<HashMap<String, Boolean>> existsById(I id);

    ResponseEntity<HashMap<String, Long>> count();

    ResponseEntity<T> save(D d);

    ResponseEntity<T> update(I id, D d);

    ResponseEntity<HashMap<String, Boolean >> delete(I id);
}
