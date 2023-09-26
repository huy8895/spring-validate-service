package com.example.orderservice.validation;

import com.example.orderservice.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomValidationValidator implements ConstraintValidator<CustomValidation, String> {

    @Override
    public void initialize(CustomValidation constraintAnnotation) {
        // Không cần thiết phải khởi tạo gì đó ở đây
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        // Thực hiện kiểm tra tùy chỉnh tại đây và trả về true nếu hợp lệ, false nếu không hợp lệ
        // Ví dụ: Kiểm tra xem giá trị có phải là "example" hay không
        return "example".equals(value);
    }
}
