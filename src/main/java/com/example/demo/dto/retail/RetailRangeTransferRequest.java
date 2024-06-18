package com.example.demo.dto.retail;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class RetailRangeTransferRequest extends FirmCommonData {
    @Schema(description = "이체결과조회(기간조회) 개별부 데이터")
    @JsonProperty(required = true)
    private List<RetailRangeTransferRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<RetailRangeTransferRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<RetailRangeTransferRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
