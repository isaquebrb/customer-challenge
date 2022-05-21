package br.com.isaquebrb.customerchallenge.core.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerFilter {

    private String name;
    private Integer age;
    private String email;
    private Boolean active;
}
