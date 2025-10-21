package com.dnnviet.personal.project.CellphoneS.dto.request.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.OrderDetail;
import com.dnnviet.personal.project.CellphoneS.entities.store.Area;
import com.dnnviet.personal.project.CellphoneS.entities.user.Customer;
import com.dnnviet.personal.project.CellphoneS.entities.user.Expertise;
import com.dnnviet.personal.project.CellphoneS.entities.user.Staff;
import com.dnnviet.personal.project.CellphoneS.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private Long orderId;

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    private Customer customer;

    private Long orderDetailIds;

    private Long areaId;

    private Long staffId;

    private Long expertiseId;

    private String deliveryAddress;

    private String note;

    private String status;
}
