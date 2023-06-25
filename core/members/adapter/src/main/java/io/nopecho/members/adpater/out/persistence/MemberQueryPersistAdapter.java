package io.nopecho.members.adpater.out.persistence;

import io.nopecho.members.adpater.out.persistence.repository.MemberJdbcRepository;
import io.nopecho.members.application.port.out.QueryMemberPort;
import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberQueryPersistAdapter implements QueryMemberPort {

    private final MemberJdbcRepository repository;

    @Override
    public Member findByEmail(Email email) {
        return repository.findByEmail(email.get())
                .orElseThrow(NoSuchElementException::new)
                .toDomain();
    }
}
