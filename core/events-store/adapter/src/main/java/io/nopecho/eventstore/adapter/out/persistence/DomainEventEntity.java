package io.nopecho.eventstore.adapter.out.persistence;

import io.nopecho.utils.Serializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Map;

@Table("events")
@Getter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainEventEntity {

    @Id
    private Long id;
    private String type;
    private Map<String, Object> payload;
    private LocalDateTime occurredAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    @Version
    private Long version;

    public static DomainEventEntity create(Long id, String type, Object payload, LocalDateTime occurredAt) {
        Map<String, Object> stringObjectMap = Serializer.convertMap(payload);
        return new DomainEventEntity(id, type, stringObjectMap, occurredAt, LocalDateTime.now(), LocalDateTime.now(), null);
    }
}
