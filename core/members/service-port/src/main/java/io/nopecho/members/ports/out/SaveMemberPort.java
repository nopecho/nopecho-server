package io.nopecho.members.ports.out;

import io.nopecho.members.models.Member;

public interface SaveMemberPort {

    Member save(Member member);
}
