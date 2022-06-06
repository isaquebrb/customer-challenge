package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.adapter.persistence.repository.CreateCustomerRepository;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Random;

import static br.com.isaquebrb.customerchallenge.core.domain.CustomerTest.getCustomer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCustomerRepositoryTest {

    @InjectMocks
    private CreateCustomerRepository createCustomerRepository;

    @Mock
    private JpaCustomerRepository jpaCustomerRepository;

    private final Customer customer = getCustomer();

    @Test
    void whenSave_shouldReturnCustomer() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(new Random().nextLong())
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmail())
                .cellphone(customer.getCellphone())
                .phone(customer.getPhone())
                .active(customer.getActive())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        when(jpaCustomerRepository.save(any())).thenReturn(customerEntity);

        CustomerEntity savedCustomer = createCustomerRepository.save(customer);

        assertThat(savedCustomer.getId()).isEqualTo(customerEntity.getId());
        assertThat(savedCustomer.getName()).isEqualTo(customer.getName());
        assertThat(savedCustomer.getAge()).isEqualTo(customer.getAge());
        assertThat(savedCustomer.getEmail()).isEqualTo(customer.getEmail());
        assertThat(savedCustomer.getCellphone()).isEqualTo(customer.getCellphone());
        assertThat(savedCustomer.getPhone()).isEqualTo(customer.getPhone());
        assertThat(savedCustomer.getActive()).isEqualTo(customer.getActive());
        assertThat(savedCustomer.getCreatedAt()).isEqualTo(customerEntity.getCreatedAt());
        assertThat(savedCustomer.getUpdatedAt()).isEqualTo(customerEntity.getUpdatedAt());
    }
}
