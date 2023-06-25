package io.nopecho.members.application.port.out;

import io.nopecho.members.domain.Member;

public interface SaveMemberPort {

    Member save(Member member);
}
