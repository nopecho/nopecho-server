package io.nopecho.members.adpaters.out.persistence;

import io.nopecho.members.adpaters.out.persistence.repository.MemberJdbcRepository;
import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;
import io.nopecho.members.services.ports.out.LoadMemberPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberQueryPersistAdapter implements LoadMemberPort {

    private final MemberJdbcRepository repository;

    @Override
    public Member loadByEmail(Email email) {
        return repository.findByEmail(email.getValue())
                .orElseThrow(NoSuchElementException::new)
                .toDomain();
    }

    @Override
    public boolean isExistEmail(Email email) {
        return repository.existsByEmail(email.getValue());
    }
}
