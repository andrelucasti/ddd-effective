package io.andrelucas.business;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableCustomerTest {

    @Test
    void shouldChangeTheName() {
        var id = UUID.randomUUID();
        var address = new Address("Av. Pretty Lisbon", "Lisbon", "Lisbon", "12345-678");
        var customer = new ImmutableCustomer(id, "Lucas", address, false);

        var customerWithNewName = customer.changeName("Andre");

        assertAll(
                () -> assertEquals(customer.id(), customerWithNewName.id()),
                () -> assertNotEquals(customer.name(), customerWithNewName.name()),
                () -> assertEquals("Andre", customerWithNewName.name()),
                () -> assertEquals(customer.address(), customerWithNewName.address())
        );
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        var address = new Address("Av. Pretty Lisbon", "Lisbon", "Lisbon", "12345-678");

        assertThrows(IllegalArgumentException.class, () -> new ImmutableCustomer(UUID.randomUUID(), "", address, false));

        var customer = new ImmutableCustomer(UUID.randomUUID(), "Lucas", address, false);
        assertThrows(IllegalArgumentException.class, () -> customer.changeName(""));
    }

    @Test
    void shouldThrowExceptionWhenActivateACustomerWithoutAddress() {
        var immutableCustomer = new ImmutableCustomer(UUID.randomUUID(), "Andre", null, false);

        assertThrows(IllegalArgumentException.class, immutableCustomer::activate);

    }

    @Test
    void shouldActivateACustomer() {
        var id = UUID.randomUUID();
        var address = new Address("Av. Pretty Lisbon", "Lisbon", "Lisbon", "12345-678");
        var immutableCustomer = new ImmutableCustomer(id, "Lucas", address, false);

        var activatedCustomer = immutableCustomer.activate();

        assertAll(
                () -> assertEquals(immutableCustomer.id(), activatedCustomer.id()),
                () -> assertEquals(immutableCustomer.name(), activatedCustomer.name()),
                () -> assertEquals(immutableCustomer.address(), activatedCustomer.address()),
                () -> assertTrue(activatedCustomer.active())
        );
    }
}