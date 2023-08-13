package io.nopecho.members.infra.jdbc.repository;

import io.nopecho.members.infra.jdbc.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberJdbcRepository extends CrudRepository<MemberEntity, Long> {

    List<MemberEntity> findAll();

    Optional<MemberEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
