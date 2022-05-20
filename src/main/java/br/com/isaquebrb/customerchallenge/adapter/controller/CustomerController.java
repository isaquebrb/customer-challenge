package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CustomerResponse;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.ok(createCustomerUseCase.create(customerRequest));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAllCustomers(
            Pageable pageable,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "active", required = false) Boolean active) {

        CustomerFilter customerFilter = new CustomerFilter(name, age, email, active);
        return ResponseEntity.ok(getAllCustomersUseCase.getAll(pageable, customerFilter.getSpecification()));
    }

}
