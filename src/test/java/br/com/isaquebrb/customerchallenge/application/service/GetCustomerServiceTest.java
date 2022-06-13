package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.application.persistence.GetCustomerPersistence;
import br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.isaquebrb.customerchallenge.adapter.persistence.entity.CustomerEntityTest.getCustomerEntity;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCustomerServiceTest {

    @InjectMocks
    private GetCustomerService getCustomerService;

    @Mock
    private GetCustomerPersistence getCustomerPersistence;

    @Test
    void whenGetById_shouldSendToRepository() {
        Long customerId = 15L;
        CustomerEntity customerEntity = getCustomerEntity();

        when(getCustomerPersistence.getById(customerId)).thenReturn(customerEntity);

        getCustomerService.getById(customerId);

        verify(getCustomerPersistence, times(1)).getById(customerId);
    }

}
