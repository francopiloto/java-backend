package demo.server.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.server.utils.JsonBuilder;

@Service
public class ValidationService
{
    @Autowired private Validator validator;

/* --------------------------------------------------------------------------------------------- */

    public String validate(Object target)
    {
        Set<ConstraintViolation<Object>> errors = validator.validate(target);

        if (errors != null && errors.size() > 0)
        {
            JsonBuilder builder = new JsonBuilder();

            for (ConstraintViolation<Object> error : errors)
            {
                builder.add(error.getPropertyPath(),
                        error.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName());
            }

            return builder.build();
        }

        return null;
    }

/* --------------------------------------------------------------------------------------------- */

}
