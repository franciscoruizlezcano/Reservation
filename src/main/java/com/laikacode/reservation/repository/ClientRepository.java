package com.laikacode.reservation.repository;

import com.laikacode.reservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


/**
 * <h3>Client Repository extension of {@link JpaRepository}</h3>
 * @author Francisco
 * */
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /**
     * @param email
     * @return Client
     * @author Francisco
     * */
    public Client findByEmail(@Param("email") String email);

    /**
     * @param identity
     * @return Client
     * @author Francisco
     * */
    public Client findByIdentity(@Param("identity") String identity);

    /**
     * @param phone
     * @return Client
     * @author Francisco
     * */
    public Client findByPhone(@Param("phone") String phone);

}
