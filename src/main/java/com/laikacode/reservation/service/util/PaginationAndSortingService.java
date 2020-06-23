package com.laikacode.reservation.service.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * <h3>Interface with pagination and sorting methods</h3>
 * @param <T> extension of {@link Object}
 * @author Francisco
 * */

public interface PaginationAndSortingService<T> {

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}
