package br.com.isaquebrb.customerchallenge.application.persistence;

import br.com.isaquebrb.customerchallenge.adapter.repository.JpaCustomerRepository;
import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.SimplePage;
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

import static br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntityTest.getCustomerEntity;
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
        Page<CustomerEntity> customerFoundPage = new PageImpl<>(
                List.of(customerEntity, customerEntity), pageable, 2);

        when(jpaCustomerRepository.findAll(any(Specification.class), any(Pageable.class)))
                .thenReturn(customerFoundPage);

        CustomerFilter customerFilter = new CustomerFilter();
        SimplePage<Customer> customerPage = getAllCustomerRepository.getAll(0, 1, customerFilter);

        for (Customer customer : customerPage.getContent()) {
            CustomerEntity foundCustomer = customerFoundPage.getContent().stream().findAny().orElseThrow();

            assertThat(customer.getId()).isEqualTo(foundCustomer.getId());
            assertThat(customer.getName()).isEqualTo(foundCustomer.getName());
            assertThat(customer.getAge()).isEqualTo(foundCustomer.getAge());
            assertThat(customer.getEmail()).isEqualTo(foundCustomer.getEmail());
            assertThat(customer.getCellphone()).isEqualTo(foundCustomer.getCellphone());
            assertThat(customer.getPhone()).isEqualTo(foundCustomer.getPhone());
            assertThat(customer.getActive()).isEqualTo(foundCustomer.getActive());
            assertThat(customer.getCreatedAt()).isEqualTo(foundCustomer.getCreatedAt());
            assertThat(customer.getUpdatedAt()).isEqualTo(foundCustomer.getUpdatedAt());
        }
    }
}
