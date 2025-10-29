package com.dnnviet.personal.project.CellphoneS.enums;


import lombok.Getter;


@Getter
public enum ErrorCode {

    USER_EXISTED( 1001, "User existed"),
    USER_NOT_FOUND( 1002, "User Not Found"),
    UNAUTHENTICATED(1003, "Unauthenticated");

    private final int code;

    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
