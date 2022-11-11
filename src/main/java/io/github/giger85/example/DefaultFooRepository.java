package io.github.giger85.example;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import static io.github.giger85.example.Tables.FOO;

@Repository
public class DefaultFooRepository implements FooRepository {
    private final DSLContext create;

    public DefaultFooRepository(DSLContext create) {
        this.create = create;
    }

    @Override
    public FooEntity findById(long id) {
        Record foo = create.select(FOO.ID, FOO.NAME, FOO.CREATED_AT)
                .from(FOO)
                .where(FOO.ID.eq(id))
                .fetchOne();

        if (foo == null) {
            return null;
        }

        return foo.into(FooEntity.class);
    }
}
