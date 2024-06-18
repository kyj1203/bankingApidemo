package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;

public class RetailOperationDefinitions {

    @Operation(summary = "송금", description = "고객계좌로의 송금" +
                                             "<br/><span style='color:red'>*통신관련 에러코드 발생시 처리결과 조회 필요</span>" +
                                             "<br/><span style='color:red'>*급여일, 월말 월초 은행측 응답 지연 발생 가능성 존재</span>")
    public @interface DepositOperation {}

    @Operation(summary = "고객계좌 성명조회", description = "고객계좌 성명조회")
    public @interface AccountNameOperation {}

    @Operation(summary = "이체결과조회(단건조회)", description = "특정일자 단 건 이체 결과 조회")
    public @interface TransferOperation {}

    @Operation(summary = "이체결과조회(기간조회)", description = "지정한 범위로 이체 결과 조회")
    public @interface RangeTransferOperation {}

    @Operation(summary = "잔액조회", description = "계과 잔액조회")
    public @interface BalanceOperation {}
}
