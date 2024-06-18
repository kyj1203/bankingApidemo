package com.example.demo.service;

import com.example.demo.dto.retail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailService {

    private final ApiCallService apiService;
    private final String url = "https://fbapitest.hyphen.im/firmbk"; // Base URL

    @Autowired
    public RetailService(ApiCallService apiService) {
        this.apiService = apiService;
    }

    public String callRetailDepositApi(RetailDepositRequest request) {
        String apiUrl = url + "/rfb/retail/deposit";
        return apiService.callApi(apiUrl, request);
    }

    public String callRetailAccountNameApi(RetailAccountNameRequest request) {
        String apiUrl = url + "/rfb/retail/account/accountname";
        return apiService.callApi(apiUrl, request);
    }

    public String callRetailTransferApi(RetailTransferRequest request) {
        String apiUrl = url + "/rfb/retail/inquiry/transfer";
        return apiService.callApi(apiUrl, request);
    }

    public String callRetailRangeTransferApi(RetailRangeTransferRequest request) {
        String apiUrl = url + "/rfb/retail/inquiry/range/transfer";
        return apiService.callApi(apiUrl, request);
    }

    public String callRetailBalanceApi(RetailBalanceRequest request) {
        String apiUrl = url + "/rfb/retail/inquiry/balance";
        return apiService.callApi(apiUrl, request);
    }
}
