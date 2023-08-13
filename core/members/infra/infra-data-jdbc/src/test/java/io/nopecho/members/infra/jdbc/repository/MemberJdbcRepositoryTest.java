package io.nopecho.members.infra.jdbc.repository;

import io.nopecho.members.domain.*;
import io.nopecho.members.infra.jdbc.EmbeddedPostgresConfiguration;
import io.nopecho.members.infra.jdbc.SpringJdbcPostgresTest;
import io.nopecho.members.infra.jdbc.entity.MemberEntity;
import io.nopecho.utils.Serializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringJdbcPostgresTest
@SpringJUnitConfig(classes = {DataJdbcConfig.class, EmbeddedPostgresConfiguration.class})
@Sql("classpath:ddl.sql")
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

    @Test
    void update() {
        Member member = Member.create(
                Name.of("조현준"),
                Email.of("ch.jooon@gmail.com"),
                PhoneNumber.ofKorea("01012345678"));
        MemberEntity entity = MemberEntity.from(member);
        memberJdbcRepository.save(entity);

        MemberEntity findEntity = memberJdbcRepository.findById(member.getId().get())
                .orElseThrow();
        Member toDomain = findEntity.toDomain();

        Member added = toDomain.addRoles(Role.USER, Role.ADMIN);
        MemberEntity modify = findEntity.modify(added);
        memberJdbcRepository.save(modify);

        List<MemberEntity> members = memberJdbcRepository.findAll();

        assertThat(members.size()).isEqualTo(1);
        assertThat(members.get(0).getRoles().size()).isEqualTo(2);
    }
}