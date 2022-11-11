package io.github.giger85.example;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.jackson.extensions.converters.JSONBtoJacksonConverter;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

import static io.github.giger85.example.Tables.BAR;
import static io.github.giger85.example.Tables.FOO;
import static org.jooq.impl.DSL.field;

@Repository
public class DefaultBarRepository implements BarRepository {
    private static final Field<Object> FIXED_JSON_ARRAY_DATA = field("json_array_data");
    private static final JSONBtoJacksonConverter<BarInfo[]> FIXED_CONVERTER = new JSONBtoJacksonConverter<>(BarInfo[].class);
    private static final RecordMapper<Record, BarEntity> RECORD_MAPPER = record -> {
        Long id = record.getValue(FOO.ID);
        String name = record.getValue(FOO.NAME);
        BarInfo[] jsonArrayData = record.getValue("json_array_data", FIXED_CONVERTER);
        OffsetDateTime createdAt = record.getValue(FOO.CREATED_AT);

        return new BarEntity(id, name, jsonArrayData, createdAt);
    };
    private final DSLContext create;

    public DefaultBarRepository(DSLContext create) {
        this.create = create;
    }

    @Override
    public BarEntity findById(long id) {
        // TODO: Record bar = create.select(BAR.ID, BAR.NAME, BAR.JSON_ARRAY_DATA, BAR.CREATED_AT)
        Record bar = create.select(BAR.ID, BAR.NAME, FIXED_JSON_ARRAY_DATA, BAR.CREATED_AT)
                .from(BAR)
                .where(BAR.ID.eq(id))
                .fetchOne();

        if (bar == null) {
            return null;
        }

        return bar.map(RECORD_MAPPER);
    }

}