package br.com.isaquebrb.customerchallenge.adapter.repository;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAddressRepository extends JpaRepository<AddressEntity, Long> {

}
