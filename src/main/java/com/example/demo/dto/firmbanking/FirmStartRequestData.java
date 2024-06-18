package com.example.demo.dto.firmbanking;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class FirmStartRequestData{
    @Schema(description = "요청날짜 8byte")
    @JsonProperty(required = true)
    private String date;
    @Schema(description = "요청시간 6byte")
    @JsonProperty(required = true)
    private String time;
    @Schema(description = "은행에서 부여한 업체별 코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드(계약은행) 3byte")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "일련번호 6byte")
    @JsonProperty(required = true)
    private String seqNo;


    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }
}
