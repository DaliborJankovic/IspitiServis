package DaliborJankovic.StudentskiServisZaOrganizacijuIspita.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = ".*@.*")
public @interface Email {

    String message() default "email must contain the @ character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
