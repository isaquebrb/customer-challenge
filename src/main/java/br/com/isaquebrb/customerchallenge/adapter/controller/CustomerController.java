package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.presenter.pagination.SimplePage;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.core.service.CreateCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import br.com.isaquebrb.customerchallenge.core.service.GetCustomerUseCase;
import br.com.isaquebrb.customerchallenge.core.service.UpdateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        CreateCustomerResponse response = createCustomerUseCase.create(customerRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getCustomerUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<SimplePage<GetCustomerResponse>> getAllCustomers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "active", required = false) Boolean active) {

        Pageable pageable = PageRequest.of(page, size);
        CustomerFilter customerFilter = new CustomerFilter(id, name, email, active);
        Page<GetCustomerResponse> pagedResult = getAllCustomersUseCase.getAll(pageable, customerFilter);
        return ResponseEntity.ok(new SimplePage<>(pagedResult));
    }
}
