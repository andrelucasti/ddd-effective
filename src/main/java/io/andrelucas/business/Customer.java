package io.andrelucas.business;

import java.util.UUID;

public class Customer {
    private final UUID id;
    private String name;
    private String address;

    public Customer(UUID id,
                    String name,
                    String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void changeName(String name){
        this.name = name;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
