package br.com.isaquebrb.customerchallenge.adapter.repository.entity;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private final List<AddressEntity> addresses = new ArrayList<>();

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "cellphone", length = 50)
    private String cellphone;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "active")
    private Boolean active;

    public void addAddress(AddressEntity addressEntity) {
        addresses.add(addressEntity);
        addressEntity.setCustomer(this);
    }

    public Customer toDomain() {
        Customer customer = Customer.builder()
                .id(id)
                .name(name)
                .age(age)
                .email(email)
                .cellphone(cellphone)
                .phone(phone)
                .active(active)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();

        addresses.stream()
                .map(a -> a.toDomain(customer))
                .forEach(customer::addAddress);

        return customer;
    }
}
