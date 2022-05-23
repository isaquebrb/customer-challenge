package br.com.isaquebrb.customerchallenge.core.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFilter {

    private String name;
    private Integer age;
    private String email;
    private String cellphone;
    private String phone;
    private Boolean active;
}
