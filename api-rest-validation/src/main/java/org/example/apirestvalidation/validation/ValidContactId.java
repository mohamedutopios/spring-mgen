package org.example.apirestvalidation.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ContactIdValidator.class)
public @interface ValidContactId {
    String message() default "Invalid contact ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
