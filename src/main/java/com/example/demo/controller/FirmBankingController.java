package com.example.demo.controller;

import com.example.demo.dto.firmbanking.*;
import com.example.demo.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rfb")
@Tag(name = "펌뱅킹 API", description = "펌뱅킹 api 입니다")
public class FirmBankingController {

    private final FirmBankingService firmBankingService;

    @Autowired
    public FirmBankingController(FirmBankingService firmBankingService) {
        this.firmBankingService = firmBankingService;
    }

    @Operation(summary = "개시업무", description = "업무 시작을 은행에 알리는 개시요청")
    @PostMapping("/bankstart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = "{\n" +
                                            "  \"replyCode\": \"0000\",\n" +
                                            "  \"successYn\": \"Y\"\n" +
                                            "}",
                                    description = "replyCode : 정상 0000, 이외불능 4byte<br/>" +
                                                  "successYn : Y :성공 N : 실패 W : 타임아웃 1byte<br/>"
                            )
                            }
                    ))
    })
    public String bankStart(@RequestBody FirmStartRequest request) {
        return firmBankingService.callBankStartApi(request);
    }

    @Operation(summary = "송금", description = "")
    @PostMapping("/deposit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = "{\n" +
                                            "  \"replyCode\": \"0000\",\n" +
                                            "  \"successYn\": \"Y\",\n" +
                                            "  \"sign\": \"+\",\n" +
                                            "  \"balance\": \"0000000229038\",\n" +
                                            "  \"svcCharge\": \"000000000\",\n" +
                                            "  \"tradeTime\": \"142728\"\n" +
                                            "}",
                                    description = "replyCode : 응답코드 (정상 0000, 이외 불능) 4byte<br/>" +
                                                  "successYn : 성공여부 Y(성공) N(실패) W(타임아웃) 1byte<br/>" +
                                                  "tradeTime : 이체시간 6byte<br/>" +
                                                  "sign : 출금 후 잔액부호 1byte<br/>" +
                                                  "balance : 출금후 잔액 13byte<br/>" +
                                                  "svcCharge : 수수료 9byte"
                            )
                            }
                    ))
    })
    public String Deposit(@RequestBody FirmDepositRequest request) {
        return firmBankingService.callBankDepositApi(request);
    }

    @Operation(summary = "출금", description = "")
    @PostMapping("/withdraw")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = "{\n" +
                                            "  \"replyCode\": \"0000\",\n" +
                                            "  \"successYn\": \"Y\",\n" +
                                            "  \"sign\": \"+\",\n" +
                                            "  \"balance\": \"0000000229038\",\n" +
                                            "  \"svcCharge\": \"000000000\",\n" +
                                            "  \"tradeTime\": \"142728\"\n" +
                                            "}",
                                    description = "replyCode : 응답코드 (정상 0000, 이외 불능) 4byte<br/>" +
                                                  "successYn : 성공여부 Y(성공) N(실패) W(타임아웃) 1byte<br/>" +
                                                  "tradeTime : 이체시간 6byte<br/>" +
                                                  "sign : 출금 후 잔액부호 1byte<br/>" +
                                                  "balance : 출금후 잔액 13byte<br/>" +
                                                  "svcCharge : 수수료 9byte"
                            )
                            }
                    ))
    })
    public String Withdraw(@RequestBody FirmWithdrawRequest request) {
        return firmBankingService.callBankWithdrawApi(request);
    }

    @Operation(summary = "출금계좌등록, 해지", description = "")
    @PostMapping("/account/registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"replyCode\": \"0000\",\n" +
                                           "  \"successYn\": \"Y\",\n" +
                                           "  \"isSuccess\": \"Y\",\n" +
                                           "  \"failureCode\": \"\"\n" +
                                           "}",
                                    description = "replyCode : 응답코드 (정상 0000, 이외 불능) 4byte<br/>" +
                                                  "successYn : 전문의 처리 상태 Y(성공) N(실패) W(타임아웃) 1byte<br/>" +
                                                  "isSuccess : 계좌등록 처리상태 1byte Y:정상 N:불능<br/>" +
                                                  "failureCode 4byte"
                            )
                            }
                    ))
    })
    public String RegisterAccount(@RequestBody FirmRegiRequest request) {
        return firmBankingService.callBankRegiApi(request);
    }

    @Operation(summary = "성명조회", description = "")
    @PostMapping("/account/accountname")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"replyCode\": \"0000\",\n" +
                                           "  \"accountName\": \"꼶냥꿍녱\",\n" +
                                           "  \"successYn\": \"Y\"\n" +
                                           "}",
                                    description = "replyCode : 응답코드 (정상 0000, 이외 불능) 4byte<br/>" +
                                                  "accountName : 예금주성명 20byte<br/>" +
                                                  "successYn 1byte Y:성공 N:실패 W:타임아웃"
                            )
                            }
                    ))
    })
    public String AccountName(@RequestBody FirmAccountNameRequest request) {
        return firmBankingService.callBankAccountNameApi(request);
    }

    @Operation(summary = "집계조회", description = "")
    @PostMapping("/inquiry/summary")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"replyCode\": \"0000\",\n" +
                                           "  \"successYn\": \"Y\",\n" +
                                           "  \"bankReqCnt\": \"0\",\n" +
                                           "  \"bankReqAmt\": \"0\",\n" +
                                           "  \"bankSucCnt\": \"0\",\n" +
                                           "  \"bankSucAmt\": \"0\",\n" +
                                           "  \"bankFailCnt\": \"0\",\n" +
                                           "  \"bankFailAmt\": \"0\",\n" +
                                           "  \"bankSvcChg\": \"0\",\n" +
                                           "  \"otherBankReqCnt\": \"1\",\n" +
                                           "  \"otherBankReqAmt\": \"1000\",\n" +
                                           "  \"otherBankSucCnt\": \"1\",\n" +
                                           "  \"otherBankSucAmt\": \"1000\",\n" +
                                           "  \"otherBankFailCnt\": \"0\",\n" +
                                           "  \"otherBankFailAmt\": \"0\",\n" +
                                           "  \"otherBankSvcChg\": \"0\"\n" +
                                           "}",
                                    description = "replyCode : 응답코드 4byte<br/>" +
                                                  "successYn : Y(이체성공), N(전문실패), W(타임아웃) 1byte<br/>" +
                                                  "bankReqCnt : 당행이체 의뢰 건수 5byte<br/>" +
                                                  "bankReqAmt : 당행이체 의뢰 금액 13byte<br/>" +
                                                  "bankSucCnt : 당행이체 정상 건수 5byte<br/>" +
                                                  "bankSucAmt : 당행이체 정상 금액 13byte<br/>" +
                                                  "bankFailCnt : 당행이체 불능 건수 5byte<br/>" +
                                                  "bankFailAmt : 당행이체 불능 금액 13byte<br/>" +
                                                  "bankSvcChg : 수수료 9byte<br/>" +
                                                  "otherBankReqCnt : 타행이체 의뢰 건수 5byte<br/>" +
                                                  "otherBankReqAmt : 타행이체 의뢰 금액 13byte<br/>" +
                                                  "otherBankSucCnt : 타행이체 정상 건수 5byte<br/>" +
                                                  "otherBankSucAmt : 타행이체 정상 금액 13byte<br/>" +
                                                  "otherBankFailCnt : 타행이체 불능 건수 5byte<br/>" +
                                                  "otherBankReqCnt : 타행이체 불능 금액 13byte<br/>" +
                                                  "otherBankSvcChg : 타행이체 수수료 9byte"
                            )
                            }
                    ))
    })
    public String InquirySummary(@RequestBody FirmSummaryRequest request){
        return firmBankingService.callBankSummaryApi(request);
    }

    @Operation(summary = "이체결과조회", description = "")
    @PostMapping("/inquiry/transfer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"replyCode\": \"0000\",\n" +
                                           "  \"successYn\": \"Y\",\n" +
                                           "  \"outAccountNo\": \"16491006974104\",\n" +
                                           "  \"inAccountNo\": \"80620204145116\",\n" +
                                           "  \"amount\": 1000,\n" +
                                           "  \"svcCharge\": 0,\n" +
                                           "  \"tradeTime\": \"094353\",\n" +
                                           "  \"resultCode\": \"0000\",\n" +
                                           "  \"procBankCode\": \"004\",\n" +
                                           "  \"payerNo\": \"\"\n" +
                                           "}",
                                    description = "replyCode : 응답코드 4byte<br/>" +
                                                  "successYn : Y(이체성공), N(전문실패), W(타임아웃), R(이체 재시도필요) 1byte<br/>" +
                                                  "outAccountNo : 출금 계좌번호 15byte<br/>" +
                                                  "inAccountNo : 입금계좌번호 byte<br/>" +
                                                  "amount : 금액 13byte<br/>" +
                                                  "svcCharge : 수수료 9byte<br/>" +
                                                  "tradeTime : 이체시각 6byte<br/>" +
                                                  "resultCode : 처리결과 4byte<br/>" +
                                                  "procBankCode : 은행코드 3byte<br/>" +
                                                  "payerNo : 납부자번호 20byte"
                            )
                            }
                    ))
    })
    public String InquiryTransfer(@RequestBody FirmTransferRequest request) {
        return firmBankingService.callBankTransferApi(request);
    }

    @Operation(summary = "잔액조회", description = "")
    @PostMapping("/inquiry/balance")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"replyCode\": \"0000\",\n" +
                                           "  \"successYn\": \"Y\",\n" +
                                           "  \"sign\": \"+\",\n" +
                                           "  \"totalBalance\": \"+0000000227038\",\n" +
                                           "  \"balance1\": \"0000000000000\",\n" +
                                           "  \"balance2\": \"0000000000000\",\n" +
                                           "  \"balance3\": \"0000000000000\",\n" +
                                           "  \"payableAmount\": \"0000000227038\"\n" +
                                           "}",
                                    description = "replyCode : 응답코드 4byte<br/>" +
                                                  "successYn : Y(이체성공), N(전문실패), W(타임아웃), R(이체 재시도필요) 1byte<br/>" +
                                                  "sign : 잔액부호<br/>" +
                                                  "totalBalance : 계좌잔액<br/>" +
                                                  "balance1 : 현금잔액<br/>" +
                                                  "balance2 : 보수/가계수표잔액<br/>" +
                                                  "balance3 : 어음/당좌액<br/>" +
                                                  "payableAmount : 지급가능금액"
                            )
                            }
                    ))
    })
    public String InquiryBalance(@RequestBody FirmBalanceRequest request) {
        return firmBankingService.callBankBalanceApi(request);
    }
}
