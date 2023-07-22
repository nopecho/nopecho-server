package io.nopecho.members.services.ports.out;


import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;

public interface QueryMemberPort {

    Member findByEmail(Email email);

    boolean isExistEmail(Email email);
}
