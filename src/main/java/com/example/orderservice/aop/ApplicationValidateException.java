package com.example.orderservice.aop;

import com.example.orderservice.exception.ErrorDto;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

public class ApplicationValidateException extends RuntimeException {
    private List<ErrorDto.ErrorDetails> detailsList;
    public ApplicationValidateException(Set<ConstraintViolation<Object>> validate) {
        final var list = validate.stream()
                                 .map(e -> ErrorDto.ErrorDetails.builder()
                                                            .message(e.getMessage())
                                                            .fieldName(e.getPropertyPath()
                                                                         .toString()).build())
                                 .toList();

        this.detailsList = list;
    }

    public List<ErrorDto.ErrorDetails> getDetailsList() {
        return detailsList;
    }
}
