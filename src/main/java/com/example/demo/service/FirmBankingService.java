package com.example.demo.service;

import com.example.demo.dto.firmbanking.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmBankingService {

    private final ApiCallService apiService;
    private final String url = "https://fbapitest.hyphen.im/firmbk"; // Base URL

    @Autowired
    public FirmBankingService(ApiCallService apiService) {
        this.apiService = apiService;
    }

    public String callBankStartApi(FirmStartRequest request) {
        String apiUrl = url + "/rfb/bankstart";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankDepositApi(FirmDepositRequest request) {
        String apiUrl = url + "/rfb/deposit";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankWithdrawApi(FirmWithdrawRequest request) {
        String apiUrl = url + "/rfb/withdraw";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankRegiApi(FirmRegiRequest request) {
        String apiUrl = url + "/rfb/account/registration";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankAccountNameApi(FirmAccountNameRequest request) {
        String apiUrl = url + "/rfb/account/accountname";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankSummaryApi(FirmSummaryRequest request) {
        String apiUrl = url + "/rfb/inquiry/summary";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankTransferApi(FirmTransferRequest request) {
        String apiUrl = url + "/rfb/inquiry/transfer";
        return apiService.callApi(apiUrl, request);
    }

    public String callBankBalanceApi(FirmBalanceRequest request) {
        String apiUrl = url + "/rfb/inquiry/balance";
        return apiService.callApi(apiUrl, request);
    }
}
