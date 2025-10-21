package com.dnnviet.personal.project.CellphoneS.dto.request.store;

import com.dnnviet.personal.project.CellphoneS.entities.store.Area;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
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
public class StoreDto {

    private Long storeId;

    private String storeName;

    private String address;

    private String phone;

    private int capacity;

    private Long area;

    private String stillEmpty;
}
