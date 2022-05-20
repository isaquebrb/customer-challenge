package br.com.isaquebrb.customerchallenge.adapter.repository.entity;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Builder
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

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity customer;

    public Address toDomain() {
        return Address.builder()
                .id(id)
                .street(street)
                .number(number)
                .district(district)
                .city(city)
                .state(state)
                .country(country)
                .zipCode(zipCode)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public void setCustomer(CustomerEntity customerEntity) {
        customer = customerEntity;
    }
}
