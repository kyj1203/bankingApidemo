package com.example.demo.dto.retail;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class RetailTransferRequest extends FirmCommonData {
    @Schema(description = "이체결과조회(단건조회) 개별부 데이터")
    @JsonProperty(required = true)
    private List<RetailTransferRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<RetailTransferRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<RetailTransferRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}