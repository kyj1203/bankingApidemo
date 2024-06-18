package com.example.demo.dto.retail;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class RetailAccountNameRequestData {
    @Schema(description = "은행에서 부여한 업체별코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드 (계약은행) 3byte \"099입력\" ")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "일련번호 6byte 좌측 0패딩")
    @JsonProperty(required = true)
    private String seqNo;
    @Schema(description = "업체 모계좌 가상계좌 정보 20byte *PG타입 송금대행 이용시 필수")
    @JsonProperty(required = true)
    private String compAccountNo;
    @Schema(description = "조회계좌 은행코드 3byte")
    @JsonProperty(required = true)
    private String accountBankCode;
    @Schema(description = "조회계좌 계좌번호 15byte")
    @JsonProperty(required = true)
    private String accountNo;
    @Schema(description = "실명번호(생년월일, 사업자번호 등) 13byte 계약협의필요")
    private String socialId;
    @Schema(description = "금액 13byte 가상계좌 조회시 사용(외환,농렵,우리,씨티) ")
    private String amount;

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

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getCompAccountNo() {
        return compAccountNo;
    }

    public void setCompAccountNo(String compAccountNo) {
        this.compAccountNo = compAccountNo;
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
