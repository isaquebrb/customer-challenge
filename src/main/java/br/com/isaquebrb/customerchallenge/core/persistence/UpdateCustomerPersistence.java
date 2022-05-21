package br.com.isaquebrb.customerchallenge.core.persistence;

public interface UpdateCustomerPersistence {

    void update(Long customerId, String name, Integer age, String cellphone, String phone);

    void updateEmail(Long customerId, String email);

    void updateActivation(Long customerId, boolean active);
}
