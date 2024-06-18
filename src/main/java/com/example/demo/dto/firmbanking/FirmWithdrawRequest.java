package com.example.demo.dto.firmbanking;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FirmWithdrawRequest extends FirmCommonData {
    @Schema(description = "출금 개별부 데이터")
    @JsonProperty(required = true)
    private List<FirmWithdrawRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<FirmWithdrawRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<FirmWithdrawRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
