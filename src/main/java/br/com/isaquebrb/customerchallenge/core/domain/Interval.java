package br.com.isaquebrb.customerchallenge.core.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class Interval {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
