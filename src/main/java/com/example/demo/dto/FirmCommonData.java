package com.example.demo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "FirmCommonData 모델", requiredProperties = {"ekey", "msalt", "kscode"})
public class FirmCommonData {

    @Schema(description = "암호화 키 32byte")
    @JsonProperty(required = true)
    private String ekey;
    @Schema(description = "메시지 솔트 값 4byte")
    @JsonProperty(required = true)
    private String msalt;
    @Schema(description = "KS코드  4byte")
    @JsonProperty(required = true)
    private String kscode;

    // Getters and Setters
    public String getEkey() {
        return ekey;
    }

    public void setEkey(String ekey) {
        this.ekey = ekey;
    }

    public String getMsalt() {
        return msalt;
    }

    public void setMsalt(String msalt) {
        this.msalt = msalt;
    }

    public String getKscode() {
        return kscode;
    }

    public void setKscode(String kscode) {
        this.kscode = kscode;
    }
}
