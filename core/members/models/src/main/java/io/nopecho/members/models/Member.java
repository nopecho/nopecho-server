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
    @With
    private final PhoneNumber phoneNumber;
    @With
    private final Agreement agreement;

    public static Member of(MemberId id, Name name, Email email, PhoneNumber phoneNumber, Agreement agreement) {
        return new Member(id, name, email, phoneNumber, agreement);
    }

    public static Member of(MemberId id, Name name, Email email, PhoneNumber phoneNumber) {
        Agreement disagreement = Agreement.falseAll();
        return new Member(id, name, email, phoneNumber, disagreement);
    }

    public static Member create(Name name, Email email, PhoneNumber phoneNumber, Agreement agreement) {
        return new Member(MemberId.of(LongIdGenerator.gen()), name, email, phoneNumber, agreement);
    }

    public static Member create(Name name, Email email, PhoneNumber phoneNumber) {
        Agreement disagreement = Agreement.falseAll();
        return new Member(MemberId.of(LongIdGenerator.gen()), name, email, phoneNumber, disagreement);
    }

    public Member change(Name name) {
        return this.withName(name);
    }

    public Member change(Email email) {
        return this.withEmail(email);
    }

    public Member change(PhoneNumber phoneNumber) {
        return this.withPhoneNumber(phoneNumber);
    }

    public Member change(Name name, Email email, PhoneNumber phoneNumber) {
        return this.change(name)
                .change(email)
                .change(phoneNumber);
    }

    public Member agreeMarketing() {
        Agreement agreeMarketing = this.agreement.agreeMarketing();
        return this.withAgreement(agreeMarketing);
    }

    public Member disagreeMarketing() {
        Agreement disagreeMarketing = this.agreement.disagreeMarketing();
        return this.withAgreement(disagreeMarketing);
    }
}