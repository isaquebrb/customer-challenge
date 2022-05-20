package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(Include.NON_NULL)
public class BaseResponse {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
