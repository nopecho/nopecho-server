package io.nopecho.members.services.ports.out;


import io.nopecho.members.domain.Member;

public interface SaveMemberPort {

    Member save(Member member);
}
