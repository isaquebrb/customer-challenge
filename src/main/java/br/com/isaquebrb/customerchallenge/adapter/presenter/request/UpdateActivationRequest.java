package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateActivationRequest {

    @NotNull
    Boolean active;
}
