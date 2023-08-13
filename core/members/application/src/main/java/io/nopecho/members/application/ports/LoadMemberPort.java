package io.nopecho.members.application.ports;


import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;

public interface LoadMemberPort {

    Member loadByEmail(Email email);

    boolean isExistEmail(Email email);
}
