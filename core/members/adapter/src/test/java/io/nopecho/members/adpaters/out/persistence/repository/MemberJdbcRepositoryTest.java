package io.nopecho.members.adpaters.out.persistence.repository;

import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;
import io.nopecho.members.domain.Name;
import io.nopecho.members.domain.PhoneNumber;
import io.nopecho.utils.Serializer;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@AutoConfigureEmbeddedDatabase(type = POSTGRES)
@SpringJUnitConfig(classes = TestJdbcConfig.class)
@Sql(scripts = "classpath:ddl.sql")
class MemberJdbcRepositoryTest {

    @Autowired
    MemberJdbcRepository memberJdbcRepository;

    @Test
    void save() {
        Member member = Member.create(
                Name.of("조현준"),
                Email.of("ch.jooon@gmail.com"),
                PhoneNumber.ofKorea("01012345678"));
        MemberEntity entity = MemberEntity.from(member);

        memberJdbcRepository.save(entity);
        MemberEntity findEntity = memberJdbcRepository.findByEmail("ch.jooon@gmail.com")
                .orElseThrow();
        System.out.println(Serializer.serialize(findEntity));

        assertThat(findEntity.getName()).isEqualTo("조현준");
    }
}