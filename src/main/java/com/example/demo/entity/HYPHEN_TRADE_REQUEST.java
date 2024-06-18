package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "HYPHEN_TRADE_REQUEST")
public class HYPHEN_TRADE_REQUEST {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String REQ_DATE;
    private String REQ_TIME;
    private String SVC_TYPE;
    private String BANK_CODE;
    private String COMP_CODE;
    private String SEQ_NUMB;
    private String MSG_CODE;
    private String SEND_FLAG;
    private String RECV_FLAG;
    private String SEND_DATE;
    private String SEND_TIME;
    private String RECV_DATE;
    private String RECV_TIME;
    private String SEND_MSG;
    private String RECV_MSG;
    private String PRF_FILE_PATH;
    private String STATUS_MSG;

    // Getters and Setters
    // (위의 DTO와 동일하므로 생략)
    // Getters and Setters
    public String getREQ_DATE() {
        return REQ_DATE;
    }

    public void setREQ_DATE(String REQ_DATE) {
        this.REQ_DATE = REQ_DATE;
    }

    public String getREQ_TIME() {
        return REQ_TIME;
    }

    public void setREQ_TIME(String REQ_TIME) {
        this.REQ_TIME = REQ_TIME;
    }

    public String getSVC_TYPE() {
        return SVC_TYPE;
    }

    public void setSVC_TYPE(String SVC_TYPE) {
        this.SVC_TYPE = SVC_TYPE;
    }

    public String getBANK_CODE() {
        return BANK_CODE;
    }

    public void setBANK_CODE(String BANK_CODE) {
        this.BANK_CODE = BANK_CODE;
    }

    public String getCOMP_CODE() {
        return COMP_CODE;
    }

    public void setCOMP_CODE(String COMP_CODE) {
        this.COMP_CODE = COMP_CODE;
    }

    public String getSEQ_NUMB() {
        return SEQ_NUMB;
    }

    public void setSEQ_NUMB(String SEQ_NUMB) {
        this.SEQ_NUMB = SEQ_NUMB;
    }

    public String getMSG_CODE() {
        return MSG_CODE;
    }

    public void setMSG_CODE(String MSG_CODE) {
        this.MSG_CODE = MSG_CODE;
    }

    public String getSEND_FLAG() {
        return SEND_FLAG;
    }

    public void setSEND_FLAG(String SEND_FLAG) {
        this.SEND_FLAG = SEND_FLAG;
    }

    public String getRECV_FLAG() {
        return RECV_FLAG;
    }

    public void setRECV_FLAG(String RECV_FLAG) {
        this.RECV_FLAG = RECV_FLAG;
    }

    public String getSEND_DATE() {
        return SEND_DATE;
    }

    public void setSEND_DATE(String SEND_DATE) {
        this.SEND_DATE = SEND_DATE;
    }

    public String getSEND_TIME() {
        return SEND_TIME;
    }

    public void setSEND_TIME(String SEND_TIME) {
        this.SEND_TIME = SEND_TIME;
    }

    public String getRECV_DATE() {
        return RECV_DATE;
    }

    public void setRECV_DATE(String recvDate) {
        this.RECV_DATE = RECV_DATE;
    }

    public String getRECV_TIME() {
        return RECV_TIME;
    }

    public void setRECV_TIME(String RECV_TIME) {
        this.RECV_TIME = RECV_TIME;
    }

    public String getSEND_MSG() {
        return SEND_MSG;
    }

    public void setSEND_MSG(String SEND_MSG) {
        this.SEND_MSG = SEND_MSG;
    }

    public String getRECV_MSG() {
        return RECV_MSG;
    }

    public void setRECV_MSG(String RECV_MSG) {
        this.RECV_MSG = RECV_MSG;
    }

    public String getPRF_FILE_PATH() {
        return PRF_FILE_PATH;
    }

    public void setPRF_FILE_PATH(String PRF_FILE_PATH) {
        this.PRF_FILE_PATH = PRF_FILE_PATH;
    }

    public String getSTATUS_MSG() {
        return STATUS_MSG;
    }

    public void setSTATUS_MSG(String STATUS_MSG) {
        this.STATUS_MSG = STATUS_MSG;
    }
}
