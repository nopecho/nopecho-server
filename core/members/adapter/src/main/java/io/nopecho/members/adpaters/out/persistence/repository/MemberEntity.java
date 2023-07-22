package io.nopecho.members.adpaters.out.persistence.repository;

import io.nopecho.members.domain.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String countryCode;
    private final Boolean isAgreeMarketing;

    @CreatedDate
    private final LocalDateTime createdAt;
    @LastModifiedDate
    private final LocalDateTime modifiedAt;
    @Version
    private final Long version;

    public static MemberEntity from(Member member) {
        return new MemberEntity(
                member.getId().get(),
                member.getName().getValue(),
                member.getEmail().getValue(),
                member.getPhoneNumber().getPhoneNumber(),
                member.getPhoneNumber().getCountryCode(),
                member.getAgreement().isMarketing(),
                null,
                null,
                null
        );
    }

    public Member toDomain() {
        return Member.of(
                MemberId.of(this.id),
                Name.of(this.name),
                Email.of(this.email),
                PhoneNumber.of(this.phoneNumber, this.countryCode),
                Agreement.of(this.isAgreeMarketing));
    }
}
