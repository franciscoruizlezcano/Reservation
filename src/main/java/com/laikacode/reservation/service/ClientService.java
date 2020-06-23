package com.laikacode.reservation.service;

import com.laikacode.reservation.model.Client;
import com.laikacode.reservation.model.Client;
import com.laikacode.reservation.repository.ClientRepository;
import com.laikacode.reservation.service.util.CrudService;
import com.laikacode.reservation.service.util.PaginationAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * <h3>Class for defence services of Client Entity</h3>
 * <p>Implements {@link CrudService} and {@link PaginationAndSortingService}</p>
 * @author Francisco
 */

@Service
public class ClientService implements CrudService<Client, Integer>, PaginationAndSortingService<Client> {

    @Autowired
    private ClientRepository repository;

    /**
     * @param Client
     * @return Client
     */
    @Override
    public Client save(Client Client) {
        return this.repository.save(Client);
    }

    /**
     * @param list of List<Client>
     * @return List<Client>
     */
    @Override
    public List<Client> saveAll(List<Client> list) {
        return this.repository.saveAll(list);
    }

    /**
     * @param id
     * @return Optional<Client>
     */
    @Override
    public Optional<Client> findById(Integer id) {
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
     * @return Optional<Client>
     */
    @Override
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    /**
     * @param email
     * @return Client
     */
    public Client findByEmail(String email){
        return this.repository.findByEmail(email);
    }

    /**
     * @param identity
     * @return Client
     */
    public Client findByIdentity(String identity){
        return this.repository.findByIdentity(identity);
    }

    /**
     * @param phone
     * @return Client
     */
    public Client findByPhone(String phone){
        return this.repository.findByPhone(phone);
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
     * @param Client
     */
    @Override
    public void delete(Client Client) {
        this.repository.delete(Client);
    }

    /**
     * @param list
     */
    @Override
    public void deleteAll(List<Client> list) {
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
     * <h4>List of Client for Sort</h4>
     * @param sort
     * @return List<Client>
     */
    @Override
    public List<Client> findAll(Sort sort) {
        return this.findAll(sort);
    }

    /**
     * <h4>List of Client for Pageable</h4>
     * @param pageable
     * @return List<Client>
     */
    @Override
    public Page<Client> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

}
