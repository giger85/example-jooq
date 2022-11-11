package io.github.giger85.example;

public interface BarRepository {
    BarEntity findById(long id);
    BarEntity findByIdError(long id);
}
