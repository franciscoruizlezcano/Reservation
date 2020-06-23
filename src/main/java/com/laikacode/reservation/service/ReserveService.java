package com.laikacode.reservation.service;

import com.laikacode.reservation.model.Client;
import com.laikacode.reservation.model.Reserve;
import com.laikacode.reservation.repository.ReserveRepository;
import com.laikacode.reservation.service.util.CrudService;
import com.laikacode.reservation.service.util.PaginationAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <h3>Class for defence services of Reserve Entity</h3>
 * <p>Implements {@link CrudService} and {@link PaginationAndSortingService}</p>
 * @author Francisco
 */

@Service
public class ReserveService implements CrudService<Reserve, Integer>, PaginationAndSortingService<Reserve> {

    @Autowired
    private ReserveRepository repository;

    /**
     * @param reserve
     * @return Reserve
     */
    @Override
    public Reserve save(Reserve reserve) {
        return this.repository.save(reserve);
    }

    /**
     * @param list
     * @return List<Reserve>
     */
    @Override
    public List<Reserve> saveAll(List<Reserve> list) {
        return this.repository.saveAll(list);
    }

    /**
     * @param id
     * @return Optional<Reserve>
     */
    @Override
    public Optional<Reserve> findById(Integer id) {
        return this.repository.findById(id);
    }

    /**
     * @param id
     * @return boolean
     */
    @Override
    public boolean existsById(Integer id) {
        return this.repository.existsById(id);
    }

    /**
     * @return cOptional<Reserve>
     */
    @Override
    public List<Reserve> findAll() {
        return this.repository.findAll();
    }

    /**
     * @param client
     * @return List<Reserve>
     */
    public List<Reserve> findByClient(Client client){
        return this.repository.findByClient(client);
    }

    /**
     * @param checkInDate
     * @return List<Reserve>
     */
    public List<Reserve> findByCheckInDate(Date checkInDate){
        return this.findByCheckInDate(checkInDate);
    }

    /**
     * @param egressDate
     * @return List<Reserve>
     */
    public List<Reserve> findByEgressDate(Date egressDate){
        return this.repository.findByEgressDate(egressDate);
    }

    /**
     * @return long
     */
    @Override
    public long count() {
        return this.repository.count();
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    /**
     * @param reserve
     */
    @Override
    public void delete(Reserve reserve) {
        this.repository.delete(reserve);
    }

    /**
     * @param list
     */
    @Override
    public void deleteAll(List<Reserve> list) {
        this.repository.deleteAll(list);
    }

    /**
     * <h4>Delete all entities</h4>
     */
    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }

    /**
     * <h4>List of Reserve for Sort</h4>
     * @param sort
     * @return List<Reserve>
     */
    @Override
    public List<Reserve> findAll(Sort sort) {
        return this.findAll(sort);
    }

    /**
     * <h4>List of Reserve for Pageable</h4>
     * @param pageable
     * @return List<Reserve>
     */
    @Override
    public Page<Reserve> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
