package org.example.apirestexception.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @NotNull(message="ID is Required")
    private Integer id;

    @NotBlank(message="Name is Required")
    private String name;

    @Min(value = 0, message = "Price must be positive")
    private Double price;


}
