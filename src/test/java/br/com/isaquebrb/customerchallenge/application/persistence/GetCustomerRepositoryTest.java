package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntityTest.getCustomerEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCustomerRepositoryTest {

    @InjectMocks
    private GetCustomerRepository getCustomerRepository;

    @Mock
    private JpaCustomerRepository jpaCustomerRepository;

    @Test
    void whenGetById_shouldReturnCustomer() {
        CustomerEntity customerEntity = getCustomerEntity();

        when(jpaCustomerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));

        Customer customer = getCustomerRepository.getById(1L);

        assertThat(customer.getId()).isEqualTo(customerEntity.getId());
        assertThat(customer.getName()).isEqualTo(customerEntity.getName());
        assertThat(customer.getAge()).isEqualTo(customerEntity.getAge());
        assertThat(customer.getEmail()).isEqualTo(customerEntity.getEmail());
        assertThat(customer.getCellphone()).isEqualTo(customerEntity.getCellphone());
        assertThat(customer.getPhone()).isEqualTo(customerEntity.getPhone());
        assertThat(customer.getActive()).isEqualTo(customerEntity.getActive());
        assertThat(customer.getCreatedAt()).isEqualTo(customerEntity.getCreatedAt());
        assertThat(customer.getUpdatedAt()).isEqualTo(customerEntity.getUpdatedAt());
    }

    @Test
    void whenGetById_andNotFound_mustThrowException() {
        when(jpaCustomerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> getCustomerRepository.getById(1L))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Customer id 1 not found.");
    }
}
