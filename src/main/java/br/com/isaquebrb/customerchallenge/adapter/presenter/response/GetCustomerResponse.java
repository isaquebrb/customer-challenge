package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.List;

@Getter
@JsonPropertyOrder({"id", "name", "age", "addresses", "email",
        "cellphone", "phone", "active", "createdAt", "updatedAt"})
public class GetCustomerResponse extends BaseResponse {

    private final Long id;
    private final String name;
    private final Integer age;
    private final List<GetAddressResponse> addresses;
    private final String email;
    private final String cellphone;
    private final String phone;
    private final Boolean active;

    public GetCustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        age = customer.getAge();
        addresses = customer.getAddresses().stream()
                .map(GetAddressResponse::new)
                .toList();
        email = customer.getEmail();
        cellphone = customer.getCellphone();
        phone = customer.getPhone();
        active = customer.getActive();
        createdAt = customer.getCreatedAt();
        updatedAt = customer.getUpdatedAt();
    }
}
