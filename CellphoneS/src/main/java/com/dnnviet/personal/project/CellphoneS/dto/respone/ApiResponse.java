package com.dnnviet.personal.project.CellphoneS.dto.respone;

import com.dnnviet.personal.project.CellphoneS.enums.ApiStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private int code;

    private String message;

    private ApiStatus status;

    private T data;
}
