package com.example.demo.controller;

import com.example.demo.service.ArsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import  io.swagger.v3.oas.annotations.media.*;

@RestController
@RequestMapping("/ksnet/auth")
@Tag(name = "ARS API", description = "ARS api 입니다")
public class ArsController {

    private final ArsService arsService;
    private final String url = "https://cmsarstest.ksnet.co.kr/ksnet/auth"; // Base URL

    @Autowired
    public ArsController(ArsService arsService) {
        this.arsService = arsService;
    }

    @Operation(summary = "FCS 계좌인증", description = "")
    @PostMapping("/account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                            {
                                               "name": "달나라가자",
                                               "reply": "0000",
                                               "reply_msg": "정상처리"
                                             }""",
                                    description = "name : 조회된 계좌주 22byte 0000 - 정상<br/>" +
                                                  "reply : 응답코드 4byte<br/>" +
                                                  "reply_msg : 응답코드 내용 20byte<br/>"
                            )
                            }
                    ))
    })
    public String account(
            @Parameter(description = "auth_key 이용기업고유 키 값 20byte (필수)<br>" +
                    "reqdata 하위 개별부 데이터<br><br>{" +
                    "fcs_cd 계좌인증 업체코드 8byte (필수값) <br/>" +
                    "bank_cd 계좌은행 3byte (필수값) <br/>" +
                    "acct_no 계좌번호 16byte <br/>" +
                    "acct_nm 예금주명 22byte 계좌번호없이 실명인증(실명+생년월일) 방식을 사용할 경우에만 세팅<br/>" +
                    "id_no 신원확인번호 13byte 생년월일 6자리(개인:YYMMDD), 사업자번호 10자리(사업자/법인) <br/>" +
                    "amount 금액 13byte 가상계좌 조회시 사용 (외환, 농협, 우리, 씨티) <br/>" +
                    "seq_no 일련번호 6byte (필수값)}" +
                    "<br><br>" +
                    "요청예시<br/><br/>" +
                    "{\"auth_key\":\"LG8eOBVHeEQkO01DSvTb\",\"reqdata\":[\n" +
                    "        {\"amount\":\"0\",\"bank_cd\":\"011\",\"fcs_cd\":\"FCS90000\",\"seq_no\":\"000001\",\"auth_type\":\"99\",\"acct_no\":\"36702017327\",\"acct_nm\":\"홍길동\",\"id_no\":\"661107\"}\n" +
                    "    ]\n" +
                    "}")
            @RequestParam("JSONData") String jsonDataString) {
        System.out.println(jsonDataString);
        String apiUrl = url + "/account"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 자동이체동의(이통사 인증)", description = "ARS 자동이체동의(이통사 인증+점유)")
    @PostMapping("/ars1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "reply": "0000",
                                      "reply_msg": "인증성공",
                                      "auth_numb": "1279",
                                      "trace_no": "208915000003"
                                    }""",
                                    description = "reply : 응답코드 4byte 0000 - 정상<br/>" +
                                           "reply_msg : 응답 메시지 50byte<br/>" +
                                           "trace_no : 처리일련번호 ARS점유 요청시사용 12byte<br/>" +
                                           "auth_numb : 사용자 인증번호 4byte<br/>"
                                   )
                            }
                           ))
    })
    public String ars1(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    compcode ARS업체코드 8byte (필수값) <br/>\
                    phoneno 휴대폰번호 11byte (필수값) <br/>\
                    service 서비스분류 4byte (필수값) 0002 : 자동이체 동의<br/>\
                    svc_type 기능분류 2byte (필수값) 01: 소유<br/>\
                    birthday 생년월일 8byte (필수값) YYYYMMDD <br/>\
                    custnm 고객명 10byte (필수값) <br/>\
                    nation 국적 1byte 1: 내국인 2: 외국인<br/>\
                    gender 성별 1byte 1: 남자 2: 여자<br/>\
                    telecd 통신사코드 2byte 1: SKT 2: KT 3: LGU 4: SKT알뜰폰 5: KT알뜰폰 6: LGU알뜰폰}<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"LG8eOBVHeEQkO01DSvTb","reqdata":[
                            {"birthday":"19881030","telecd":"05","svc_type":"01","service":"0001","compcode":"ARS00001","gender":"1","nation":"1","custnm":"홍길동", "phoneno":"01012345678"}
                        ]
                    }""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 자동이체동의(ARS점유 확인요청)", description = "ARS 자동이체동의(이통사 인증+점유)")
    @PostMapping("/ars1_2")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "reply": "0000",
                                      "reply_msg": "인증성공",
                                      "trace_no": "208915000003",
                                      "record": "***"
                                    }""",
                                    description = "reply : 응답코드 4byte 0000 - 정상<br/>" +
                                                  "reply_msg : 응답 메시지 50byte<br/>" +
                                                  "trace_no : 처리일련번호 12byte<br/>" +
                                                  "record : 녹취내용<br/>"
                            )
                            }
                    ))
    })
    public String ars1_1(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    compcode ARS업체코드 8byte (필수값) <br/>\
                    phoneno 휴대폰번호 11byte (필수값) <br/>\
                    service 서비스분류 4byte (필수값) 0002 : 자동이체 동의<br/>\
                    svc_type 기능분류 2byte (필수값) 02: 소유<br/>\
                    traceno 처리일련번호 12byte (필수값) 이통사 인증요청시 응답값<br/>\
                    birthday 생년월일 8byte (필수값) YYYYMMDD <br/>\
                    custnm 고객명 10byte (필수값) <br/>\
                    nation 국적 1byte 1: 내국인 2: 외국인<br/>\
                    gender 성별 1byte 1: 남자 2: 여자<br/>\
                    telecd 통신사코드 2byte 1: SKT 2: KT 3: LGU 4: SKT알뜰폰 5: KT알뜰폰 6: LGU알뜰폰<br/>\
                    usedrecord 녹취파일 사용여부 1byte Y/N(필수값)<br/>\
                    authno 사용자가 입력할 인증번호 4byte 이통사 인증요청시 응답값(필수값)<br/>\
                    banknm 자동이체은행명 (필수값)<br/>\
                    acctno 자동이체계좌번호 (필수값)<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"LG8eOBVHeEQkO01DSvTb","reqdata":[
                             {"birthday":"19881030","banknm":"하나은행","telecd":"05","usedrecord":"Y","svc_type":"02","traceno":"106627000021","compcode":"ARS00001",
                             "acctno":"25791051309707","nation":"1","service":"0002","gender":"1","authno":"1234","phoneno":"01012345678","custnm":"홍길동"}
                         ]
                     }""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 자동이체동의(이통사 인증없이 점유확인)", description = "ARS 자동이체동의(이통사 인증없이 점유확인)")
    @PostMapping("/ars2")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "reply": "0000",
                                      "reply_msg": "인증성공",
                                      "trace_no": "208915000003",
                                      "record": "***"
                                    }""",
                                    description = "reply : 응답코드 4byte 0000 - 정상<br/>" +
                                                  "reply_msg : 응답 메시지 50byte<br/>" +
                                                  "trace_no : 처리일련번호 12byte<br/>" +
                                                  "record : 녹취내용<br/>"
                            )
                            }
                    ))
    })
    public String ars2(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    compcode ARS업체코드 8byte (필수값) <br/>\
                    phoneno 휴대폰번호 11byte (필수값) <br/>\
                    service 서비스분류 4byte (필수값) 0002 : 자동이체 동의<br/>\
                    svc_type 기능분류 2byte (필수값) 03: ARS인증<br/>\
                    usedrecord 녹취파일 사용 여부 1byte Y/N <br/>\
                    authno 사용자가 입력할 인증번호 4byte (필수값) 업체에서 생성<br/>\
                    banknm 자동이체 은행명(필수값)<br/>\
                    acctno 자동이체 계좌번호(필수값)<br/>\
                    custnm 고객명 10byte (필수값)<br/>\
                    birthday 생년월일 8byte YYYYMMDD(필수값)<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"LG8eOBVHeEQkO01DSvTb","reqdata":[
                             {"birthday":"19881030","banknm":"하나은행","usedrecord":"Y","svc_type":"03","service":"0002","compcode":"ARS00001",
                              "authno":"1234","custnm":"홍길동","account":"25791051309707","phoneno":"01012345678"}
                         ]
                     }""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 회원가입(이통사 인증) ", description = "이통사 인증요청")
    @PostMapping("/ars3")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "reply": "0000",
                                      "reply_msg": "인증성공",
                                      "auth_numb": "1279",
                                      "trace_no": "208915000003"
                                    }""",
                                    description = "reply : 응답코드 4byte 0000 - 정상<br/>" +
                                                  "reply_msg : 응답 메시지 50byte<br/>" +
                                                  "trace_no : 처리일련번호 ARS점유 요청시사용 12byte<br/>" +
                                                  "auth_numb : 사용자 인증번호 4byte<br/>"
                            )
                            }
                    ))
    })
    public String ars3(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    compcode ARS업체코드 8byte (필수값) <br/>\
                    phoneno 휴대폰번호 11byte (필수값) <br/>\
                    service 서비스분류 4byte (필수값) 0001 : ARS인증<br/>\
                    svc_type 기능분류 2byte (필수값) 01: 소유<br/>\
                    birthday 생년월일 8byte (필수값) YYYYMMDD <br/>\
                    custnm 고객명 10byte (필수값)<br/>\
                    nation 국적 1byte 1:내국인 2:외국인<br/>\
                    gender 성별 1byte 1:남자 2:여자<br/>\
                    telecd 통신사코드 2byte 1: SKT 2: KT 3: LGU 4: SKT알뜰폰 5: KT알뜰폰 6: LGU알뜰폰<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"LG8eOBVHeEQkO01DSvTb","reqdata":[
                            {"birthday":"19881030","telecd":"05","svc_type":"01","service":"0001","compcode":"ARS00001","gender":"1",
                            "nation":"1","custnm":"홍길동","phoneno":"01012345678"}
                        ]
                    }""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 회원가입(ARS점유 확인요청)", description = "ARS점유 확인 요청")
    @PostMapping("/ars3_2")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "reply": "0000",
                                      "reply_msg": "인증성공",
                                      "trace_no": "208915000003",
                                      "record": "***"
                                    }""",
                                    description = "reply : 응답코드 4byte 0000 - 정상<br/>" +
                                                  "reply_msg : 응답 메시지 50byte<br/>" +
                                                  "trace_no : 처리일련번호 12byte<br/>" +
                                                  "record : 녹취내용<br/>"
                            )
                            }
                    ))
    })
    public String ars3_2(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    compcode ARS업체코드 8byte (필수값) <br/>\
                    phoneno 휴대폰번호 11byte (필수값) <br/>\
                    service 서비스분류 4byte (필수값) 0001 : ARS인증<br/>\
                    svc_type 기능분류 2byte (필수값) 01: 소유<br/>\
                    traceno 처리일련번호 12byte (필수값) 소유인증시 리턴받은 traceno <br/>\
                    birthday 생년월일 8byte (필수값) YYYYMMDD <br/>\
                    custnm 고객명 10byte (필수값)<br/>\
                    nation 국적 1byte 1:내국인 2:외국인<br/>\
                    gender 성별 1byte 1:남자 2:여자<br/>\
                    telecd 통신사코드 2byte 1: SKT 2: KT 3: LGU 4: SKT알뜰폰 5: KT알뜰폰 6: LGU알뜰폰<br/>\
                    usedrecord 녹취파일 사용여부 1byte Y/N(필수값)<br/>\
                    authno 사용자가 입력할 인증번호 4byte 소유인증시 리턴받은 traceno (필수값)<br/>\
                    filler1 인증사용 목적 "가입|해지|출금" 등등 (필수값)<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"LG8eOBVHeEQkO01DSvTb","reqdata":[
                              {"birthday":"19881030","telecd":"05","usedrecord":"Y","svc_type":"02","traceno":"106627000021",
                               "compcode":"ARS00001","nation":"1","filler1":"인증","service":"0001","gender":"1","authno":"1234","phoneno":"01012345678","custnm":"홍길동"}
                          ]
                      }""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 회원가입(이통사 인증없이 점유확인)", description = "ARS 회원가입(이통사 인증없이 점유확인)")
    @PostMapping("/ars4")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "reply": "0000",
                                      "reply_msg": "인증성공",
                                      "trace_no": "208915000003",
                                      "record": "***"
                                    }""",
                                    description = "reply : 응답코드 4byte 0000 - 정상<br/>" +
                                                  "reply_msg : 응답 메시지 50byte<br/>" +
                                                  "trace_no : 처리일련번호 12byte<br/>" +
                                                  "record : 녹취내용<br/>"
                            )
                            }
                    ))
    })
    public String ars4(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    compcode ARS업체코드 8byte (필수값) <br/>\
                    phoneno 휴대폰번호 11byte (필수값) <br/>\
                    service 서비스분류 4byte (필수값) 0002 : 자동이체 동의<br/>\
                    svc_type 기능분류 2byte (필수값) 01: 소유<br/>\
                    usedrecord 녹취파일 사용여부 1byte Y/N(필수값)<br/>\
                    authno 사용자가 입력할 인증번호 4byte 소유인증시 리턴받은 traceno (필수값)<br/>\
                    filler1 인증사용 목적 "가입|해지|출금" 등등 (필수값)<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"LG8eOBVHeEQkO01DSvTb","reqdata":[
                            {"filler1":"인증","usedrecord":"Y","svc_type":"03","service":"0001","compcode":"ARS00001","authno":"1234","phoneno":"01012345678"}
                        ]
                    }""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 증빙자료생성요청", description = "ARS 증빙자료생성요청")
    @PostMapping("/prf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "successYn": "Y",
                                      "respGoveCode": "K000",
                                      "respCode": "0000",
                                      "extRespCode": "0000",
                                      "respMsg": "성공하였습니다",
                                      "dealDt": "20240528120000",
                                      "regTrno": "12345678901234567890"
                                    }""",
                                    description = "successYn : 성공여부(Y/N) 1byte 0000 - 정상<br/>" +
                                                  "respGoveCode : 응답생성기관코드(K000:KSNET, KFCS:KSNET FCS, ARS1:인비즈넷, Bxxx: 은행) 4byte<br/>" +
                                                  "respCode : VAN응답코드 4byte<br/>" +
                                                  "extRespCode : 기관응답코드 4byte<br/>" +
                                                  "respMsg : 응답메세지 100byte<br/>" +
                                                  "dealDt : 전문전송일시 14byte<br/>" +
                                                  "regTrno : 츨금등록 인증용 거래번호 20byte<br/>"
                            )
                            }
                    ))
    })
    public String prf(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    mid KSNET에서 가맹점에 부여한 상점아이디 10byte (필수값) <br/>\
                    custId 가맹점에서 고객에게 부여한 납부자번호(고객번호) 50byte (필수값) <br/>\
                    bankCode 출금계좌 은행코드 3자리 3byte (필수값)<br/>\
                    sendDt 주문요청일시 14byte (필수값) * 조회시 동일한값 전송<br/>\
                    ordNo 주문번호(가맹점 요청키) 50byte Y/N(필수값) * 요청식별용 고유키, 조회시 동일<br/>\
                    nameCheckType 예금주명 비교유형(1:전체, 2:짧은쪽, 3:짧은쪽(기호제거), 4:짧은쪽과반(기호제거)) 1byte 소유인증시 리턴받은 traceno (필수값) * 기본값(0:비교하지않음)<br/>\
                    phoneNo ARS인증시 필요한 고객 전화번호 11byte (필수값)<br/>\
                    authNo ARS인증시 고객이 입력할 인증번호 2byte (필수값)<br/>\
                    account 출금계좌번호 16byte (필수값)<br/>\
                    custNm 고객명 10byte (필수값) *euc-kr기준 10byte<br/>\
                    custType 개인/사업자 구분(0/1) 1byte (필수값) 외국인은 개인과 동일<br/>\
                    socialNo 예금주 생년월일 또는 사업자 등록번호(예금주 조회 불일치시 거절) 10byte (필수값)<br/>\
                    <br><br>\
                    요청예시<br/><br/>\
                    {"auth_key":"GpXATd1aztPjJRVr4WBV","reqdata":[{"phoneNo":"01032188580","custId":"KSMQP5807","ordNo":"KS201910999999","custNm":"풂수슭","sendDt":"20190910","authNo":"1234","account":"25791051309707","nameCheckType":"1","mid":"XXXXXXXX","socialNo":"881030","custType":"0","bankCode":"081"}]}""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars/prf"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }

    @Operation(summary = "ARS 증빙자료결과조회", description = "ARS 증빙자료결과조회")
    @PostMapping("/prf/inquiry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.",
                    content = @Content(
                            mediaType = "application/json",
                            examples ={ @ExampleObject(
                                    name ="요청성공",
                                    value = """
                                    {
                                      "successYn": "Y",
                                      "respGoveCode": "K000",
                                      "respCode": "0000",
                                      "extRespCode": "0000",
                                      "respMsg": "성공하였습니다",
                                      "dealDt": "20240528120000",
                                      "pfName": "증빙파일"
                                    }""",
                                    description = "successYn : 성공여부(Y/N) 1byte 0000 - 정상<br/>" +
                                                  "respGoveCode : 응답생성기관코드(K000:KSNET, KFCS:KSNET FCS, ARS1:인비즈넷, Bxxx: 은행) 4byte<br/>" +
                                                  "respCode : VAN응답코드 4byte<br/>" +
                                                  "extRespCode : 기관응답코드 4byte<br/>" +
                                                  "respMsg : 응답메세지 100byte<br/>" +
                                                  "dealDt : 전문전송일시 14byte<br/>" +
                                                  "pfName : 증방파일명 30byte<br/>"
                            )
                            }
                    ))
    })
    public String inquiry(
            @Parameter(description = """
                    auth_key 이용기업고유 키 값 20byte (필수)<br>\
                    reqdata 하위 개별부 데이터<br><br>{\
                    mid KSNET에서 가맹점에 부여한 상점아이디 10byte (필수값) <br/>\
                    custId 가맹점에서 고객에게 부여한 납부자번호(고객번호) 50byte (필수값) <br/>\
                    bankCode 출금계좌 은행코드 3자리 3byte (필수값)<br/>\
                    sendDt 주문요청일시 14byte (필수값) * 조회시 동일한값 전송<br/>\
                    ordNo 주문번호(가맹점 요청키) 50byte Y/N(필수값) * 요청식별용 고유키, 조회시 동일<br/>\
                    regTrno 계좌간편결제인증 요청 시 응답에서 수신한 츨금등록 인증용 거래번호  20byte (필수값)<br/>\
                    <br><br>\
                    요청예시<br/>\
                    {"auth_key":"GpXATd1aztPjJRVr4WBV","reqdata":[{"custId":"KSMQP5807","ordNo":"kv16d148c32c40371909","sendDt":"20190909","mid":"XXXXXXXX","bankCode":"081"}]}""")
            @RequestParam(name = "JSONData", required = true) String jsonDataString) {
        String apiUrl = url + "/ars/prf/inquiry"; // 실제 API URL로 변경하세요
        return arsService.callArsApi(apiUrl,jsonDataString);
    }


}
