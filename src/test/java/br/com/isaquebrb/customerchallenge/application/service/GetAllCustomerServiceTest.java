package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

        getAllCustomerService.getAll(page, sizeLimit, customerFilter);

        verify(getAllCustomerPersistence, times(1)).getAll(page, sizeLimit, customerFilter);
    }
}
