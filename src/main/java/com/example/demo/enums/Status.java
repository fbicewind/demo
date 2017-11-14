package com.example.demo.enums;

public enum Status {

    SUCCESS("1", "成功"),
    FAILURE("0", "失败");

    private String code;
    private String codeName;

    Status(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    public String getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }
}
