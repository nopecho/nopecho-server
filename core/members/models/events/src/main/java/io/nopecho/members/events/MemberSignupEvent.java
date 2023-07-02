package io.nopecho.members.events;

import io.nopecho.event.EventPayload;
import io.nopecho.members.models.Member;
import lombok.Getter;

@Getter
public class MemberSignupEvent implements EventPayload {

    private final String id;
    private final String name;
    private final String email;

    private MemberSignupEvent(Member member) {
        this.id = member.getId().get().toString();
        this.name = member.getName().getValue();
        this.email = member.getEmail().getValue();
    }

    public static MemberSignupEvent from(Member member) {
        return new MemberSignupEvent(member);
    }
}
