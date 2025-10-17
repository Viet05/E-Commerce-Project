package com.dnnviet.personal.project.CellphoneS.dto.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductDTO {

    Long productId;
    String name;
    String description;
    BigDecimal price;
    int stockQuantity;
    String brand;
    Category category;

}
