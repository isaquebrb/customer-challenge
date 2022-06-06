package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.adapter.persistence.repository.GetCustomerRepository;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntityTest.getCustomerEntity;
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

        CustomerEntity customerFound = getCustomerRepository.getById(1L);

        assertThat(customerFound.getId()).isEqualTo(customerEntity.getId());
        assertThat(customerFound.getName()).isEqualTo(customerEntity.getName());
        assertThat(customerFound.getAge()).isEqualTo(customerEntity.getAge());
        assertThat(customerFound.getEmail()).isEqualTo(customerEntity.getEmail());
        assertThat(customerFound.getCellphone()).isEqualTo(customerEntity.getCellphone());
        assertThat(customerFound.getPhone()).isEqualTo(customerEntity.getPhone());
        assertThat(customerFound.getActive()).isEqualTo(customerEntity.getActive());
        assertThat(customerFound.getCreatedAt()).isEqualTo(customerEntity.getCreatedAt());
        assertThat(customerFound.getUpdatedAt()).isEqualTo(customerEntity.getUpdatedAt());
    }

    @Test
    void whenGetById_andNotFound_mustThrowException() {
        when(jpaCustomerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> getCustomerRepository.getById(1L))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Customer id 1 not found.");
    }
}
