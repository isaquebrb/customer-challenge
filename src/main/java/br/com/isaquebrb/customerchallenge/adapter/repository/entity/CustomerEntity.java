package br.com.isaquebrb.customerchallenge.adapter.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity extends IntervalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cellphone", length = 50)
    private String cellphone;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "active")
    private Boolean active;
}
