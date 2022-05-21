package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import br.com.isaquebrb.customerchallenge.core.domain.Customer;
import lombok.Getter;

@Getter
public class UpdateCustomerResponse extends BaseResponse {

    private final Long id;
    private final String name;
    private final Integer age;
    private final String email;
    private final String cellphone;
    private final String phone;
    private final Boolean active;

    public UpdateCustomerResponse(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        age = customer.getAge();
        email = customer.getEmail();
        cellphone = customer.getCellphone();
        phone = customer.getPhone();
        active = customer.getActive();
        updatedAt = customer.getUpdatedAt();
    }
}
