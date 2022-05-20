package br.com.isaquebrb.customerchallenge.application.service;

import br.com.isaquebrb.customerchallenge.adapter.annotation.UseCase;
import br.com.isaquebrb.customerchallenge.adapter.filter.CustomerFilter;
import br.com.isaquebrb.customerchallenge.adapter.presenter.response.GetCustomerResponse;
import br.com.isaquebrb.customerchallenge.core.persistence.GetAllCustomerPersistence;
import br.com.isaquebrb.customerchallenge.core.service.GetAllCustomersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllCustomerService implements GetAllCustomersUseCase {

    private final GetAllCustomerPersistence getAllCustomerPersistence;

    @Override
    public Page<GetCustomerResponse> getAll(Pageable pageable, CustomerFilter customerFilter) {
        List<GetCustomerResponse> customersFound =
                getAllCustomerPersistence.getAll(pageable, customerFilter).stream()
                        .map(GetCustomerResponse::new).toList();

        return new PageImpl<>(customersFound, pageable, customersFound.size());
    }
}
