package io.github.giger85.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
class FooRepositoryIntegrationTests {
    private final FooRepository fooRepository;

    FooRepositoryIntegrationTests(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Test
    void testFindById() {
        // Given
        long id = 1L;
        // When
        FooEntity fooEntity = fooRepository.findById(id);
        // Then
        assertThat(fooEntity).isNotNull();
        assertThat(fooEntity.id()).as("Both ids should be same.").isEqualTo(id);
        assertThat(fooEntity.name()).isEqualTo("foo user #1");
        assertThat(fooEntity.jsonData()).isNotNull();
        assertThat(fooEntity.jsonData().age()).isEqualTo(38);
    }
}
