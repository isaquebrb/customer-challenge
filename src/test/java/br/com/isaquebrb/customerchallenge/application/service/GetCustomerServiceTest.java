package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.core.persistence.GetCustomerPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GetCustomerServiceTest {

    @InjectMocks
    private GetCustomerService getCustomerService;

    @Mock
    private GetCustomerPersistence getCustomerPersistence;

    @Test
    void whenGetById_shouldSendToRepository() {
        Long customerId = 15L;
        getCustomerService.getById(customerId);

        verify(getCustomerPersistence, times(1)).getById(customerId);
    }

}
