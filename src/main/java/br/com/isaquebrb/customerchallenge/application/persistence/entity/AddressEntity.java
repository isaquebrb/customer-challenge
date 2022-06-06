package br.com.isaquebrb.customerchallenge.application.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer number;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CustomerEntity customer;
}
