package com.example.thymeleafform;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyForm {
    @NotEmpty(message = "Name is required")
    String name;

    @NotNull(message = "Age is required")
    int age;

    List<Car> cars;
}
