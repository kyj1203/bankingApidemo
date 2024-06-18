package com.example.demo.dto.firmbanking;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class FirmRegiRequestData {
    @Schema(description = "요청날짜 8byte")
    @JsonProperty(required = true)
    private String date;
    @Schema(description = "요청시간 6byte")
    @JsonProperty(required = true)
    private String time;
    @Schema(description = "회사코드 8byte")
    @JsonProperty(required = true)
    private String compCode;
    @Schema(description = "은행코드(전문거래) 3byte")
    @JsonProperty(required = true)
    private String bankCode;
    @Schema(description = "일련번호 6byte")
    @JsonProperty(required = true)
    private String seqNo;
    @Schema(description = "계좌번호 8byte")
    @JsonProperty(required = true)
    private String accountNo;
    @Schema(description = "신청구분 6byte<br/>등록:1 해지:2")
    @JsonProperty(required = true)
    private String regiFlag;
    @Schema(description = "신청구분 6byte<br/>등록:1 해지:2")
    @JsonProperty(required = true)
    private String requestDate;
    @Schema(description = "신청일자 8byte")
    @JsonProperty(required = true)
    private String socialId;
    @Schema(description = "납부자번호 20byte<br>업체에서 사용하는 납부자번호 (출금 이체 요청시 납부자번호가 같아야 출금됨)")
    @JsonProperty(required = true)
    private String payerNo;
    @Schema(description = "대표기관 코드 10byte<br>대표기관코드 (보통은 업체코드와 같으나 다를 경우가 있음으로 은행에 문의)")
    @JsonProperty(required = true)
    private String repsCompCode;
    @Schema(description = "증빙 일부면제 업체구분 1byte<br>Y:일부면제, A:KSNET ARS이용업체")
    private String proofPassYn;
    @Schema(description = "결제원 이용기관코드 20byte<br>*계좌등록시 필수")
    private String kftcCompCode;
    @Schema(description = "예금주 실명번호종류 1byte\n<br/>*계좌등록시 필수<br/> 0:개인, 외국인 1:사업자 2:여권")
    @JsonProperty(required = true)
    private String socialKind;
    @Schema(description = "동의자료 구분 1byte<br/>*계좌등록시 필수<br/>1:서면 2:공인인증 3:일반인증 4:녹취 5:ARS")
    @JsonProperty(required = true)
    private String agreementKind;
    @Schema(description = "KSNET ARS처리 일련번호 12byte")
    @JsonProperty(required = true)
    private String arsRefno;

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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getRegiFlag() {
        return regiFlag;
    }

    public void setRegiFlag(String regiFlag) {
        this.regiFlag = regiFlag;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
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

    public String getProofPassYn() {
        return proofPassYn;
    }

    public void setProofPassYn(String proofPassYn) {
        this.proofPassYn = proofPassYn;
    }

    public String getKftcCompCode() {
        return kftcCompCode;
    }

    public void setKftcCompCode(String kftcCompCode) {
        this.kftcCompCode = kftcCompCode;
    }

    public String getSocialKind() {
        return socialKind;
    }

    public void setSocialKind(String socialKind) {
        this.socialKind = socialKind;
    }

    public String getAgreementKind() {
        return agreementKind;
    }

    public void setAgreementKind(String agreementKind) {
        this.agreementKind = agreementKind;
    }

    public String getArsRefno() {
        return arsRefno;
    }

    public void setArsRefno(String arsRefno) {
        this.arsRefno = arsRefno;
    }
}
