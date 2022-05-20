package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerResponse extends IntervalResponse {

    private Long id;
    private String name;
    private Integer age;
    private List<Address> addresses;
    private String email;
    private String cellphone;
    private String phone;
    private Boolean active;

    public CustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        age = customer.getAge();
        addresses = customer.getAddresses();
        email = customer.getEmail();
        cellphone = customer.getCellphone();
        phone = customer.getPhone();
        active = customer.getActive();
        createdAt = customer.getCreatedAt();
        updatedAt = customer.getUpdatedAt();
    }
}
