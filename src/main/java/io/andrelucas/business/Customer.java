package io.andrelucas.business;

import java.util.UUID;

public class Customer {
    private final UUID id;
    private String name;
    private String address;

    private Boolean active;

    public Customer(UUID id,
                    String name,
                    String address,
                    Boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.active = active;

        validate();
    }

    void validate(){
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void changeName(String name){
        this.name = name;

        validate();
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

    public void activate(){
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be empty");
        }

        active = true;
    }
    public void desactivate(){
        active = false;
    }
    public boolean isActive() {
        return active;
    }
}
