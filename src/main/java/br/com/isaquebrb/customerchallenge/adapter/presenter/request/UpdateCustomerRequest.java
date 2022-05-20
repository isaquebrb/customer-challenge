package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UpdateCustomerRequest {

    @NotBlank
    private String name;
    private Integer age;
    private String cellphone;
    private String phone;
}
