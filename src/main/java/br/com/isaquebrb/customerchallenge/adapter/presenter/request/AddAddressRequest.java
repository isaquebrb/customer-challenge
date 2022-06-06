package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest extends CreateAddressRequest {

    @NotNull
    private Long customerId;
}
