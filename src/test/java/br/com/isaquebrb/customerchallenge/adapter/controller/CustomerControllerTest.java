package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateActivationRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateEmailRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.SimplePage;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Random;

import static br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequestTest.getCustomerRequest;
import static br.com.isaquebrb.customerchallenge.core.domain.CustomerTest.getCustomer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CreateCustomerUseCase createCustomerUseCase;

    @Mock
    private GetCustomerUseCase getCustomerUseCase;

    @Mock
    private GetAllCustomersUseCase getAllCustomersUseCase;

    @Mock
    private UpdateCustomerUseCase updateCustomerUseCase;

    private final Customer customer = getCustomer();
    private final Address address = customer.getAddresses().stream().findFirst().orElseThrow();

    @Test
    void whenCreateCustomer_shouldReturnCustomer() {
        CreateCustomerRequest customerRequest = getCustomerRequest();

        when(createCustomerUseCase.create(any())).thenReturn(customer);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var responseEntity = customerController.createCustomer(customerRequest);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        var createCustomerResponse = responseEntity.getBody();
        assertThat(createCustomerResponse).isNotNull();
        assertThat(createCustomerResponse.getId()).isEqualTo(customer.getId());
        assertThat(createCustomerResponse.getEmail()).isEqualTo(customer.getEmail());
        assertThat(createCustomerResponse.getName()).isEqualTo(customer.getName());

        var addresssResponse = createCustomerResponse.getAddresses().stream().findAny().orElseThrow();

        assertThat(addresssResponse.getId()).isEqualTo(address.getId());
        assertThat(addresssResponse.getStreet()).isEqualTo(address.getStreet());
        assertThat(addresssResponse.getNumber()).isEqualTo(address.getNumber());
        assertThat(addresssResponse.getCity()).isEqualTo(address.getCity());
        assertThat(addresssResponse.getZipCode()).isEqualTo(address.getZipCode());
    }

    @Test
    void whenGetById_shouldReturnCustomer() {
        when(getCustomerUseCase.getById(anyLong())).thenReturn(customer);

        var responseEntity = customerController.getById(new Random().nextLong());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        var getCustomerResponse = responseEntity.getBody();
        assertThat(getCustomerResponse).isNotNull();

        assertCustomerResponse(getCustomerResponse);
    }

    @Test
    void whenGetAll_shouldReturnAllCustomers() {
        int page = 2;
        int size = 20;

        var customerList = List.of(customer, customer);
        var customersPage = new SimplePage<>(customerList, page, size, 2L);

        when(getAllCustomersUseCase.getAll(anyInt(), anyInt(), any())).thenReturn(customersPage);

        var responseEntity = customerController.getAllCustomers(
                page, size, null, null, null, null, null, null);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        var getCustomerResponse = responseEntity.getBody();
        assertThat(getCustomerResponse).isNotNull();

        getCustomerResponse.getContent().forEach(this::assertCustomerResponse);
    }

    @Test
    void whenGetAll_verifyCustomerFilter() {
        int page = 2;
        int size = 20;
        String name = "Random customer name";
        Integer age = 23;
        String email = "test03@customer.com.br";
        String cellphone = "34998887799";
        String phone = "3432321515";
        Boolean active = true;

        var customerList = List.of(customer, customer);
        var customersPage = new SimplePage<>(customerList, page, size, 2L);

        when(getAllCustomersUseCase.getAll(anyInt(), anyInt(), any())).thenReturn(customersPage);

        customerController.getAllCustomers(page, size, name, age, email, cellphone, phone, active);

        ArgumentCaptor<CustomerFilter> filterCaptor = ArgumentCaptor.forClass(CustomerFilter.class);

        verify(getAllCustomersUseCase).getAll(anyInt(), anyInt(), filterCaptor.capture());

        assertThat(filterCaptor.getValue().getName()).isEqualTo(name);
        assertThat(filterCaptor.getValue().getAge()).isEqualTo(age);
        assertThat(filterCaptor.getValue().getEmail()).isEqualTo(email);
        assertThat(filterCaptor.getValue().getCellphone()).isEqualTo(cellphone);
        assertThat(filterCaptor.getValue().getPhone()).isEqualTo(phone);
        assertThat(filterCaptor.getValue().getActive()).isEqualTo(active);
    }

    @Test
    void whenUpdateCustomer_verifyUpdate() {
        Long customerId = 150L;
        String name = "Random customer name";
        Integer age = 23;
        String cellphone = "34998887799";
        String phone = "3432321515";

        var updateRequest = new UpdateCustomerRequest(name, age, cellphone, phone);

        customerController.updateCustomer(customerId, updateRequest);

        verify(updateCustomerUseCase, times(1))
                .update(customerId, name, age, cellphone, phone);
    }

    @Test
    void whenUpdateCustomerActivation_verifyUpdate() {
        Long customerId = 150L;
        boolean activation = true;

        var updateActivation = new UpdateActivationRequest(activation);

        customerController.updateActivationCustomer(customerId, updateActivation);

        verify(updateCustomerUseCase, times(1)).updateActivation(customerId, activation);
    }

    @Test
    void whenUpdateCustomerEmail_verifyUpdate() {
        Long customerId = 150L;
        String email = "email@customer.com.br";

        var updateEmail = new UpdateEmailRequest(email);

        customerController.updateEmailCustomer(customerId, updateEmail);

        verify(updateCustomerUseCase, times(1)).updateEmail(customerId, email);
    }

    private void assertCustomerResponse(GetCustomerResponse customerResponse) {
        assertThat(customerResponse).isNotNull();
        assertThat(customerResponse.getId()).isEqualTo(customer.getId());
        assertThat(customerResponse.getName()).isEqualTo(customer.getName());
        assertThat(customerResponse.getAge()).isEqualTo(customer.getAge());
        assertThat(customerResponse.getCellphone()).isEqualTo(customer.getCellphone());
        assertThat(customerResponse.getPhone()).isEqualTo(customer.getPhone());
        assertThat(customerResponse.getEmail()).isEqualTo(customer.getEmail());
        assertThat(customerResponse.getActive()).isEqualTo(customer.getActive());
        assertThat(customerResponse.getCreatedAt()).isEqualTo(customer.getCreatedAt());
        assertThat(customerResponse.getUpdatedAt()).isEqualTo(customer.getUpdatedAt());

        var getAddressResponse = customerResponse.getAddresses().stream().findFirst().orElseThrow();
        assertThat(getAddressResponse.getId()).isEqualTo(address.getId());
        assertThat(getAddressResponse.getStreet()).isEqualTo(address.getStreet());
        assertThat(getAddressResponse.getNumber()).isEqualTo(address.getNumber());
        assertThat(getAddressResponse.getCity()).isEqualTo(address.getCity());
        assertThat(getAddressResponse.getDistrict()).isEqualTo(address.getDistrict());
        assertThat(getAddressResponse.getState()).isEqualTo(address.getState());
        assertThat(getAddressResponse.getCountry()).isEqualTo(address.getCountry());
        assertThat(getAddressResponse.getZipCode()).isEqualTo(address.getZipCode());
        assertThat(getAddressResponse.getCreatedAt()).isEqualTo(address.getCreatedAt());
        assertThat(getAddressResponse.getUpdatedAt()).isEqualTo(address.getUpdatedAt());
    }


}
