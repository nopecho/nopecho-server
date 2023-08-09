package io.nopecho.members.services.ports.out;


import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;

public interface LoadMemberPort {

    Member loadByEmail(Email email);

    boolean isExistEmail(Email email);
}
