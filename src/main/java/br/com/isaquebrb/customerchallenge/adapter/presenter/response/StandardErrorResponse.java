package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardErrorResponse {

    private Integer status;
    private String title;
    private String message;
}
