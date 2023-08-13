package io.nopecho.members.domain;

import io.nopecho.domain.ValueObject;
import io.nopecho.utils.SelfValidator;
import io.nopecho.utils.Throws;
import lombok.Getter;

import java.util.Objects;

@Getter
public class PhoneNumber implements ValueObject<String>, SelfValidator {

    private final String phoneNumber;
    private final String countryCode;

    private PhoneNumber(String phoneNumber, String countryCode) {
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.selfValidation();
    }

    public static PhoneNumber of(String phoneNumber, String countryCode) {
        String code = Objects.requireNonNullElse(countryCode, "+82");
        return new PhoneNumber(phoneNumber, code);
    }

    public static PhoneNumber ofKorea(String phoneNumber) {
        return new PhoneNumber(phoneNumber, "+82");
    }

    @Override
    public String getValue() {
        return String.format("%s%s", this.countryCode, this.phoneNumber);
    }

    @Override
    public void selfValidation() {
        Throws.ifNullOrBlank(this.phoneNumber, "phone number must be not null or empty");
        Throws.ifNullOrBlank(this.countryCode, "country code must be not null or empty");
    }
}
