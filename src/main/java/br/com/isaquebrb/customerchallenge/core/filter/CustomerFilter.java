package br.com.isaquebrb.customerchallenge.core.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFilter {

    private String name;
    private Integer age;

    @Email
    private String email;
    private String cellphone;
    private String phone;
    private Boolean active;
}
