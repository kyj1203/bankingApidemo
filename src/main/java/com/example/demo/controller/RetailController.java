package com.example.demo.controller;
import com.example.demo.dto.retail.*;
import com.example.demo.service.RetailService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rfb/retail")
@Tag(name = "송금대행 API", description = "송금대행 api 입니다")
public class RetailController {

    private final RetailService retailService;

    @Autowired
    public RetailController(RetailService retailService) {
        this.retailService = retailService;
    }
    @Operation(summary = "송금", description = "고객계좌로의 송금" +
                                             "<br/><span style='color:red'>*통신관련 에러코드 발생시 처리결과 조회 필요</span>" +
                                             "<br/><span style='color:red'>*급여일, 월말 월초 은행측 응답 지연 발생 가능성 존재</span>")
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
                                            "  \"sign\": \" \",\n" +
                                            "  \"balance\": \"0000000999000\",\n" +
                                            "  \"svcCharge\": \"000000000\",\n" +
                                            "  \"tradeTime\": \"152146\"\n" +
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
    public String Deposit(@RequestBody RetailDepositRequest request) {
        return retailService.callRetailDepositApi(request);
    }

    @Operation(summary = "고객계좌 성명조회", description = "고객계좌 성명조회")
    @PostMapping("/account/accountname")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"accountName\": \"쉼쭐츙\",\n" +
                                           "  \"replyCode\": \"0000\",\n" +
                                           "  \"successYn\": \"Y\"\n" +
                                           "}",
                                    description = "replyCode : 응답코드 (정상 0000, 이외 불능) 4byte<br/>" +
                                                  "accountName : 예금주성명 20byte<br/>" +
                                                  "successYn 1byte Y:성공 N:실패 W:타임아웃"
                            )
                            }
                    ))
    })
    public String AccountName(@RequestBody RetailAccountNameRequest request) {
        return retailService.callRetailAccountNameApi(request);
    }

    @Operation(summary = "이체결과조회(단건조회)", description = "특정일자 단 건 이체 결과 조회")
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
                                           "  \"outAccountNo\": \"70----------23\",\n" +
                                           "  \"inAccountNo\": \"50--------66\",\n" +
                                           "  \"amount\": 1000,\n" +
                                           "  \"svcCharge\": 0,\n" +
                                           "  \"tradeTime\": \"150609\",\n" +
                                           "  \"resultCode\": \"0000\",\n" +
                                           "  \"procBankCode\": \"039\",\n" +
                                           "  \"payerNo\": \"\"\n" +
                                           "}",
                                    description = "replyCode (4byte): 응답코드<br/>" +
                                                  "successYn (1byte): 원거래 처리 여부 Y(조회 성공) N(실패 replyCode:KS22,9999 이체결과 조회 재시도)<br/>" +
                                                  "outAccountNo (15byte) : 출금 계좌번호<br/>" +
                                                  "inAccountNo (15byte) : 입금 계좌번호<br/>" +
                                                  "amount (13byte) : 금액<br/>" +
                                                  "svcCharge (9byte) : 수수료<br/>" +
                                                  "tradeTime (6byte) : 이체시각<br/>" +
                                                  "resultCode (4byte) : 처리결과<br/>" +
                                                  "procBankCode (3byte) : 은행코드<br/>" +
                                                  "payerNo (20byte) : 납부자번호"
                            )
                            }
                    ))
    })
    public String Transfer(@RequestBody RetailTransferRequest request) {
        return retailService.callRetailTransferApi(request);
    }

    @Operation(summary = "이체결과조회(기간조회)", description = "지정한 범위로 이체 결과 조회")
    @PostMapping("/inquiry/range/transfer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value ="{\n" +
                                           "  \"size\": \"5\",\n" +
                                           "  \"result\": [\n" +
                                           "    {\n" +
                                           "      \"sendDate\": \"20220916\",\n" +
                                           "      \"sendTime\": \"100518\",\n" +
                                           "      \"seqNo\": \"000027\",\n" +
                                           "      \"rtnCode\": \"0013\",\n" +
                                           "      \"amt\": \"100\",\n" +
                                           "      \"inAccountNo\": \"@OEIxfQoAbeU~\"\n" +
                                           "    },\n" +
                                           "    {\n" +
                                           "      \"sendDate\": \"20220919\",\n" +
                                           "      \"sendTime\": \"162712\",\n" +
                                           "      \"seqNo\": \"500005\",\n" +
                                           "      \"rtnCode\": \"0000\",\n" +
                                           "      \"amt\": \"1000\",\n" +
                                           "      \"inAccountNo\": \"123456789\"\n" +
                                           "    },\n" +
                                           "    {\n" +
                                           "      \"sendDate\": \"20220920\",\n" +
                                           "      \"sendTime\": \"085759\",\n" +
                                           "      \"seqNo\": \"000015\",\n" +
                                           "      \"rtnCode\": \"0000\",\n" +
                                           "      \"amt\": \"1000\",\n" +
                                           "      \"inAccountNo\": \"123456789\"\n" +
                                           "    },\n" +
                                           "    {\n" +
                                           "      \"sendDate\": \"20220920\",\n" +
                                           "      \"sendTime\": \"150553\",\n" +
                                           "      \"seqNo\": \"000080\",\n" +
                                           "      \"rtnCode\": \"0000\",\n" +
                                           "      \"amt\": \"1000\",\n" +
                                           "      \"inAccountNo\": \"123456789\"\n" +
                                           "    },\n" +
                                           "    {\n" +
                                           "      \"sendDate\": \"20220920\",\n" +
                                           "      \"sendTime\": \"173405\",\n" +
                                           "      \"seqNo\": \"400005\",\n" +
                                           "      \"rtnCode\": \"0000\",\n" +
                                           "      \"amt\": \"1000\",\n" +
                                           "      \"inAccountNo\": \"123456789\"\n" +
                                           "    }\n" +
                                           "  ]\n" +
                                           "}",
                                    description = "size : 결과 배열 길이<br/>" +
                                                  "result : 결과 배열<br/>" +
                                                  "<br/>" +
                                                  "sendDate : 이체 요청 날짜 8byte<br/>" +
                                                  "sendTime : 이체 요청 시간 8byte<br/>" +
                                                  "seqNo : 이체 건에 대한 일련번호 6byte<br/>" +
                                                  "rtnCode : 이체 건에대한 응답코드 4byte<br/>" +
                                                  "amt : 금액 13byte<br/>" +
                                                  "inAccountNo : 받는분 계좌 20byte"
                            )
                            }
                    ))
    })
    public String RangeTransfer(@RequestBody RetailRangeTransferRequest request) {
        return retailService.callRetailRangeTransferApi(request);
    }

    @Operation(summary = "잔액조회", description = "계과 잔액조회")
    @PostMapping("/inquiry/balance")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = "{\n" +
                                            "  \"replyCode\": \"0000\",\n" +
                                            "  \"successYn\": \"Y\",\n" +
                                            "  \"sign\": \" \",\n" +
                                            "  \"totalBalance\": \" 0004999999000\",\n" +
                                            "  \"balance1\": \"0000000000000\",\n" +
                                            "  \"balance2\": \"0000000000000\",\n" +
                                            "  \"balance3\": \"0000000000000\",\n" +
                                            "  \"payableAmount\": \"0004999999000\"\n" +
                                            "}",
                                    description = "replyCode : 응답코드 4byte<br/>" +
                                                  "successYn : 성공여부 1byte<br/>" +
                                                  "sign : 잔액부호 1byte<br/>" +
                                                  "totalBalance : 계좌반액 13byte<br/>" +
                                                  "balance1 : 현금잔액 13byte<br/>" +
                                                  "balance2 : 보수/가계수표 잔액 13byte<br/>" +
                                                  "balance3 : 어음/당좌액 13byte<br/>" +
                                                  "payableAmount : 지급가능금액 13byte"
                            )
                            }
                    ))
    })
    public String Balance(@RequestBody RetailBalanceRequest request) {
        return retailService.callRetailBalanceApi(request);
    }


}
