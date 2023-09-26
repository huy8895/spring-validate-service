package com.example.orderservice.dto;

import com.example.orderservice.validation.CustomValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements HasSaveType {
    private SaveType saveType;

    @NotBlank(groups = SaveAndContinue.class)
    private String name;

    @CustomValidation(groups = SaveAndExit.class)
    private String description;
}
