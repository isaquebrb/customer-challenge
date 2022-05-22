package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UpdateCustomerRequest {

    @NotBlank
    private String name;

    @Min(value = 18, message = "Client age must be at least 18")
    private Integer age;
    private String cellphone;
    private String phone;
}
