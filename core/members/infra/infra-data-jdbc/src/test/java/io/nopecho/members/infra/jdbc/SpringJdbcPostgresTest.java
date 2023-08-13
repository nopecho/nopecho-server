package io.nopecho.members.infra.jdbc;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Transactional
@AutoConfigureEmbeddedDatabase(type = POSTGRES)
public @interface SpringJdbcPostgresTest {
}
