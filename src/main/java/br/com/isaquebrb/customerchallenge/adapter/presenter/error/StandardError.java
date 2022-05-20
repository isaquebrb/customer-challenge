package br.com.isaquebrb.customerchallenge.adapter.presenter.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private String title;
    private String message;
}
