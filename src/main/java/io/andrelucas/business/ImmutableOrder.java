package io.andrelucas.business;

import java.util.UUID;

public record ImmutableOrder(UUID id, String description, double price) {
}
