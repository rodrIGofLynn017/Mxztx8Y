// 代码生成时间: 2025-10-02 16:39:47
package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
# FIXME: 处理边界情况
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
# 添加错误处理
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@Service
public class VisualizationChartService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    public String getChart(String chartUrl) {
        try {
            // 调用可视化图表库的API获取图表
            ResponseEntity<String> response = restTemplate.exchange(
                chartUrl, HttpMethod.GET, null, String.class
            );
            
            // 检查响应状态码
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to fetch chart data");
            }
            
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // 处理HTTP客户端错误异常
            throw new RuntimeException("HTTP client error: " + e.getMessage());
        } catch (RestClientException e) {
            // 处理其他REST客户端异常
            throw new RuntimeException("REST client error: " + e.getMessage());
        }
    }
}
