package com.dnnviet.personal.project.CellphoneS.dto.request.store;

import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import com.dnnviet.personal.project.CellphoneS.entities.store.StockIdKey;
import com.dnnviet.personal.project.CellphoneS.entities.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDto {

    private Long stockId;

    private Long storeId;

    private Long productId;

    private Integer quantity;

    private Integer minStockLevel;

    private LocalDateTime lastUpdated;
}
