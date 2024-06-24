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
    public String dashboard(Model model, @RequestParam(required = false) Integer year_1, @RequestParam(required = false) Integer month,@RequestParam(required = false) Integer year_2){
        if(year_1 == null || month == null){
            year_1 = Calendar.getInstance().get(Calendar.YEAR);
            model.addAttribute("selectedYear_1", year_1);
            model.addAttribute("selectedMonth", month);
            month = Calendar.getInstance().get(Calendar.MONTH)+1;
        }
        if(year_2 ==null){
            year_2 = Calendar.getInstance().get(Calendar.YEAR);
            model.addAttribute("selectedYear_2", year_2);
        }
        List<Map<String,Object>> listRevenueDay = service.getRevenueByDay(year_1, month);
        List<Map<String,Object>> listRevenueMonth = service.getRevenueByMonth(year_2);
        List<Map<String,Object>> listRevenueYear = service.getRevenueByYear();
        Map<String,Object> revenueToday = service.getRevenueToday();
        model.addAttribute("listRevenueDay", listRevenueDay);
        model.addAttribute("listRevenueMonth", listRevenueMonth);
        model.addAttribute("listRevenueYear", listRevenueYear);
        model.addAttribute("revenueToday", revenueToday);



        return "admin/dashboard";
    }
}
