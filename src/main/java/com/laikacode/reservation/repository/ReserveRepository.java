package com.laikacode.reservation.repository;

import com.laikacode.reservation.model.Client;
import com.laikacode.reservation.model.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * <h3>Reserve Repository extends of {@link JpaRepository}</h3>
 * @author Francisco
 * */
public interface ReserveRepository extends JpaRepository<Reserve, Integer> {

    /**
     * @param client
     * @return List<Reserve>
     * @author Francisco
     * */
    public List<Reserve> findByClient(@Param("client") Client client);

    /**
     * @param checkInDate
     * @return List<Reserve>
     * @author Francisco
     * */
    public List<Reserve> findByCheckInDate(@Param("checkInDate") Date checkInDate);

    /**
     * @param egressDate
     * @return List<Reserve>
     * @author Francisco
     * */
    public List<Reserve> findByEgressDate(@Param("egressDate") Date egressDate);
}
