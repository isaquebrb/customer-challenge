package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.UpdateCustomerResponse;
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

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetCustomerUseCase getCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(
            @RequestBody @Valid CreateCustomerRequest customerRequest) {
        Customer savedCustomer = createCustomerUseCase.create(customerRequest.newCustomer());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedCustomer.getId()).toUri();
        return ResponseEntity.created(location).body(new CreateCustomerResponse(savedCustomer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new GetCustomerResponse(getCustomerUseCase.getById(id)));
    }

    @GetMapping
    public ResponseEntity<SimplePage<GetCustomerResponse>> getAllCustomers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "active", required = false) Boolean active) {

        CustomerFilter customerFilter = new CustomerFilter(name, age, email, active);
        SimplePage<Customer> customersFound = getAllCustomersUseCase.getAll(page, size, customerFilter);
        return ResponseEntity.ok(GetCustomerResponse.mapPageTo(customersFound));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(
            @RequestBody @Valid UpdateCustomerRequest customerRequest) {
        Customer customerUpdated = updateCustomerUseCase.update(
                customerRequest.getName(),
                customerRequest.getAge(),
                customerRequest.getCellphone(),
                customerRequest.getPhone());
        return ResponseEntity.ok(new UpdateCustomerResponse(customerUpdated));
    }
}
