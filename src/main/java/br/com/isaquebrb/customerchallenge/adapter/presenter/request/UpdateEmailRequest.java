package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmailRequest {

    @Email
    @NotNull
    private String email;
}
