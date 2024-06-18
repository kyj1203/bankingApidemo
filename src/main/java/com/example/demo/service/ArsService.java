package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class ArsService {

    public String callArsApi(String apiUrl,String JSONData) {
        HttpURLConnection connection = null;
        try {
            // URL 인코딩된 데이터 생성
            String urlEncodedData = URLEncoder.encode("JSONData", StandardCharsets.UTF_8) + "=" + URLEncoder.encode(JSONData, StandardCharsets.UTF_8);

            // URL 객체 생성
            URL url = new URL(apiUrl);
            // HttpURLConnection 객체 생성
            connection = (HttpURLConnection) url.openConnection();
            // 요청 방식 설정
            connection.setRequestMethod("POST");
            // 요청 헤더 설정
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            System.out.println(urlEncodedData);
            // URL 인코딩된 데이터 전송
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = urlEncodedData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 응답 코드 확인
            int code = connection.getResponseCode();
            System.out.println("Response Code: " + code); // 응답 코드 출력
            InputStream is = (code < 200 || code >= 300) ? connection.getErrorStream() : connection.getInputStream();

            // 응답 데이터 읽기
            try(BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response: " + response.toString());
                return response.toString();
            }
        } catch (Exception e) {
            System.out.println("Exception Message: " + e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
