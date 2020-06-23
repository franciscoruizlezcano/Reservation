package com.laikacode.reservation.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <h3>POJO Reserve</h3>
 * <p>POJO represent Reserve entity extension of {@link Object} and implements {@link Serializable}</p>
 * @author Francisco
 * */

@Data
@Entity
@Table(name = "reserve")
@NamedQueries({
        @NamedQuery(name = "Reserve.findByClient", query = "select r from Reserve r where r.client = :client"),
        @NamedQuery(name = "Reserve.findByCheckInDate", query = "select r from Reserve r where r.checkInDate = :checkInDate"),
        @NamedQuery(name = "Reserve.findByEgressDate", query = "select r from Reserve r where r.egressDate = :egressDate"),
})
public class Reserve implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "checkindate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date checkInDate;

    @Column(name = "egressdate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date egressDate;

    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

}
