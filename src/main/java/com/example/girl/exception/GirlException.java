package com.example.girl.exception;

import com.example.girl.enums.ResultEnums;

public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
