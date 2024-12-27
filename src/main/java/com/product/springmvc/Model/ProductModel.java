package com.product.springmvc.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductModel {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Brand cannot be blank")
    private String brand;

    @NotBlank(message = "Made In cannot be blank")
    private String madeIn;

    @Positive(message = "Price must be greater than zero")
    private double price;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    
    @DecimalMax(value = "100.0", inclusive = true, message = "Discount rate cannot exceed 1.0")
    private double discountRate;
}

