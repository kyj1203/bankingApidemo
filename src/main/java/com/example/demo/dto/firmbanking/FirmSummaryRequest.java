package com.example.demo.dto.firmbanking;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FirmSummaryRequest extends FirmCommonData {
    @Schema(description = "집계조회 개별부 데이터")
    @JsonProperty(required = true)
    private List<FirmSummaryRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<FirmSummaryRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<FirmSummaryRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
