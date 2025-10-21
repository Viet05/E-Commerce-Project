package com.dnnviet.personal.project.CellphoneS.dto.request.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Brand;
import com.dnnviet.personal.project.CellphoneS.entities.product.OrderDetail;
import com.dnnviet.personal.project.CellphoneS.entities.product.ProductCategory;
import com.dnnviet.personal.project.CellphoneS.entities.store.Stock;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    private Long productId;

    private String productName;

    private String description;

    private String unit;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    private Boolean isActive = true;

    private String windowImage;

    private String webImage;

    private String color;

    private String memory;

    private String size;

    private LocalDateTime releaseDate;

    private Long brandId;

    private Long productTypeId;

    private Long orderDetailIds;

    private Long stockIds;
}

