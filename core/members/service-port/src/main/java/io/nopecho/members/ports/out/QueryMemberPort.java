package io.nopecho.members.ports.out;

import io.nopecho.members.models.Email;
import io.nopecho.members.models.Member;

public interface QueryMemberPort {

    Member findByEmail(Email email);
}
