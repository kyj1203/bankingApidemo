package com.example.demo.dto.retail;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class RetailRangeTransferRequestData {
    @Schema(description = "은행에서 부여한 업체별 코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드(발급받은 가상계좌의 모계좌은행) 3byte <br/>은행코드 3자리")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "조회 시작 날짜 8byte<br/>YYYYMMDD")
    @JsonProperty(required = true)
    private String startDate;
    @Schema(description = "조회 종료 날짜 8byte<br/>YYYYMMDD")
    @JsonProperty(required = true)
    private String endDate;

    // Getters and Setters
    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
