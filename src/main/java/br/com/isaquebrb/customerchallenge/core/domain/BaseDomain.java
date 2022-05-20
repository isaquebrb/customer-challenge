package br.com.isaquebrb.customerchallenge.core.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public abstract class BaseDomain {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
