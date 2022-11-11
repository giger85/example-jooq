package io.github.giger85.example;

import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {
    @Bean
    public Settings jooqSettings() {
        return new Settings()
                .withRenderSchema(false)
                .withRenderQuotedNames(RenderQuotedNames.NEVER)
                .withInListPadding(true)
                .withInListPadBase(4);
    }
}
