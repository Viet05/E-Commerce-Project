package com.dnnviet.personal.project.CellphoneS.dto.request.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Order;
import com.dnnviet.personal.project.CellphoneS.entities.product.OrderDetailId;
import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailDto {

    private Long id;

    private Long orderId;

    private Long productId;

    private Long quantity;
}
