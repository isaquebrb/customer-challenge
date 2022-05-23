package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntityTest.getCustomerEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerRepositoryTest {

    @InjectMocks
    private UpdateCustomerRepository updateCustomerRepository;

    @Mock
    private JpaCustomerRepository jpaCustomerRepository;

    @Captor
    private ArgumentCaptor<CustomerEntity> customerCaptor;

    @Test
    void whenUpdate_shouldUpdateCustomer() {
        String name = "Random customer update";
        Integer age = 45;
        String cellphone = "34999777755";
        String phone = "3435669988";

        CustomerEntity customerEntity = getCustomerEntity();
        when(jpaCustomerRepository.findById(anyLong())).thenReturn(Optional.of(customerEntity));

        updateCustomerRepository.update(155L, name, age, cellphone, phone);

        verify(jpaCustomerRepository).save(customerCaptor.capture());

        assertThat(customerCaptor.getValue().getName()).isEqualTo(name);
        assertThat(customerCaptor.getValue().getAge()).isEqualTo(age);
        assertThat(customerCaptor.getValue().getCellphone()).isEqualTo(cellphone);
        assertThat(customerCaptor.getValue().getPhone()).isEqualTo(phone);
    }

    @Test
    void whenUpdateEmail_shouldUpdateCustomer() {
        String email = "Random customer update";

        CustomerEntity customerEntity = getCustomerEntity();
        when(jpaCustomerRepository.findById(anyLong())).thenReturn(Optional.of(customerEntity));

        updateCustomerRepository.updateEmail(150L, email);

        verify(jpaCustomerRepository).save(customerCaptor.capture());

        assertThat(customerCaptor.getValue().getEmail()).isEqualTo(email);
    }

    @Test
    void whenUpdateActivation_shouldUpdateCustomer() {
        Boolean active = false;

        CustomerEntity customerEntity = getCustomerEntity();
        when(jpaCustomerRepository.findById(anyLong())).thenReturn(Optional.of(customerEntity));

        updateCustomerRepository.updateActivation(150L, active);

        verify(jpaCustomerRepository).save(customerCaptor.capture());

        assertThat(customerCaptor.getValue().getActive()).isEqualTo(active);
    }
}
