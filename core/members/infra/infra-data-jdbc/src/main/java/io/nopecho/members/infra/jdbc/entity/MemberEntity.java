package io.nopecho.members.infra.jdbc.entity;

import io.nopecho.members.domain.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Table("members")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

    @Id
    private final Long id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String countryCode;
    private final Boolean isAgreeMarketing;
    private final Grade grade;
    @MappedCollection(idColumn = "member_id")
    private final Set<RoleEntity> roles;

    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;
    @Version
    private final Long version;

    public static MemberEntity from(Member member) {
        Set<RoleEntity> roleEntities = roleForm(member);
        return new MemberEntity(
                member.getId().get(),
                member.getName().getValue(),
                member.getEmail().getValue(),
                member.getPhoneNumber().getPhoneNumber(),
                member.getPhoneNumber().getCountryCode(),
                member.getAgreement().isMarketing(),
                member.getGrade(),
                roleEntities,
                null,
                null,
                null
        );
    }

    public MemberEntity modify(Member member) {
        Set<RoleEntity> roleEntities = roleForm(member);
        return new MemberEntity(
                member.getId().get(),
                member.getName().getValue(),
                member.getEmail().getValue(),
                member.getPhoneNumber().getPhoneNumber(),
                member.getPhoneNumber().getCountryCode(),
                member.getAgreement().isMarketing(),
                member.getGrade(),
                roleEntities,
                null,
                null,
                this.version
        );
    }

    private static Set<RoleEntity> roleForm(Member member) {
        return member.getRoles().stream()
                .map(RoleEntity::from)
                .collect(Collectors.toSet());
    }

    public Member toDomain() {
        return Member.of(
                MemberId.of(this.id),
                Name.of(this.name),
                Email.of(this.email),
                PhoneNumber.of(this.phoneNumber, this.countryCode),
                this.grade,
                rolesOf(),
                Agreement.of(this.isAgreeMarketing));
    }

    private Roles rolesOf() {
        Set<Role> roleSet = this.roles.stream()
                .map(RoleEntity::getRole)
                .collect(Collectors.toSet());
        return Roles.from(roleSet);
    }
}
