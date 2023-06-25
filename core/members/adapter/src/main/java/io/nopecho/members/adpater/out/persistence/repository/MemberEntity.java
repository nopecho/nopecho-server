package io.nopecho.members.adpater.out.persistence.repository;

import io.nopecho.members.domain.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("members")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

    @Id
    private final Long id;
    @With
    private final String name;
    @With
    private final String email;

    private final Role role;
    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;
    @Version
    private final Long version;

    public static MemberEntity from(Member member) {
        return new MemberEntity(
                member.getId().get(),
                member.getName().get(),
                member.getEmail().get(),
                member.getRole(),
                null,
                null,
                null
        );
    }

    public Member toDomain() {
        return Member.from(
                MemberId.of(this.id),
                Name.of(this.name),
                Email.of(this.email),
                LoginMethods.from(LoginMethod.from(OauthMethod.NONE, LoginToken.of("test"))),
                this.role
        );
    }
}
