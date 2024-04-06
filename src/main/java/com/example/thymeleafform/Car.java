package com.example.thymeleafform;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    @NotNull(message = "Make is required")
    String model;
    @NotNull(message = "Year is required")
    int year;
}
