package com.spring.service;

import com.spring.dao.DashboardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService{
    @Autowired
    private DashboardDao dao;
    @Override
    public List<Map<String, Object>> getRevenueByDay(int year, int month) {
        return dao.getRevenueByDay(year,month);
    }

    @Override
    public List<Map<String, Object>> getRevenueByMonth() {
        return dao.getRevenueByMonth();
    }

    @Override
    public List<Map<String, Object>> getRevenueByYear() {
        return dao.getRevenueByYear();
    }

    @Override
    public Map<String, Object> getRevenueToday() {
        return dao.getRevenueToday();
    }
}
