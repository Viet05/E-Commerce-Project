package com.dnnviet.personal.project.CellphoneS.dto.request.store;

import com.dnnviet.personal.project.CellphoneS.entities.product.Order;
import com.dnnviet.personal.project.CellphoneS.entities.store.Store;
import com.dnnviet.personal.project.CellphoneS.entities.user.Staff;
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
public class AreaDto {


    private Long areaId;

    private String areaName;

    private Long staffId;

    private Long orderId;

    private Long storeId;
}
