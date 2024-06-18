package com.example.demo.dto.retail;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class RetailDepositRequest extends FirmCommonData {
    @Schema(description = "송금 개별부 데이터")
    @JsonProperty(required = true)
    private List<RetailDepositRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<RetailDepositRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<RetailDepositRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
