package com.example.demo.dto.etc;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class JsonToMsgCommonRequest {
    @Schema(description = "식별코드")
    @JsonProperty(required = true)
    private String 식별코드;

    @Schema(description = "업체코드")
    @JsonProperty(required = true)
    private String 업체코드;

    @Schema(description = "은행코드2")
    @JsonProperty(required = true)
    private String 은행코드2;

    @Schema(description = "메시지코드")
    @JsonProperty(required = true)
    private String 메시지코드;

    @Schema(description = "업무구분코드")
    @JsonProperty(required = true)
    private String 업무구분코드;

    @Schema(description = "송신횟수")
    @JsonProperty(required = true)
    private String 송신횟수;

    @Schema(description = "전문번호")
    @JsonProperty(required = true)
    private String 전문번호;

    @Schema(description = "전송일자")
    @JsonProperty(required = true)
    private String 전송일자;

    @Schema(description = "전송시간")
    @JsonProperty(required = true)
    private String 전송시간;

    @Schema(description = "응답코드")
    @JsonProperty(required = true)
    private String 응답코드;

    @Schema(description = "은행 응답코드")
    @JsonProperty(required = true)
    private String 은행응답코드;

    @Schema(description = "조회일자")
    @JsonProperty(required = true)
    private String 조회일자;

    @Schema(description = "조회번호")
    @JsonProperty(required = true)
    private String 조회번호;

    @Schema(description = "은행전문번호")
    @JsonProperty(required = true)
    private String 은행전문번호;

    @Schema(description = "은행코드3")
    @JsonProperty(required = true)
    private String 은행코드3;

    @Schema(description = "예비")
    @JsonProperty(required = true)
    private String 예비;
}
