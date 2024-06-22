package com.spring.dao;

import com.spring.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class DashboardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getRevenueByDay(int year, int month ){
        String sql = "Select createDay, count(id) as SoLuongDonHang, SUM(total_price) as DoanhThu from orders where YEAR(createDay) = ? and MONTH(createDay) = ? GROUP BY createDay ORDER BY createDay";

        return jdbcTemplate.queryForList(sql, year, month);
    }
    public List<Map<String, Object>> getRevenueByMonth(){
        String sql = "Select YEAR(createDay) as Nam, MONTH(createDay) Thang, count(id) as SoLuongDonHang, SUM(total_price) as DoanhThu from orders GROUP BY YEAR(createDay), MONTH(createDay) ORDER BY Nam DESC, Thang";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String, Object>> getRevenueByYear(){
        String sql = "Select YEAR(createDay) as Nam, count(id) as SoLuongDonHang, SUM(total_price) as DoanhThu from orders GROUP BY YEAR(createDay) ORDER BY Nam DESC";
        return jdbcTemplate.queryForList(sql);
    }
    public Map<String, Object> getRevenueToday(){
        String sql = "Select createDay, count(id) as SoLuongDonHang, SUM(total_price) as DoanhThu from orders WHERE createDay = CURRENT_DATE() GROUP BY createDay";
        return jdbcTemplate.queryForMap(sql);
    }
}
