package io.github.giger85.example;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
class BarRepositoryIntegrationTests {
    private final BarRepository barRepository;

    BarRepositoryIntegrationTests(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    @Test
    void testFindById() {
        // Given
        long id = 2L;
        // When
        BarEntity barEntity = barRepository.findById(id);
        // Then
        assertThat(barEntity).isNotNull();
        assertThat(barEntity.id()).as("Both ids should be same.").isEqualTo(id);
        assertThat(barEntity.name()).isEqualTo("bar user #2");
        assertThat(barEntity.jsonArrayData()).isNotNull();
        assertThat(barEntity.jsonArrayData()[0].key()).isEqualTo("firstKey");
        assertThat(barEntity.jsonArrayData()[0].value()).isEqualTo("firstValue");
    }

    @Test
    void testFindByIdError() {
        // Given
        long id = 2L;
        // When
        assertThatThrownBy(() -> barRepository.findByIdError(id))
                .isInstanceOf(DataAccessException.class)
                .rootCause()
                .isInstanceOf(MismatchedInputException.class);
    }
}
