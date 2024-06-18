package com.example.demo.dto.firmbanking;
import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FirmBalanceRequest extends FirmCommonData {
    @Schema(description = "잔액조회 개별부 데이터")
    @JsonProperty(required = true)
    private List<FirmBalanceRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<FirmBalanceRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<FirmBalanceRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
