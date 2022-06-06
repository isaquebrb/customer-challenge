package br.com.isaquebrb.customerchallenge.adapter.controller.impl;

import br.com.isaquebrb.customerchallenge.adapter.controller.AddressControllerApi;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.AddAddressRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.request.CreateAddressRequest;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.CreateAddressResponse;
import br.com.isaquebrb.customerchallenge.core.service.AddAddressUseCase;
import br.com.isaquebrb.customerchallenge.core.service.DeleteAddressUseCase;
import br.com.isaquebrb.customerchallenge.core.service.UpdateAddressUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController implements AddressControllerApi {

    private final AddAddressUseCase addAddressUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;

    @Override
    @PostMapping
    public ResponseEntity<CreateAddressResponse> addAddress(AddAddressRequest addressRequest) {
        CreateAddressResponse response = new CreateAddressResponse(
                addAddressUseCase.add(addressRequest.getCustomerId(), addressRequest.newAddress()));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateAddress(Long addressId, CreateAddressRequest updateAddressRequest) {
        updateAddressUseCase.update(addressId, updateAddressRequest.newAddress());
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(Long addressId) {
        deleteAddressUseCase.delete(addressId);
        return ResponseEntity.ok().build();
    }
}
