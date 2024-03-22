package io.andrelucas.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void shouldThrowExceptionWhenStreetIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Address("", "Lisbon", "Lisbon", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenCityIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Address("Av. Pretty Lisbon", "", "Lisbon", "12345-678"));
    }

    @Test
    void shouldThrowExceptionWhenStateIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Address("Av. Pretty Lisbon", "Lisbon", "", "12345-678"));
    }
}