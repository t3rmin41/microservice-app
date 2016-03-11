package com.simple.car.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.simple.entity.vehicle.Car;

@Repository
public class CarJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Car> carRowMapper = new RowMapper<Car>() {
        public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
            Car car = new Car();
            car.setId(rs.getLong("car_id"));
            car.setModel((rs.getString("model")));
            car.setManufacturer((rs.getString("manufacturer")));
            car.setPrice((rs.getDouble("price")));
            return car;
        }
    };
    
    public List<Car> getAllCars() {
        List<Car> cars = jdbcTemplate.query("SELECT car_id, model, manufacturer, price " +
                                            "FROM cars", carRowMapper);
        return cars;
    }
    
    public Long createCar(Car car) {
        return getJdbcCreatedId(car);
    }
    
    public Car getCarById(Long carId) {
      return jdbcTemplate.queryForObject(
              "SELECT car_id, model, manufacturer, price " +
              "FROM cars " + 
              "WHERE car_id = ?"
              , new Object[] { carId }, carRowMapper);
    }
    
    public Car getCarPartialData(Car car) {
        return jdbcTemplate.queryForObject("SELECT car_id, model, manufacturer, price " + 
                "FROM cars " +
                "WHERE car_id = ? " +
                "AND model = ?"
                , new Object[]{car.getId(), car.getModel()}, carRowMapper);
    }
    
    private Long getJdbcCreatedId(Car car) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement("INSERT INTO cars " + 
                                                                               "(model, manufacturer, price) VALUES " + 
                                                                               "(?, ?, ?)", new String[] {"car_id"});
                            ps.setString(1, car.getModel());
                            ps.setString(2, car.getManufacturer());
                            ps.setDouble(3, car.getPrice());
                            return ps;
                        }
                    }, keyHolder);
        return keyHolder.getKey().longValue();
    }
    
}
