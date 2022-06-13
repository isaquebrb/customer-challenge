package br.com.isaquebrb.customerchallenge.adapter.persistence.repository;

import br.com.isaquebrb.customerchallenge.adapter.annotation.PersistenceAdapter;
import br.com.isaquebrb.customerchallenge.adapter.persistence.jpa.JpaAddressRepository;
import br.com.isaquebrb.customerchallenge.application.persistence.DeleteAddressPersistence;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteAddressRepository implements DeleteAddressPersistence {

    private final JpaAddressRepository jpaAddressRepository;

    @Override
    public void delete(Long addressId) {
        try {
            jpaAddressRepository.deleteById(addressId);
            log.info("Address id [{}], deleted", addressId);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException("address", addressId);
        } catch (EmptyResultDataAccessException e) {
            log.warn("The address id [{}] does not exists in the database", addressId);
        }
    }
}
