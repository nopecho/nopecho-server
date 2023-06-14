package io.nopecho.event.transaction.annotaion;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public @interface OrchestratorService {
}
