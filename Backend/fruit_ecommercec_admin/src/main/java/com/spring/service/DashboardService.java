package com.spring.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DashboardService {
    public List<Map<String, Object>> getRevenueByDay(int year, int month);
    public List<Map<String, Object>> getRevenueByMonth(int year);
    public List<Map<String, Object>> getRevenueByYear();
    public Map<String, Object> getRevenueToday();
}
