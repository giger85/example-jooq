package io.github.giger85.example;


import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record FooEntity(
        @NotNull Long id,
        @NotNull String name,
        FooInfo jsonData,
        @NotNull OffsetDateTime createdAt
) {
}
