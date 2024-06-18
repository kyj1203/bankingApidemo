package com.example.demo.dto.retail;
import com.example.demo.dto.FirmCommonData;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class RetailAccountNameRequest extends FirmCommonData {
    @Schema(description = "고객계좌 성명조회 개별부 데이터")
    @JsonProperty(required = true)
    private List<RetailAccountNameRequestData> reqdata;

    // Getters and Setters
    public List<RetailAccountNameRequestData> getReqdata() {
        return reqdata;
    }

    public void setReqdata(List<RetailAccountNameRequestData> reqdata) {
        this.reqdata = reqdata;
    }
}
