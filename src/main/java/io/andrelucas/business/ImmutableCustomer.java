package io.andrelucas.business;

import java.util.UUID;

public record ImmutableCustomer(UUID id,
                                String name,
                                String address) {

    public ImmutableCustomer changeName(String name){
        return new ImmutableCustomer(this.id, name, this.address);
    }
}
