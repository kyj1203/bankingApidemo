package com.example.demo.dto.firmbanking;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class FirmDepositRequestData {
    @Schema(description = "요청날짜 8byte")
    @JsonProperty(required = true)
    private String date;
    @Schema(description = "요청시간 6byte")
    @JsonProperty(required = true)
    private String time;
    @Schema(description = "은행에서 부여한 업체별 코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드(계약은행) 8byte")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "일련번호 6byte")
    @JsonProperty(required = true)
    private String seqNo;
    @Schema(description = "출금 계좌번호(모계좌) 15byte")
    @JsonProperty(required = true)
    private String outAccount;
    @Schema(description = "통장 비밀번호 8byte")
    @JsonProperty(required = true)
    private String accountPasswd;
    @Schema(description = "복기부호 6byte<br>은행에서 부여한 산출공식의 결과 값")
    @JsonProperty(required = true)
    private String verificationKey;
    @Schema(description = "금액 13byte")
    @JsonProperty(required = true)
    private String amount;
    @Schema(description = "입금은행코드 3byte")
    @JsonProperty(required = true)
    private String inBankCode;
    @Schema(description = "입금계좌번호 15byte")
    @JsonProperty(required = true)
    private String inAccount;
    @Schema(description = "입금계좌인자내역 20byte")
    @JsonProperty(required = true)
    private String inPrintContent;
    @Schema(description = "CMS CODE 16byte<br/>(1)받는 통장이 CMS계좌일 경우 사용")
    private String cmsCode;
    @Schema(description = "출금계좌 인자 내역 20byte")
    private String outPrintContent;
    @Schema(description = "급여 여부 1byte<br/> (1)급여 구분: 급여 이체시 '1' 세팅 (농협,신한만 흔행과 협의 후 가능)")
    private String isSalaries;

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

    public String getInBankCode() {
        return inBankCode;
    }

    public void setInBankCode(String inBankCode) {
        this.inBankCode = inBankCode;
    }

    public String getInAccount() {
        return inAccount;
    }

    public void setInAccount(String inAccount) {
        this.inAccount = inAccount;
    }

    public String getInPrintContent() {
        return inPrintContent;
    }

    public void setInPrintContent(String inPrintContent) {
        this.inPrintContent = inPrintContent;
    }

    public String getCmsCode() {
        return cmsCode;
    }

    public void setCmsCode(String cmsCode) {
        this.cmsCode = cmsCode;
    }

    public String getOutPrintContent() {
        return outPrintContent;
    }

    public void setOutPrintContent(String outPrintContent) {
        this.outPrintContent = outPrintContent;
    }

    public String getIsSalaries() {
        return isSalaries;
    }

    public void setIsSalaries(String isSalaries) {
        this.isSalaries = isSalaries;
    }
}
