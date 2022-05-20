package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class UpdateActiveRequest {

    @NotNull
    boolean active;
}
