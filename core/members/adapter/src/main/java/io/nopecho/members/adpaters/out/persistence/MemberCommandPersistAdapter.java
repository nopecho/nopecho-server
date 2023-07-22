package io.nopecho.members.adpaters.out.persistence;

import io.nopecho.members.adpaters.out.persistence.repository.MemberEntity;
import io.nopecho.members.adpaters.out.persistence.repository.MemberJdbcRepository;
import io.nopecho.members.domain.Member;
import io.nopecho.members.services.ports.out.SaveMemberPort;
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
