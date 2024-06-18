package com.example.demo.Util;
import java.util.Arrays;
import java.util.List;

public class MsgDef {

    public static final List<FieldDefinition> COMMON_FIELDS = Arrays.asList(
            new FieldDefinition("식별코드", 9),
            new FieldDefinition("업체코드", 8),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("메시지코드", 4),
            new FieldDefinition("업무구분코드", 3),
            new FieldDefinition("송신횟수", 1),
            new FieldDefinition("전문번호", 6),
            new FieldDefinition("전송일자", 8),
            new FieldDefinition("전송시간", 6),
            new FieldDefinition("응답코드", 4),
            new FieldDefinition("은행 응답코드", 4),
            new FieldDefinition("조회일자", 8),
            new FieldDefinition("조회번호", 6),
            new FieldDefinition("은행전문번호", 15),
            new FieldDefinition("은행코드3", 3),
            new FieldDefinition("예비", 13)
    );

    public static final List<FieldDefinition> FIELDS_0100100 = Arrays.asList(
            new FieldDefinition("출금 계좌번호", 15),
            new FieldDefinition("통장 비밀번호", 8),
            new FieldDefinition("복기부호", 6),
            new FieldDefinition("출금 금액", 13),
            new FieldDefinition("출금 후 잔액 부호", 1),
            new FieldDefinition("출금 후 잔액", 13),
            new FieldDefinition("입금 은행코드2", 2),
            new FieldDefinition("입금 계좌번호", 15),
            new FieldDefinition("수수료", 9),
            new FieldDefinition("이체 시각", 6),
            new FieldDefinition("입금 계좌 적요", 20),
            new FieldDefinition("CMS코드", 16),
            new FieldDefinition("신원확인번호", 13),
            new FieldDefinition("자동이체 구분", 2),
            new FieldDefinition("출금 계좌 적요", 20),
            new FieldDefinition("입금 은행코드3", 3),
            new FieldDefinition("급여 구분", 1),
            new FieldDefinition("수수료면제구분", 1),
            new FieldDefinition("예비", 36)
    );

    public static final List<FieldDefinition> FIELDS_0400100 = Arrays.asList(
            new FieldDefinition("원거래 전문번호", 6),
            new FieldDefinition("출금 계좌번호", 15),
            new FieldDefinition("입금 계좌번호", 15),
            new FieldDefinition("출금 금액", 13),
            new FieldDefinition("입금 은행코드2", 2),
            new FieldDefinition("정상 처리 금액", 13),
            new FieldDefinition("처리 불능 금액", 13),
            new FieldDefinition("불능 처리 건수", 2),
            new FieldDefinition("불능 처리 번호", 2),
            new FieldDefinition("타행 전문 번호", 6),
            new FieldDefinition("타행 코드", 9),
            new FieldDefinition("에러 코드", 3),
            new FieldDefinition("입금 은행코드3", 3),
            new FieldDefinition("예비", 98)
    );

    public static final List<FieldDefinition> FIELDS_0600501 = Arrays.asList(
            new FieldDefinition("식별코드", 1),
            new FieldDefinition("처리순번", 7),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("계좌번호", 16),
            new FieldDefinition("신청구분", 1),
            new FieldDefinition("자동납부일자", 2),
            new FieldDefinition("취급점코드6", 6),
            new FieldDefinition("신청일자", 8),
            new FieldDefinition("처리여부", 1),
            new FieldDefinition("불능코드", 4),
            new FieldDefinition("신원확인번호 체크", 1),
            new FieldDefinition("신원확인번호", 13),
            new FieldDefinition("납부자번호", 20),
            new FieldDefinition("업체/은행 사용정보", 16),
            new FieldDefinition("기관코드", 10),
            new FieldDefinition("은행코드3", 3),
            new FieldDefinition("취급점코드7", 7),
            new FieldDefinition("일부면제 업체구분", 1),
            new FieldDefinition("이용기관코드", 20),
            new FieldDefinition("예금주실명번호등록", 1),
            new FieldDefinition("동의자료구분", 1),
            new FieldDefinition("예비", 35),
            new FieldDefinition("ARS처리일련번호", 12),
            new FieldDefinition("예비2", 12)
    );

