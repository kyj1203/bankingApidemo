package com.example.demo.dto.retail;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class RetailTransferRequestData {
    @Schema(description = "은행에서 부여한 업체별코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드(계약은행) 3byte")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "거래일자 8byte<br/>YYYYMMDD")
    @JsonProperty(required = true)
    private String inquiryDate;
    @Schema(description = "일련번호 (000001부터 순차증가(전업무 공통) 매일 00시 000001로 초기화) 6byte<br/>6자리, 좌측 0패딩")
    @JsonProperty(required = true)
    private String seqNo;
    @Schema(description = "원거래일련번호 6byte<br/>6자리, 좌측 0패딩")
    @JsonProperty(required = true)
    private String oriSeqNo;

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

    public String getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getOriSeqNo() {
        return oriSeqNo;
    }

    public void setOriSeqNo(String oriSeqNo) {
        this.oriSeqNo = oriSeqNo;
    }
}
