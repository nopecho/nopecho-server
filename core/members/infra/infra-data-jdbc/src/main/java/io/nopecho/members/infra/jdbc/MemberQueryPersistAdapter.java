package io.nopecho.members.infra.jdbc;

import io.nopecho.members.application.ports.LoadMemberPort;
import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;
import io.nopecho.members.infra.jdbc.repository.MemberJdbcRepository;
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
