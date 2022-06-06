package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.persistence.repository.GetAllCustomerRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntityTest.getCustomerEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllCustomerRepositoryTest {

    @InjectMocks
    private GetAllCustomerRepository getAllCustomerRepository;

    @Mock
    private JpaCustomerRepository jpaCustomerRepository;

    @Test
    void whenGetAll_shouldReturnPage() {
        CustomerEntity customerEntity = getCustomerEntity();
        Pageable pageable = PageRequest.of(0, 10);
        Page<CustomerEntity> customerPage = new PageImpl<>(
                List.of(customerEntity, customerEntity), pageable, 2);

        when(jpaCustomerRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenReturn(customerPage);

        CustomerFilter customerFilter = new CustomerFilter();
        Page<CustomerEntity> customersFound = getAllCustomerRepository.getAll(0, 1, customerFilter);

        for (CustomerEntity foundCustomer : customersFound.getContent()) {
            CustomerEntity customer = customerPage.getContent().stream().findAny().orElseThrow();

            assertThat(foundCustomer.getId()).isEqualTo(customer.getId());
            assertThat(foundCustomer.getName()).isEqualTo(customer.getName());
            assertThat(foundCustomer.getAge()).isEqualTo(customer.getAge());
            assertThat(foundCustomer.getEmail()).isEqualTo(customer.getEmail());
            assertThat(foundCustomer.getCellphone()).isEqualTo(customer.getCellphone());
            assertThat(foundCustomer.getPhone()).isEqualTo(customer.getPhone());
            assertThat(foundCustomer.getActive()).isEqualTo(customer.getActive());
            assertThat(foundCustomer.getCreatedAt()).isEqualTo(customer.getCreatedAt());
            assertThat(foundCustomer.getUpdatedAt()).isEqualTo(customer.getUpdatedAt());
        }
    }
}
