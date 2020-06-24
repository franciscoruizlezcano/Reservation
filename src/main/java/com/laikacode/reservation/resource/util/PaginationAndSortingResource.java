package com.laikacode.reservation.resource.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <h3>Interface with pagination and sorting methods</h3>
 * @param <T> extension of {@link Object}
 * @author Francisco
 * */

public interface PaginationAndSortingResource<T> {

    ResponseEntity<T> findAll(Sort sort);

    ResponseEntity<Page<T>> findAll(Pageable pageable);
}
