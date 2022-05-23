package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateActivationRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateEmailRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.SimplePage;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController implements CustomerControllerApi {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetCustomerUseCase getCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @Override
    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(CreateCustomerRequest customerRequest) {

        Customer savedCustomer = createCustomerUseCase.create(customerRequest.newCustomer());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedCustomer.getId()).toUri();
        return ResponseEntity.created(location).body(new CreateCustomerResponse(savedCustomer));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerResponse> getById(Long id) {
        return ResponseEntity.ok(new GetCustomerResponse(getCustomerUseCase.getById(id)));
    }

    @Override
    @GetMapping
    public ResponseEntity<SimplePage<GetCustomerResponse>> getAllCustomers(int page,
                                                                           int size,
                                                                           CustomerFilter customerFilter) {
        SimplePage<Customer> customersPage = getAllCustomersUseCase.getAll(page, size, customerFilter);
        return ResponseEntity.ok(GetCustomerResponse.mapPageTo(customersPage));
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(Long customerId, UpdateCustomerRequest customerRequest) {

        updateCustomerUseCase.update(customerId,
                customerRequest.getName(),
                customerRequest.getAge(),
                customerRequest.getCellphone(),
                customerRequest.getPhone());
        return ResponseEntity.ok().build();
    }

    @Override
    @PatchMapping("/{id}/activation")
    public ResponseEntity<Void> updateActivationCustomer(Long customerId, UpdateActivationRequest activationRequest) {

        updateCustomerUseCase.updateActivation(customerId, activationRequest.getActive());
        return ResponseEntity.ok().build();
    }

    @Override
    @PatchMapping("/{id}/email")
    public ResponseEntity<Void> updateEmailCustomer(Long customerId, UpdateEmailRequest emailRequest) {

        updateCustomerUseCase.updateEmail(customerId, emailRequest.getEmail());
        return ResponseEntity.ok().build();
    }
}
