package io.nopecho.members.adpaters.out.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberJdbcRepository extends CrudRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
