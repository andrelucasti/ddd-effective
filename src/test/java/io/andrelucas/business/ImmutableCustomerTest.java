package io.andrelucas.business;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableCustomerTest {

    @Test
    void shouldChangeTheName() {
        var immutableCustomerId = UUID.randomUUID();
        var immutableCustomer = new ImmutableCustomer(immutableCustomerId, "Lucas", "Av. Pretty Lisbon", false);

        var customerWithNewName = immutableCustomer.changeName("Andre");

        assertAll(
                () -> assertEquals(immutableCustomer.id(), customerWithNewName.id()),
                () -> assertNotEquals(immutableCustomer.name(), customerWithNewName.name()),
                () -> assertEquals("Andre", customerWithNewName.name()),
                () -> assertEquals(immutableCustomer.address(), customerWithNewName.address())
        );
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new ImmutableCustomer(UUID.randomUUID(), "", "Av. Pretty Lisbon", false));

        var immutableCustomer = new ImmutableCustomer(UUID.randomUUID(), "Lucas", "Av. Pretty Lisbon", false);
        assertThrows(IllegalArgumentException.class, () -> immutableCustomer.changeName(""));
    }

    @Test
    void shouldThrowExceptionWhenActivateACustomerWithoutAddress() {
        var immutableCustomer = new ImmutableCustomer(UUID.randomUUID(), "Andre", "", false);

        assertThrows(IllegalArgumentException.class, immutableCustomer::activate);

    }

    @Test
    void shouldActivateACustomer() {
        var immutableCustomerId = UUID.randomUUID();
        var immutableCustomer = new ImmutableCustomer(immutableCustomerId, "Lucas", "Av. Pretty Lisbon", false);

        var activatedCustomer = immutableCustomer.activate();

        assertAll(
                () -> assertEquals(immutableCustomer.id(), activatedCustomer.id()),
                () -> assertEquals(immutableCustomer.name(), activatedCustomer.name()),
                () -> assertEquals(immutableCustomer.address(), activatedCustomer.address()),
                () -> assertTrue(activatedCustomer.active())
        );
    }
}