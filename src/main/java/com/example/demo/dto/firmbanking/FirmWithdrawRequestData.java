package com.example.demo.dto.firmbanking;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class FirmWithdrawRequestData {
    @Schema(description = "요청날짜 8byte")
    @JsonProperty(required = true)
    private String date;
    @Schema(description = "요청시간 6byte")
    @JsonProperty(required = true)
    private String time;
    @Schema(description = "은행에서부여한 업체별 코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드 3byte")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "일련번호 6byte")
    @JsonProperty(required = true)
    private String seqNo;
    @Schema(description = "출금 계좌 번호 15byte")
    @JsonProperty(required = true)
    private String outAccount;
    @Schema(description = "통장 비밀번호 8byte")
    @JsonProperty(required = true)
    private String accountPasswd;
    @Schema(description = "복기부호 6byte")
    @JsonProperty(required = true)
    private String verificationKey;
    @Schema(description = "금액 13byte")
    @JsonProperty(required = true)
    private String amount;
    @Schema(description = "입금 계좌번호 15byte")
    @JsonProperty(required = true)
    private String inAccount;
    @Schema(description = "출금계좌 인자내역 20byte")
    @JsonProperty(required = true)
    private String outPrintContent;
    @Schema(description = "실명번호 13byte")
    @JsonProperty(required = true)
    private String socialId;
    @Schema(description = "입금계좌 인자내역 20byte")
    private String inPrintContent;
    @Schema(description = "납부자 번호 20byte<br/>업체에서 사용하는 납부자 번호 (출금 등록 한 납부자번호와 같아야 출금됨)")
    @JsonProperty(required = true)
    private String payerNo;
    @Schema(description = "대표기관코드 10byte<br/>(1) 대표기관코드 (보통은 업체코드와 같으나, 다를 경우가 있으므로 은행에 문의)")
    @JsonProperty(required = true)
    private String repsCompCode;

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

    public String getOutAccount() {
        return outAccount;
    }

    public void setOutAccount(String outAccount) {
        this.outAccount = outAccount;
    }

    public String getAccountPasswd() {
        return accountPasswd;
    }

    public void setAccountPasswd(String accountPasswd) {
        this.accountPasswd = accountPasswd;
    }

    public String getVerificationKey() {
        return verificationKey;
    }

    public void setVerificationKey(String verificationKey) {
        this.verificationKey = verificationKey;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInAccount() {
        return inAccount;
    }

    public void setInAccount(String inAccount) {
        this.inAccount = inAccount;
    }

    public String getOutPrintContent() {
        return outPrintContent;
    }

    public void setOutPrintContent(String outPrintContent) {
        this.outPrintContent = outPrintContent;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getInPrintContent() {
        return inPrintContent;
    }

    public void setInPrintContent(String inPrintContent) {
        this.inPrintContent = inPrintContent;
    }

    public String getPayerNo() {
        return payerNo;
    }

    public void setPayerNo(String payerNo) {
        this.payerNo = payerNo;
    }

    public String getRepsCompCode() {
        return repsCompCode;
    }

    public void setRepsCompCode(String repsCompCode) {
        this.repsCompCode = repsCompCode;
    }
}
