package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.presenter.pagination.SimplePage;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetAllCustomerResponse;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<CreateCustomerResponse> createCustomer(
            @RequestBody @Valid CreateCustomerRequest customerRequest) {
        return ResponseEntity.ok(createCustomerUseCase.create(customerRequest));
    }

    @GetMapping
    public ResponseEntity<SimplePage<GetAllCustomerResponse>> getAllCustomers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "active", required = false) Boolean active) {

        Pageable pageable = PageRequest.of(page, size);
        CustomerFilter customerFilter = new CustomerFilter(id, name, email, active);
        Page<GetAllCustomerResponse> pagedResult = getAllCustomersUseCase.getAll(pageable, customerFilter);
        return ResponseEntity.ok(new SimplePage<>(pagedResult));
    }

}