    public static final List<FieldDefinition> FIELDS_0600601 = Arrays.asList(
            new FieldDefinition("식별코드", 1),
            new FieldDefinition("처리순번", 7),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("계좌번호", 16),
            new FieldDefinition("신청구분", 1),
            new FieldDefinition("자동납부일자", 2),
            new FieldDefinition("취급점코드6", 6),
            new FieldDefinition("신청일자", 8),
            new FieldDefinition("처리여부", 1),
            new FieldDefinition("불능코드", 4),
            new FieldDefinition("신원확인번호 체크", 1),
            new FieldDefinition("신원확인번호", 13),
            new FieldDefinition("납부자번호", 20),
            new FieldDefinition("업체/은행 사용정보", 16),
            new FieldDefinition("기관코드", 10),
            new FieldDefinition("은행코드3", 3),
            new FieldDefinition("취급점코드7", 7),
            new FieldDefinition("이용기관코드", 20),
            new FieldDefinition("예금주실명번호 종류", 1),
            new FieldDefinition("동의자료구분", 1),
            new FieldDefinition("확장자명", 4),
            new FieldDefinition("증빙자료크기", 7),
            new FieldDefinition("예비", 49),
            new FieldDefinition("증빙자료", 0, true)
    );

    public static final List<FieldDefinition> FIELDS_0100501 = Arrays.asList(
            new FieldDefinition("출금 계좌번호", 15),
            new FieldDefinition("통장 비밀번호", 8),
            new FieldDefinition("복기부호", 6),
            new FieldDefinition("입금 금액", 13),
            new FieldDefinition("입금 후 잔액부호", 1),
            new FieldDefinition("입금 후 잔액", 13),
            new FieldDefinition("출금 은행코드2", 2),
            new FieldDefinition("입금 계좌번호", 15),
            new FieldDefinition("수수료", 9),
            new FieldDefinition("이체시각", 6),
            new FieldDefinition("출금 통장 적요", 20),
            new FieldDefinition("신원확인번호", 13),
            new FieldDefinition("자동이체구분", 2),
            new FieldDefinition("입금 통장 적요", 20),
            new FieldDefinition("납부자번호", 20),
            new FieldDefinition("기관코드", 10),
            new FieldDefinition("출금 은행코드3", 3),
            new FieldDefinition("제로페이 구분", 2),
            new FieldDefinition("예비", 22)
    );

    public static final List<FieldDefinition> FIELDS_0600101 = Arrays.asList(
            new FieldDefinition("원거래 전문번호", 6),
            new FieldDefinition("출금 계좌번호", 15),
            new FieldDefinition("입금 계좌번호", 15),
            new FieldDefinition("금액", 13),
            new FieldDefinition("수수료", 9),
            new FieldDefinition("지급번호", 15),
            new FieldDefinition("이체시각", 6),
            new FieldDefinition("처리결과", 4),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("납부자번호", 20),
            new FieldDefinition("거래구분", 2),
            new FieldDefinition("은행코드3", 3),
            new FieldDefinition("제로페이 구분", 2),
            new FieldDefinition("예비", 88)
    );

    public static final List<FieldDefinition> FIELDS_0600300 = Arrays.asList(
            new FieldDefinition("계좌번호", 15),
            new FieldDefinition("잔액 부호", 1),
            new FieldDefinition("계좌 잔액", 13),
            new FieldDefinition("잔액-자가앞", 13),
            new FieldDefinition("잔액-가계", 13),
            new FieldDefinition("잔액-일반", 13),
            new FieldDefinition("지급 가능 금액", 13),
            new FieldDefinition("예비", 119)
    );

    public static final List<FieldDefinition> FIELDS_0600400 = Arrays.asList(
            new FieldDefinition("거래 일자", 4),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("계좌번호", 16),
            new FieldDefinition("예금주명", 22),
            new FieldDefinition("신원확인번호", 13),
            new FieldDefinition("신원확인번호 체크", 2),
            new FieldDefinition("업체 계좌번호", 20),
            new FieldDefinition("은행코드3", 3),
            new FieldDefinition("금액", 13),
            new FieldDefinition("닷컴통장 조회", 1),
            new FieldDefinition("당타행인증유형", 1),
            new FieldDefinition("농협계좌구분", 1),
            new FieldDefinition("계좌고정여부", 1),
            new FieldDefinition("계좌상태", 1),
            new FieldDefinition("계좌상태일지", 8),
            new FieldDefinition("예비", 92)
    );

