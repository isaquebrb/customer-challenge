package br.com.isaquebrb.customerchallenge.adapter.controller;

import br.com.isaquebrb.customerchallenge.adapter.presenter.request.AddAddressRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateAddressRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateAddressResponse;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.StandardErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AddressControllerApi {

    @Operation(summary = "Add address for a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateAddressResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<CreateAddressResponse> addAddress(@RequestBody @Valid AddAddressRequest addressRequest);

    @Operation(summary = "Update address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address updated"),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<Void> updateAddress(@PathVariable("id") Long addressId,
                                       @RequestBody @Valid CreateAddressRequest updateAddressRequest);

    @Operation(summary = "Delete address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address deleted"),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Generic error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardErrorResponse.class)))})
    ResponseEntity<Void> deleteAddress(@PathVariable("id") Long addressId);
}
