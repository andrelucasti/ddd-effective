package io.andrelucas.business;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldChangeTheName() {
        var uuid = UUID.randomUUID();
        var immutableCustomer = new ImmutableCustomer(uuid, "Lucas", "Av. Pretty Lisbon");

        var customerWithNewName = immutableCustomer.changeName("Andre");

        assertAll(
                () -> assertEquals(immutableCustomer.id(), customerWithNewName.id()),
                () -> assertNotEquals(immutableCustomer.name(), customerWithNewName.name()),
                () -> assertEquals("Andre", customerWithNewName.name()),
                () -> assertEquals(immutableCustomer.address(), customerWithNewName.address())
        );


        var id = UUID.randomUUID();
        var customer = new Customer(id, "Joey", "Av. California");

        customer.changeName("Corey");
        assertAll(
                () -> assertEquals(id, customer.getId()),
                () -> assertEquals("Corey", customer.getName()),
                () -> assertEquals("Av. California", customer.getAddress())
        );
    }
}