    public static final List<FieldDefinition> FIELDS_0600400_2 = Arrays.asList(
            new FieldDefinition("거래 일자", 4),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("계좌번호", 16),
            new FieldDefinition("예금주명", 22),
            new FieldDefinition("신원확인번호", 13),
            new FieldDefinition("신원확인번호 체크", 2),
            new FieldDefinition("업체 계좌번호", 20),
            new FieldDefinition("은행코드3", 3),
            new FieldDefinition("금액", 13),
            new FieldDefinition("닫힐통장 조회", 1),
            new FieldDefinition("닫힐통장 응유형", 1),
            new FieldDefinition("농협계좌 구분", 1),
            new FieldDefinition("예비", 102)
    );

    public static final List<FieldDefinition> FIELDS_0700100 = Arrays.asList(
            new FieldDefinition("계좌번호", 15),
            new FieldDefinition("당행이체 의뢰 건수", 5),
            new FieldDefinition("당행이체 의뢰 금액", 13),
            new FieldDefinition("당행이체 정상 건수", 5),
            new FieldDefinition("당행이체 정상 금액", 13),
            new FieldDefinition("당행이체 불능 건수", 5),
            new FieldDefinition("당행이체 불능 금액", 13),
            new FieldDefinition("수수료", 9),
            new FieldDefinition("타행이체 의뢰 건수", 5),
            new FieldDefinition("타행이체 의뢰 금액", 13),
            new FieldDefinition("타행이체 정상 건수", 5),
            new FieldDefinition("타행이체 정상 금액", 13),
            new FieldDefinition("타행이체 불능 건수", 5),
            new FieldDefinition("타행이체 불능 금액", 13),
            new FieldDefinition("타행이체 수수료", 9),
            new FieldDefinition("처리 구분", 2),
            new FieldDefinition("예비", 57)
    );

    public static final List<FieldDefinition> FIELDS_0200300 = Arrays.asList(
            new FieldDefinition("계좌번호", 15),
            new FieldDefinition("조립건수", 2),
            new FieldDefinition("거래구분", 2),
            new FieldDefinition("은행코드2", 2),
            new FieldDefinition("금액", 13),
            new FieldDefinition("잔액", 13),
            new FieldDefinition("입금지점코드6", 6),
            new FieldDefinition("적요", 14),
            new FieldDefinition("수표번호", 10),
            new FieldDefinition("현금", 13),
            new FieldDefinition("타행수표금액", 13),
            new FieldDefinition("가계수표, 기타금액", 13),
            new FieldDefinition("가상계좌번호", 16),
            new FieldDefinition("거래일자", 8),
            new FieldDefinition("거래시간", 6),
            new FieldDefinition("통장거래 일련번호", 6),
            new FieldDefinition("거래은행코드3", 3),
            new FieldDefinition("입금지점코드7", 7),
            new FieldDefinition("예비", 38)
    );

    public static final List<FieldDefinition> FIELDS_0900100 = Arrays.asList(
            new FieldDefinition("가상계좌번호", 16),
            new FieldDefinition("업체명", 30),
            new FieldDefinition("은행코드", 2),
            new FieldDefinition("시작일자", 8),
            new FieldDefinition("종료일자", 8),
            new FieldDefinition("종료시간", 6),
            new FieldDefinition("입금금액", 13),
            new FieldDefinition("구분코드", 2),
            new FieldDefinition("거래종류", 2),
            new FieldDefinition("입금인명", 20),
            new FieldDefinition("은행코드3자리", 3),
            new FieldDefinition("예비", 90)
    );

    public static final List<FieldDefinition> FIELDS_0100161 = Arrays.asList(
            new FieldDefinition("원거래일자", 8),
            new FieldDefinition("원거래전문번호", 6),
            new FieldDefinition("지급계좌", 15),
            new FieldDefinition("입금은행코드", 3),
            new FieldDefinition("입금계좌", 15),
            new FieldDefinition("거래금액", 13),
            new FieldDefinition("반환금액", 13),
            new FieldDefinition("반환계좌", 15),
            new FieldDefinition("거래고유번호", 13),
            new FieldDefinition("반환사유코드", 2),
            new FieldDefinition("반환(거절) 상세사유", 50),
            new FieldDefinition("연락처 전화번호", 15),
            new FieldDefinition("반환(거절)일자", 8),
            new FieldDefinition("금결원응답코드", 3),
            new FieldDefinition("진행상태", 2),
            new FieldDefinition("예비", 19)
    );
}
