package com.example.demo.dto.firmbanking;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class FirmAccountNameRequestData {
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
    @Schema(description = "FCS 대행 사용여부 1byte")
    private String agencyYn;
    @Schema(description = "조회계좌 은행코드 3byte")
    @JsonProperty(required = true)
    private String accountBankCode;
    @Schema(description = "계좌번호 15byte")
    @JsonProperty(required = true)
    private String accountNo;
    @Schema(description = "실명번호 13byte<br/>*실명번호 일치여부는 당행만 가능")
    @JsonProperty(required = true)
    private String socialId;
    @Schema(description = "금액 13byte<br/>가상계좌 조회시 사용 (외환, 농협, 우리, 씨티)")
    @JsonProperty(required = true)
    private String amount;

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getAgencyYn() {
        return agencyYn;
    }

    public void setAgencyYn(String agencyYn) {
        this.agencyYn = agencyYn;
    }

    public String getAccountBankCode() {
        return accountBankCode;
    }

    public void setAccountBankCode(String accountBankCode) {
        this.accountBankCode = accountBankCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
