package br.com.isaquebrb.customerchallenge.adapter.presenter.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class IntervalResponse {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
