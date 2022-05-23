package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CreateCustomerRequest {

    @NotBlank
    private String name;

    @Min(value = 18, message = "customer age must be at least 18")
    private Integer age;
    private final List<CreateAddressRequest> addresses = new ArrayList<>();

    @NotNull
    @Email
    private String email;
    private String cellphone;
    private String phone;

    public Customer newCustomer() {
        Customer newCustomer = Customer.builder()
                .name(name)
                .age(age)
                .email(email)
                .cellphone(cellphone)
                .phone(phone)
                .active(Boolean.TRUE)
                .build();

        addresses.stream()
                .map(CreateAddressRequest::newAddress)
                .forEach(newCustomer::addAddress);

        return newCustomer;
    }

}
