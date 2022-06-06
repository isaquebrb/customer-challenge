package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.application.persistence.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.application.persistence.GetAllCustomerPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllCustomerServiceTest {

    @InjectMocks
    private GetAllCustomerService getAllCustomerService;

    @Mock
    private GetAllCustomerPersistence getAllCustomerPersistence;

    @Test
    void whenGetAll_shouldCallRepository() {
        int page = 0;
        int sizeLimit = 1;
        CustomerFilter customerFilter = new CustomerFilter();

        Page<CustomerEntity> customerPage = new PageImpl<>(
                Collections.emptyList(), PageRequest.of(page, sizeLimit), 0);

        when(getAllCustomerPersistence.getAll(page, sizeLimit, customerFilter)).thenReturn(customerPage);

        getAllCustomerService.getAll(page, sizeLimit, customerFilter);

        verify(getAllCustomerPersistence, times(1)).getAll(page, sizeLimit, customerFilter);
    }
}
