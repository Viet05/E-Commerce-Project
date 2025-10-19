package com.dnnviet.personal.project.CellphoneS.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class StockIdKey {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "product_id")
    private Long productId;
}
