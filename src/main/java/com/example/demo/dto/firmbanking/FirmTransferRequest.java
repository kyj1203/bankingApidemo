package com.example.demo.dto.firmbanking;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FirmTransferRequest extends FirmCommonData {
    @Schema(description = "이체결과조회 개별부 데이터")
    @JsonProperty(required = true)
    private List<FirmTransferRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<FirmTransferRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<FirmTransferRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
