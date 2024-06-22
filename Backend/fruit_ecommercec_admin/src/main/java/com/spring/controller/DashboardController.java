package com.spring.controller;

import com.spring.model.Orders;
import com.spring.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {
    @Autowired
    private DashboardService service;
    @GetMapping(value = "/")
    public String dashboard(Model model, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month){
        if(year == null || month == null){
            year = Calendar.getInstance().get(Calendar.YEAR);
            month = Calendar.getInstance().get(Calendar.MONTH)+1;
        }
        List<Map<String,Object>> listRevenueDay = service.getRevenueByDay(year, month);
        List<Map<String,Object>> listRevenueMonth = service.getRevenueByMonth();
        List<Map<String,Object>> listRevenueYear = service.getRevenueByYear();
        Map<String,Object> revenueToday = service.getRevenueToday();
        model.addAttribute("listRevenueDay", listRevenueDay);
        model.addAttribute("listRevenueMonth", listRevenueMonth);
        model.addAttribute("listRevenueYear", listRevenueYear);
        model.addAttribute("revenueToday", revenueToday);

        return "admin/dashboard";
    }
}
