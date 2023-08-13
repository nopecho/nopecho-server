package io.nopecho.members.infra.jdbc;

import io.nopecho.members.application.ports.SaveMemberPort;
import io.nopecho.members.domain.Member;
import io.nopecho.members.infra.jdbc.entity.MemberEntity;
import io.nopecho.members.infra.jdbc.repository.MemberJdbcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberCommandPersistAdapter implements SaveMemberPort {

    private final MemberJdbcRepository repository;

    @Override
    public Member save(Member member) {
        MemberEntity entity = MemberEntity.from(member);
        return repository.save(entity)
                .toDomain();
    }
}
