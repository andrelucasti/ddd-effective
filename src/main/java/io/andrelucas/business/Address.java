package io.andrelucas.business;

public record Address(String street,
                      String city,
                      String state,
                      String zipCode) {

    public Address {
        if (street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be empty");
        }

        if (city.isBlank()) {
            throw new IllegalArgumentException("City cannot be empty");
        }

        if (state.isBlank()) {
            throw new IllegalArgumentException("State cannot be empty");
        }
    }
}
