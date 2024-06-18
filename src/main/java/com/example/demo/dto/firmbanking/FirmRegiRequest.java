package com.example.demo.dto.firmbanking;

import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FirmRegiRequest extends FirmCommonData {
    @Schema(description = "출금계좌등록, 해지 데이터")
    @JsonProperty(required = true)
    private List<FirmRegiRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<FirmRegiRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<FirmRegiRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
