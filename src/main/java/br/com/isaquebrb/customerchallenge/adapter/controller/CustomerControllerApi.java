package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateActivationRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateCustomerRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.UpdateEmailRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.StandardErrorResponse;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.core.pagination.SimplePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface CustomerControllerApi {

    @Operation(summary = "Create a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateCustomerResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest customerRequest);

    @Operation(summary = "Get customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetCustomerResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<GetCustomerResponse> getById(@PathVariable("id") Long id);

    @Operation(summary = "Get customers page filtered by attributes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customers found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetCustomerResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<SimplePage<GetCustomerResponse>> getAllCustomers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestBody @Valid CustomerFilter customerFilter);

    @Operation(summary = "Update customers name, age, cellphone and phone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated"),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<Void> updateCustomer(@PathVariable("id") Long customerId,
                                        @RequestBody @Valid UpdateCustomerRequest customerRequest);

    @Operation(summary = "Disable or enable customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated"),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<Void> updateActivationCustomer(@PathVariable("id") Long customerId,
                                                  @RequestBody @Valid UpdateActivationRequest activationRequest);

    @Operation(summary = "Update customer email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated"),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<Void> updateEmailCustomer(@PathVariable("id") Long customerId,
                                             @RequestBody @Valid UpdateEmailRequest emailRequest);
}
