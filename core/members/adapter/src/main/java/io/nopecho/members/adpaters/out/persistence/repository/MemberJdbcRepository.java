package io.nopecho.members.adpaters.out.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MemberJdbcRepository extends CrudRepository<MemberEntity, Long> {

    List<MemberEntity> findAll();

    List<MemberEntity> findAllById(Collection<Long> ids);

    Optional<MemberEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
