package io.nopecho.members.models;

import io.nopecho.utils.LongIdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private final MemberId id;
    @With
    private final Name name;
    @With
    private final Email email;


    public static Member from(MemberId id, Name name, Email email) {
        return new Member(id, name, email);
    }

    public static Member createFrom(Name name, Email email) {
        return new Member(MemberId.of(LongIdGenerator.gen()), name, email);
    }
}
