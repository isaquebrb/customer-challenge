package br.com.isaquebrb.customerchallenge.adapter.persistence.jpa;

import br.com.isaquebrb.customerchallenge.application.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAddressRepository extends JpaRepository<AddressEntity, Long> {

}
