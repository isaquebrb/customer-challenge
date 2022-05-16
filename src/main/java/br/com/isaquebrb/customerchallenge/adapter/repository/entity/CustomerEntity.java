package br.com.isaquebrb.customerchallenge.adapter.repository.entity;

import br.com.isaquebrb.customerchallenge.core.domain.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //todo check allocation size
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private Boolean active;
}
