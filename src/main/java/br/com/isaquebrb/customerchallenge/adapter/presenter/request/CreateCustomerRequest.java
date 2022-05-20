package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class CreateCustomerRequest {

    @NotBlank
    private String name;
    private Integer age;
    private List<CreateAddressRequest> addresses;

    @NotNull
    @Email
    private String email;
    private String cellphone;
    private String phone;

    public Customer newCustomer() {
        List<Address> newAddresses = addresses.stream()
                .map(CreateAddressRequest::newAddress)
                .toList();

        return Customer.builder()
                .name(name)
                .age(age)
                .addresses(newAddresses)
                .email(email)
                .cellphone(cellphone)
                .phone(phone)
                .active(Boolean.TRUE)
                .build();
    }

}
