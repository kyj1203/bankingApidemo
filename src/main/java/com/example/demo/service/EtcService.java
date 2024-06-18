package com.example.demo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.demo.Util.FieldDefinition;
import com.example.demo.Util.MsgDef;
import org.springframework.stereotype.Service;
import com.example.demo.dto.etc.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class EtcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String ParseData(String data) {
        System.out.println(data);
        Map<String, Object> finalData = new LinkedHashMap<>();

        // 공통부 파싱
        Map<String, String> commonData = parseFields(data, MsgDef.COMMON_FIELDS, 0);
        finalData.put("공통부", commonData);

        int currentPosition = getCurrentPosition(commonData);
        // 개별부 및 새로운 개별부 파싱

        String messageCode = commonData.get("메시지코드");
        String businessCode = commonData.get("업무구분코드");
        String bankCode3 = commonData.get("은행코드3");

        Map<String, String> msgData = new LinkedHashMap<>();

        switch (messageCode) {
            case "0100":
                switch (businessCode) {
                    case "100":
                        msgData = parseFields(data, MsgDef.FIELDS_0100100, currentPosition);
                        finalData.put("송금이체, 지급이체", msgData);
                        break;
                    case "501":
                        msgData = parseFields(data, MsgDef.FIELDS_0100501, currentPosition);
                        finalData.put("출금이체, 집금이체", msgData);
                        break;
                    case "161":
                        msgData = parseFields(data, MsgDef.FIELDS_0100161, currentPosition);
                        finalData.put("자금반환청구", msgData);
                        break;
                }
                break;
            case "0400":
                if ("100".equals(businessCode)) {
                    msgData = parseFields(data, MsgDef.FIELDS_0400100, currentPosition);
                    finalData.put("타행 이체 불능 통지", msgData);
                }
                break;
            case "0600":
                    switch (businessCode) {
                        case "501":
                            msgData = parseFields(data, MsgDef.FIELDS_0600501, currentPosition);
                            finalData.put("출금이체 계좌등록/해지", msgData);
                            break;
                        case "601":
                            msgData = parseFields(data, MsgDef.FIELDS_0600601, currentPosition);
                            finalData.put("출금이체 계좌등록 증빙포함", msgData);
                            break;
                        case "101":
                            msgData = parseFields(data, MsgDef.FIELDS_0600101, currentPosition);
                            finalData.put("처리결과조회", msgData);
                            break;
                        case "300":
                            msgData = parseFields(data, MsgDef.FIELDS_0600300, currentPosition);
                            finalData.put("잔액조회", msgData);
                            break;
                        case "400":
                            System.out.println(bankCode3);
                            if(bankCode3.trim().equals("099")||bankCode3.trim().equals("99")){
                                msgData = parseFields(data, MsgDef.FIELDS_0600400_2, currentPosition);
                                finalData.put("계좌 인증, FCS(Firmbanking Certification Service)", msgData);
                            }else {
                                msgData = parseFields(data, MsgDef.FIELDS_0600400, currentPosition);
                                finalData.put("계좌 조회, 예금주 조회, 성명 조회", msgData);
                            }
                            break;
                    }
                break;
            case "0700":
                if ("100".equals(businessCode)) {
                    msgData = parseFields(data, MsgDef.FIELDS_0700100, currentPosition);
                    finalData.put("집계 조회", msgData);
                }
                break;
            case "0200":
                if ("300".equals(businessCode)) {
                    msgData = parseFields(data, MsgDef.FIELDS_0200300, currentPosition);
                    finalData.put("거래내역/가상계좌 통지", msgData);
                }
                break;
            case "0900":
                if ("100".equals(businessCode)) {
                    msgData = parseFields(data, MsgDef.FIELDS_0900100, currentPosition);
                    finalData.put("가상계좌 수취확인", msgData);
                }
                break;
            default:
                // 다른 케이스 처리 필요 시 추가
                break;
        }

        // Gson을 사용하여 JSON 문자열 생성
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(finalData);

        // JSON 출력
        System.out.println(jsonString);

        return jsonString;
    }

    public String JsonToMsg(String svc_type, String JsonData) {
        System.out.println(JsonData);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;

        try {
            jsonNode = objectMapper.readTree(JsonData);

            // Convert JSON to String
            StringBuilder stringBuilder = new StringBuilder();

            // Parse 공통부
            parseJsonNode(jsonNode, "공통부", stringBuilder);

            // Parse service-specific nodes
            switch (svc_type) {
                case "WON":
                    parseJsonNode(jsonNode, "송금이체, 지급이체", stringBuilder);
                    break;
                case "FCS":
                    parseJsonNode(jsonNode, "계좌 조회, 예금주 조회, 성명 조회", stringBuilder);
                    break;
                default:
                    return "지원되지 않는 서비스 타입: " + svc_type;
            }

            // Output the result string
            String resultString = stringBuilder.toString();
            System.out.println(resultString);
            return resultString;

        } catch (JsonProcessingException e) {
            return "JSON 처리 중 오류 발생: " + e.getMessage();
        }
    }

    public String TradeInsertJson(String svc_type, String jsonData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonData);
        String REQ_DATE = "";
        String REQ_TIME = "";
        String BANK_CODE = "";
        String COMP_CODE = "";
        String SEQ_NUMB = "";
        String MSG_CODE = "";
        String SEND_FLAG = "";
        String RECV_FLAG = "";
        String SEND_MSG = "";
        switch (svc_type) {
            case "WON":
            case "FCS":
                JsonNode commonPartNode = rootNode.path("공통부");
                String msg_code = commonPartNode.path("메시지코드").asText().trim();
                String business_code = commonPartNode.path("업무구분코드").asText().trim();
                REQ_DATE = commonPartNode.path("전송일자").asText().trim();
                REQ_TIME = commonPartNode.path("전송시간").asText().trim();
                BANK_CODE = commonPartNode.path("은행코드3").asText().trim();
                if(svc_type.equals("FCS") && BANK_CODE.equals("99")){ BANK_CODE="099"; }
                COMP_CODE = commonPartNode.path("업체코드").asText().trim();
                SEQ_NUMB = commonPartNode.path("전문번호").asText().trim();
                MSG_CODE = msg_code+business_code;
                SEND_FLAG = "N";
                RECV_FLAG = "N";
                SEND_MSG = JsonToMsg2(svc_type,MSG_CODE,jsonData);
                break;
            default:
                return "지원되지 않는 서비스 타입: " + svc_type;
        }
        String sql = "INSERT INTO HYPHEN_TRADE_REQUEST (SEQ_NUMB, BANK_CODE, COMP_CODE, MSG_CODE, PRF_FILE_PATH, RECV_DATE, RECV_FLAG, RECV_MSG, RECV_TIME, REQ_DATE, REQ_TIME, SEND_DATE, SEND_FLAG, SEND_MSG, SEND_TIME, STATUS_MSG, SVC_TYPE) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, SEQ_NUMB, BANK_CODE, COMP_CODE, MSG_CODE, "", "", "", "", "", REQ_DATE, REQ_TIME, REQ_DATE, SEND_FLAG, SEND_MSG, REQ_TIME, "", svc_type);
        return "Success";
    }

    public String TRADE_REQUEST_INSERT(TradeRequestDto request) {
        String sql = "INSERT INTO HYPHEN_TRADE_REQUEST (SEQ_NUMB, BANK_CODE, COMP_CODE, MSG_CODE, PRF_FILE_PATH, RECV_DATE, RECV_FLAG, RECV_MSG, RECV_TIME, REQ_DATE, REQ_TIME, SEND_DATE, SEND_FLAG, SEND_MSG, SEND_TIME, STATUS_MSG, SVC_TYPE) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, request.getSeqNumb(), request.getBankCode(), request.getCompCode(), request.getMsgCode(), request.getPrfFilePath(), request.getRecvDate(), request.getRecvFlag(), request.getRecvMsg(), request.getRecvTime(), request.getReqDate(), request.getReqTime(), request.getSendDate(), request.getSendFlag(), request.getSendMsg(), request.getSendTime(), request.getStatusMsg(), request.getSvcType());
        return "Success";
    }

    private Map<String, String> parseFields(String data, List<FieldDefinition> fields, int startPosition) {
        Map<String, String> parsedData = new LinkedHashMap<>();
        int currentPosition = startPosition;

        for (FieldDefinition field : fields) {
            if (field.isVariableLength()) {
                // 가변 길이 필드 처리
                int variableLength = Integer.parseInt(parsedData.get("증빙자료크기"));
                parsedData.put(field.getFieldName(), data.substring(currentPosition, currentPosition + variableLength));
                currentPosition += variableLength;
            } else {
                if (currentPosition + field.getLength() <= data.length()) {
                    parsedData.put(field.getFieldName(), data.substring(currentPosition, currentPosition + field.getLength()));
                    currentPosition += field.getLength();
                } else {
                    parsedData.put(field.getFieldName(), data.substring(currentPosition));
                    break;
                }
            }
        }
        return parsedData;
    }

    private int getCurrentPosition(Map<String, String> parsedData) {
        int position = 0;
        for (FieldDefinition field : MsgDef.COMMON_FIELDS) {
            position += field.getLength();
        }
        return position;
    }

    private void parseJsonNode(JsonNode parentNode, String nodeName, StringBuilder stringBuilder) {
        JsonNode node = parentNode.get(nodeName);
        if (node != null) {
            node.fields().forEachRemaining(field -> {
                String value = field.getValue().asText();
                stringBuilder.append(value);
            });
        }
    }

    private String JsonToMsg2(String svc_type, String msg_code, String jsonData) throws JsonProcessingException {
        String resultMsg ="";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonData);
        List<FieldDefinition> fields = null;
        StringBuilder commonResult = new StringBuilder();
        JsonNode childNode = null;
        StringBuilder childResult = new StringBuilder();

        switch (svc_type){
            case "WON":
            case "FCS":
                JsonNode commonPartNode = rootNode.path("공통부");
                // 공통부 데이터 파싱
                // 필드와 길이를 관리하는 리스트
                fields = MsgDef.COMMON_FIELDS;
                // 공통부 데이터 파싱 및 패딩 처리
                for (FieldDefinition field : fields) {
                    String value = commonPartNode.path(field.getFieldName()).asText();
                    commonResult.append(padRight(value, field.getLength()));
                }
                switch (msg_code){
                    case "0100100":
                        fields = MsgDef.FIELDS_0100100;
                        childNode = rootNode.path("송금이체, 지급이체");
                        break;
                    case "0100501":
                        fields = MsgDef.FIELDS_0100100;
                        childNode = rootNode.path("출금이체, 집금이체");
                        break;
                    case "0100161":
                        fields = MsgDef.FIELDS_0100161;
                        childNode = rootNode.path("자금반환청구");
                        break;
                    case "0400100":
                        fields = MsgDef.FIELDS_0400100;
                        childNode = rootNode.path("타행 이체 불능 통지");
                        break;
                    case "0600501":
                        fields = MsgDef.FIELDS_0600501;
                        childNode = rootNode.path("출금이체 계좌등록/해지");
                        break;
                    case "0600601":
                        fields = MsgDef.FIELDS_0600601;
                        childNode = rootNode.path("출금이체 계좌등록 증빙포함");
                        break;
                    case "0600101":
                        fields = MsgDef.FIELDS_0600101;
                        childNode = rootNode.path("처리결과조회");
                        break;
                    case "0600300":
                        fields = MsgDef.FIELDS_0600300;
                        childNode = rootNode.path("잔액조회");
                        break;
                    case "0700100":
                        fields = MsgDef.FIELDS_0700100;
                        childNode = rootNode.path("집계 조회");
                        break;
                    case "0200300":
                        fields = MsgDef.FIELDS_0200300;
                        childNode = rootNode.path("거래내역/가상계좌 통지");
                        break;
                    case "0900100":
                        fields = MsgDef.FIELDS_0900100;
                        childNode = rootNode.path("가상계좌 수취확인");
                        break;
                    case "0600400":
                        fields = MsgDef.FIELDS_0600400;
                        childNode = rootNode.path("계좌 조회, 예금주 조회, 성명 조회");
                        if(childNode == null){
                            childNode = rootNode.path("계좌 인증, FCS(Firmbanking Certification Service)");
                            fields = MsgDef.FIELDS_0600400_2;
                        }
                        break;
                    default:
                        break;
                }
                for (FieldDefinition field : Objects.requireNonNull(fields)) {
                    String value = Objects.requireNonNull(childNode).path(field.getFieldName()).asText();
                    childResult.append(padRight(value, field.getLength()));
                }
                resultMsg = commonResult + childResult.toString();
                break;

        }
        System.out.println(resultMsg);

        return resultMsg;
    }

    private String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
