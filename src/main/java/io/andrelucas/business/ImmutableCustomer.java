package io.andrelucas.business;

import java.util.UUID;

public record ImmutableCustomer(UUID id,
                                String name,
                                Address address,
                                boolean active) {

    public ImmutableCustomer {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public ImmutableCustomer changeName(String name){
        return new ImmutableCustomer(this.id, name, this.address, this.active);
    }

    public ImmutableCustomer activate() {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be empty");
        }

        return new ImmutableCustomer(this.id, this.name, this.address, true);
    }
}
