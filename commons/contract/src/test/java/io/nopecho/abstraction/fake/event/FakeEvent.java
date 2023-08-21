package io.nopecho.abstraction.fake.event;

import io.nopecho.event.EventPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakeEvent implements EventPayload {

    private String fake;

    public static FakeEvent of(String fake) {
        return new FakeEvent(fake);
    }
}
