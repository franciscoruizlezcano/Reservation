package com.laikacode.reservation.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <h3>Client POJO</h3>
 * <p>POJO represent Client entity extension of {@link Object} and implements {@link Serializable}</p>
 * @author Francisco
 * */

@Data
@Entity
@Table(name = "client")
@NamedQueries({
        @NamedQuery(name = "Client.findByEmail", query = "select c from Client c where c.email = :email"),
        @NamedQuery(name = "Client.findByIdentity", query = "select c from Client c where c.identity = :identity"),
        @NamedQuery(name = "Client.findByPhone", query = "select c from Client c where c.phone = :phone"),
})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "identity")
    private String identity;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private List<Reserve> reservationList;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(String name, String lastname, String identity, String phone, String email) {
        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.phone = phone;
        this.email = email;
    }

    public Client(Integer id, String name, String lastname, String identity, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identity = identity;
        this.phone = phone;
        this.email = email;
    }
}
