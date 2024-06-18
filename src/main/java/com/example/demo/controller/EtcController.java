package com.example.demo.controller;

import com.example.demo.dto.firmbanking.FirmStartRequest;
import com.example.demo.service.EtcService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.etc.*;

@RestController
@RequestMapping("/etc")
@Tag(name = "기타 API", description = "기타 api 입니다")
public class EtcController {

    private final EtcService etcService;

    public EtcController(EtcService etcService) {
        this.etcService = etcService;
    }

    @Operation(summary = "전문파싱(원화)", description = "전문 파싱기능 (원화)")
    @PostMapping("/parse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(
                                    name = "요청성공"
                            )}
                    ))
    })
    public String parse(@RequestParam(name = "parsedata", required = true) String jsonDataString) {
        return etcService.ParseData(jsonDataString);
    }

    @Operation(summary = "Json to msg", description = "json을 전문데이터로 만들어주는 기능")
    @PostMapping("/jtom")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/x-www-form-urlencoded; charset=UTF-8",
                            examples = {@ExampleObject(
                                    name = "요청성공"
                            )}
                    ))
    })
    public String JtoM(
            @Parameter(description = "WON (원화), FCS (FCS계좌인증)")
            @RequestParam(name = "svc_type", required = true) String svc_type, @RequestBody String jsonData) {

        return etcService.JsonToMsg(svc_type,jsonData);
    }


    @Operation(summary = "HYPHEN_TRADE_REQUEST 입력 (json)", description = "HYPHEN_TRADE_REQUEST 입력 (json)<br><br> 원화 - 송금이체,지급이체 템플릿 <br> {\n" +
                                                                         "  \"공통부\": {\n" +
                                                                         "    \"식별코드\": \"         \",\n" +
                                                                         "    \"업체코드\": \"HYPHEN\",\n" +
                                                                         "    \"은행코드2\": \"  \",\n" +
                                                                         "    \"메시지코드\": \"0100\",\n" +
                                                                         "    \"업무구분코드\": \"100\",\n" +
                                                                         "    \"송신횟수\": \"1\",\n" +
                                                                         "    \"전문번호\": \"000005\",\n" +
                                                                         "    \"전송일자\": \"20240328\",\n" +
                                                                         "    \"전송시간\": \"002215\",\n" +
                                                                         "    \"응답코드\": \"    \",\n" +
                                                                         "    \"은행 응답코드\": \"    \",\n" +
                                                                         "    \"조회일자\": \"        \",\n" +
                                                                         "    \"조회번호\": \"      \",\n" +
                                                                         "    \"은행전문번호\": \"               \",\n" +
                                                                         "    \"은행코드3\": \"088\",\n" +
                                                                         "    \"예비\": \"             \"\n" +
                                                                         "  },\n" +
                                                                         "  \"송금이체, 지급이체\": {\n" +
                                                                         "    \"출금 계좌번호\": \"140012013472   \",\n" +
                                                                         "    \"통장 비밀번호\": \"5204    \",\n" +
                                                                         "    \"복기부호\": \"      \",\n" +
                                                                         "    \"출금 금액\": \"0000000040000\",\n" +
                                                                         "    \"출금 후 잔액 부호\": \" \",\n" +
                                                                         "    \"출금 후 잔액\": \"             \",\n" +
                                                                         "    \"입금 은행코드2\": \"  \",\n" +
                                                                         "    \"입금 계좌번호\": \"3333105370833  \",\n" +
                                                                         "    \"수수료\": \"         \",\n" +
                                                                         "    \"이체 시각\": \"002215\",\n" +
                                                                         "    \"입금 계좌 적요\": \"(주)터치캐시             \",\n" +
                                                                         "    \"CMS코드\": \"                \",\n" +
                                                                         "    \"신원확인번호\": \"             \",\n" +
                                                                         "    \"자동이체 구분\": \"  \",\n" +
                                                                         "    \"출금 계좌 적요\": \"01090169355         \",\n" +
                                                                         "    \"입금 은행코드3\": \"090\",\n" +
                                                                         "    \"급여 구분\": \" \",\n" +
                                                                         "    \"수수료면제구분\": \" \",\n" +
                                                                         "    \"예비\": \"                                    \"\n" +
                                                                         "  }\n" +
                                                                         "}<br>" +
                                                                         "<br>" +
                                                                         "FCS 템플릿" +
                                                                         "<br>" +
                                                                         "{\n" +
                                                                         "  \"공통부\": {\n" +
                                                                         "    \"식별코드\": \"         \",\n" +
                                                                         "    \"업체코드\": \"FCS02643\",\n" +
                                                                         "    \"은행코드2\": \"99\",\n" +
                                                                         "    \"메시지코드\": \"0600\",\n" +
                                                                         "    \"업무구분코드\": \"400\",\n" +
                                                                         "    \"송신횟수\": \"1\",\n" +
                                                                         "    \"전문번호\": \"009557\",\n" +
                                                                         "    \"전송일자\": \"20240611\",\n" +
                                                                         "    \"전송시간\": \"092450\",\n" +
                                                                         "    \"응답코드\": \"    \",\n" +
                                                                         "    \"은행 응답코드\": \"    \",\n" +
                                                                         "    \"조회일자\": \"        \",\n" +
                                                                         "    \"조회번호\": \"000000\",\n" +
                                                                         "    \"은행전문번호\": \"               \",\n" +
                                                                         "    \"은행코드3\": \"99 \",\n" +
                                                                         "    \"예비\": \"             \"\n" +
                                                                         "  },\n" +
                                                                         "  \"계좌 인증, FCS(Firmbanking Certification Service)\": {\n" +
                                                                         "    \"거래 일자\": \"0611\",\n" +
                                                                         "    \"은행코드2\": \"  \",\n" +
                                                                         "    \"계좌번호\": \"63611001536709  \",\n" +
                                                                         "    \"예금주명\": \"                      \",\n" +
                                                                         "    \"신원확인번호\": \"891203       \",\n" +
                                                                         "    \"신원확인번호 체크\": \"99\",\n" +
                                                                         "    \"업체 계좌번호\": \"                    \",\n" +
                                                                         "    \"은행코드3\": \"004\",\n" +
                                                                         "    \"금액\": \"0000000000000\",\n" +
                                                                         "    \"닫힐통장 조회\": \" \",\n" +
                                                                         "    \"닫힐통장 응유형\": \" \",\n" +
                                                                         "    \"농협계좌 구분\": \" \",\n" +
                                                                         "    \"예비\": \"                                                                                                      \"\n" +
                                                                         "  }\n" +
                                                                         "}")
    @PostMapping("/tradeinsertjson")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(
                                    name = "요청성공"
                            )}
                    ))
    })

    public String TradeInsertJson(
            @Parameter(description = "WON (원화), FCS (FCS계좌인증) ..")
            @RequestParam(name = "svc_type", required = true) String svc_type,
            @RequestBody String jsonData) throws JsonProcessingException {

        return etcService.TradeInsertJson(svc_type, jsonData);
    }


    @Operation(summary = "HYPHEN_TRADE_REQUEST 입력", description = "HYPHEN_TRADE_REQUEST 입력")
    @PostMapping("/tradeinsert")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {@ExampleObject(
                                    name = "요청성공"
                            )}
                    ))
    })

    public String TRADE_REQUEST_INSERT(
            @Parameter(description = "요청일자(YYYYMMDD) (8byte)")
            @RequestParam(name = "REQ_DATE", required = true) String REQ_DATE,
            @Parameter(description = "요청시간(HHMMSS) (6byte)")
            @RequestParam(name = "REQ_TIME", required = true) String REQ_TIME,
            @Parameter(description = "서비스타입 (3byte)")
            @RequestParam(name = "SVC_TYPE", required = true) String SVC_TYPE,
            @Parameter(description = "은행코드 (3byte)")
            @RequestParam(name = "BANK_CODE", required = true) String BANK_CODE,
            @Parameter(description = "부여받은 업체코드 (8byte)")
            @RequestParam(name = "COMP_CODE", required = true) String COMP_CODE,
            @Parameter(description = "전문일련번호 (6byte)")
            @RequestParam(name = "SEQ_NUMB", required = true) String SEQ_NUMB,
            @Parameter(description = "전문구분 메세지코드(4byte)+업무구분코드(3byte) (7byte)")
            @RequestParam(name = "MSG_CODE", required = true) String MSG_CODE,
            @Parameter(description = "전송여부(초기값:N 전송후:Y 에러미전송: E) (1byte)")
            @RequestParam(name = "SEND_FLAG", required = true) String SEND_FLAG,
            @Parameter(description = "응답수신여부(초기값:N) (1byte)")
            @RequestParam(name = "RECV_FLAG", required = true) String RECV_FLAG,
            @Parameter(description = "송신일자(YYYYMMDD) (8byte)")
            @RequestParam(name = "SEND_DATE", required = false) String SEND_DATE,
            @Parameter(description = "송신시간(HHMMSS) 초기값(:null) (6byte)")
            @RequestParam(name = "SEND_TIME", required = false) String SEND_TIME,
            @Parameter(description = "수신일자(YYYYMMDD) (8byte)")
            @RequestParam(name = "RECV_DATE", required = false) String RECV_DATE,
            @Parameter(description = "수신시간(HHMMSS) 초기값(:null) (6byte)")
            @RequestParam(name = "RECV_TIME", required = false) String RECV_TIME,
            @Parameter(description = "요청전문 (2100byte)")
            @RequestParam(name = "SEND_MSG", required = false) String SEND_MSG,
            @Parameter(description = "응답전문 응답전문 (응답수신후 UPDATE됨) (초기값: null) (2100byte)")
            @RequestParam(name = "RECV_MSG", required = false) String RECV_MSG,
            @Parameter(description = "출금등록시 증빙파일 경로 (파일명 포함) (300byte)")
            @RequestParam(name = "PRF_FILE_PATH", required = false) String PRF_FILE_PATH,
            @Parameter(description = "처리상태 메시지 (300byte)")
            @RequestParam(name = "STATUS_MSG", required = false) String STATUS_MSG
                         ) {

        TradeRequestDto tradeRequestDto = new TradeRequestDto();
        tradeRequestDto.setReqDate(REQ_DATE);
        tradeRequestDto.setReqTime(REQ_TIME);
        tradeRequestDto.setSvcType(SVC_TYPE);
        tradeRequestDto.setBankCode(BANK_CODE);
        tradeRequestDto.setCompCode(COMP_CODE);
        tradeRequestDto.setSeqNumb(SEQ_NUMB);
        tradeRequestDto.setMsgCode(MSG_CODE);
        tradeRequestDto.setSendFlag(SEND_FLAG);
        tradeRequestDto.setRecvFlag(RECV_FLAG);
        tradeRequestDto.setSendDate(SEND_DATE);
        tradeRequestDto.setSendTime(SEND_TIME);
        tradeRequestDto.setRecvDate(RECV_DATE);
        tradeRequestDto.setRecvTime(RECV_TIME);
        tradeRequestDto.setSendMsg(SEND_MSG);
        tradeRequestDto.setRecvMsg(RECV_MSG);
        tradeRequestDto.setPrfFilePath(PRF_FILE_PATH);
        tradeRequestDto.setStatusMsg(STATUS_MSG);

        return etcService.TRADE_REQUEST_INSERT(tradeRequestDto);
    }



}
