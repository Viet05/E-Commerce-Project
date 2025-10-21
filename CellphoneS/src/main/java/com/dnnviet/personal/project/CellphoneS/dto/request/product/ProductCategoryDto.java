package com.dnnviet.personal.project.CellphoneS.dto.request.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategoryDto {

    private Long productCategoryId;

    private String productCategoryName;

    private String note;

    private Long productId;
}
