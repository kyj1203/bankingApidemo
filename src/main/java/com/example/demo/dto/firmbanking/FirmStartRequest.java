package com.example.demo.dto.firmbanking;
import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FirmStartRequest extends FirmCommonData {
    @Schema(description = "개시업무 개별부 데이터")
    @JsonProperty(required = true)
    private List<FirmStartRequestData> reqdata;

    // Other fields and their getters and setters

    // Getters and Setters for reqdata
    public List<FirmStartRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<FirmStartRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
