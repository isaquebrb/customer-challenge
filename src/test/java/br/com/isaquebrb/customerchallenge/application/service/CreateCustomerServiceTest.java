package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.persistence.CreateCustomerPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.isaquebrb.customerchallenge.core.domain.CustomerTest.getCustomer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateCustomerServiceTest {

    @InjectMocks
    private CreateCustomerService createCustomerService;

    @Mock
    private CreateCustomerPersistence createCustomerPersistence;

    @Test
    void whenCreateCustomer_shouldSendToRepository() {
        Customer customer = getCustomer();

        createCustomerService.create(customer);

        verify(createCustomerPersistence, times(1)).save(customer);
    }
}
