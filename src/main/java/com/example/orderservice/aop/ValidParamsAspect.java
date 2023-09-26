package com.example.orderservice.aop;

import com.example.orderservice.dto.HasSaveType;
import com.example.orderservice.dto.SaveAndContinue;
import com.example.orderservice.dto.SaveAndExit;
import com.example.orderservice.dto.SaveType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Set;

@Aspect
@Component
public class ValidParamsAspect {

    private final Validator validator;

    public ValidParamsAspect() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Before("@annotation(com.example.orderservice.aop.ValidParams)")
    public void validateParams(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof HasSaveType dto){
                final var saveType = dto.getSaveType();
                this.validate(saveType, arg);

            }
        }


        // Nếu tất cả tham số hợp lệ, tiếp tục thực hiện phương thức gốc

    }

    private void validate(SaveType saveType, Object dto) {

        switch (saveType){
            case SAVE_AND_EXIT -> getValidated(dto, SaveAndExit.class);
            case SAVE_AND_CONTINUE -> getValidated(dto, SaveAndContinue.class);
        }
    }

    private Set<ConstraintViolation<Object>> getValidated(Object dto, Class<?> saveAndContinueClass) {
        final var validate = validator.validate(dto, saveAndContinueClass);
        if (!validate.isEmpty()){
            throw new ApplicationValidateException(validate);
        }
        return validate;
    }


}
