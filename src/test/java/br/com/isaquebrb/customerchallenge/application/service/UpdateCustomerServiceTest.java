package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.application.persistence.UpdateCustomerPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerServiceTest {

    @InjectMocks
    private UpdateCustomerService updateCustomerService;

    @Mock
    private UpdateCustomerPersistence updateCustomerPersistence;


    @Test
    void whenUpdate_shouldSendToPersistence() {
        Long customerId = 45L;
        String name = "Random customer update";
        Integer age = 45;
        String cellphone = "34999777755";
        String phone = "3435669988";

        updateCustomerService.update(customerId, name, age, cellphone, phone);

        verify(updateCustomerPersistence, times(1))
                .update(customerId, name, age, cellphone, phone);
    }

    @Test
    void whenUpdateEmail_shouldSendToPersistence() {
        Long customerId = 45L;
        String email = "test@customer.com.br";

        updateCustomerService.updateEmail(customerId, email);

        verify(updateCustomerPersistence, times(1)).updateEmail(customerId, email);
    }

    @Test
    void whenUpdateActivation_shouldSendToPersistence() {
        Long customerId = 45L;
        boolean active = false;

        updateCustomerService.updateActivation(customerId, active);

        verify(updateCustomerPersistence, times(1)).updateActivation(customerId, active);
    }
}
