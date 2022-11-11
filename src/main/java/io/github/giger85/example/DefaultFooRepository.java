package io.github.giger85.example;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import static org.jooq.impl.DSL.field;

@Repository
public class DefaultFooRepository implements FooRepository {
    private final DSLContext create;

    public DefaultFooRepository(DSLContext create) {
        this.create = create;
    }

    @Override
    public FooEntity findById(long id) {
        Field<Long> idField = field("id", Long.class);

        Record foo = create.select()
                .from("foo")
                .where(idField.eq(id))
                .fetchOne();

        if (foo == null) {
            return null;
        }

        return foo.into(FooEntity.class);
    }
}
