package br.com.isaquebrb.customerchallenge.adapter.repository.entity;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true)
    private List<AddressEntity> addresses;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "cellphone", length = 50)
    private String cellphone;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "active")
    private Boolean active;

    public Customer toDomain() {
        List<Address> addressesDomain = addresses.stream()
                .map(AddressEntity::toDomain)
                .toList();

        return Customer.builder()
                .id(id)
                .name(name)
                .age(age)
                .addresses(addressesDomain)
                .email(email)
                .cellphone(cellphone)
                .phone(phone)
                .active(active)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
