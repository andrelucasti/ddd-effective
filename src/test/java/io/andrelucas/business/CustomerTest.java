package io.andrelucas.business;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldChangeTheName() {
        var customerId = UUID.randomUUID();
        var customer = new Customer(customerId, "Joey", "Av. California", false);

        customer.changeName("Corey");
        assertAll(
                () -> assertEquals(customerId, customer.getId()),
                () -> assertEquals("Corey", customer.getName()),
                () -> assertEquals("Av. California", customer.getAddress())
        );
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(UUID.randomUUID(), "", "Av. California", false));

        var customer = new Customer(UUID.randomUUID(), "Joey", "Av. California", false);
        assertThrows(IllegalArgumentException.class, () -> customer.changeName(""));
    }
}