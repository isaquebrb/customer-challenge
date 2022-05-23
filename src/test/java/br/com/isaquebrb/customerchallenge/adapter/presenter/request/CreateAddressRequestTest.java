package br.com.isaquebrb.customerchallenge.adapter.presenter.request;

import br.com.isaquebrb.customerchallenge.core.domain.Address;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAddressRequestTest {

    private final CreateAddressRequest addressRequest = getAddressRequest();

    @Test
    void whenNewAddress_shouldCreateAddress() {
        Address newAddress = addressRequest.newAddress();
        assertThat(newAddress.getStreet()).isEqualTo(addressRequest.getStreet());
        assertThat(newAddress.getNumber()).isEqualTo(addressRequest.getNumber());
        assertThat(newAddress.getDistrict()).isEqualTo(addressRequest.getDistrict());
        assertThat(newAddress.getCity()).isEqualTo(addressRequest.getCity());
        assertThat(newAddress.getState()).isEqualTo(addressRequest.getState());
        assertThat(newAddress.getCountry()).isEqualTo(addressRequest.getCountry());
        assertThat(newAddress.getZipCode()).isEqualTo(addressRequest.getZipCode());
    }

    public static CreateAddressRequest getAddressRequest() {
        return CreateAddressRequest.builder()
                .street("Random street")
                .number(1456)
                .district("Sta Bronks")
                .city("Harrisburg")
                .state("Pensilvania")
                .country("United States")
                .zipCode("38407998").build();
    }
}
