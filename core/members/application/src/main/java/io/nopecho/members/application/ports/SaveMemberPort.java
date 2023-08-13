package io.nopecho.members.application.ports;


import io.nopecho.members.domain.Member;

public interface SaveMemberPort {

    Member save(Member member);
}
