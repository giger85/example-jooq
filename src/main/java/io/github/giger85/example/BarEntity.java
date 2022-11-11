package io.github.giger85.example;


import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record BarEntity(
        @NotNull Long id,
        @NotNull String name,
        BarInfo[] jsonArrayData,
        @NotNull OffsetDateTime createdAt
) {
}
