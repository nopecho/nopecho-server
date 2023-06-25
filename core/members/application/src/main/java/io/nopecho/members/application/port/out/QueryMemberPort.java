package io.nopecho.members.application.port.out;

import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;

public interface QueryMemberPort {

    Member findByEmail(Email email);
}
