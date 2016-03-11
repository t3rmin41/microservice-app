package com.simple.bus.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.simple.entity.vehicle.Bus;
import com.simple.entity.vehicle.Car;

@Repository
public class BusJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private AtomicLong atomicId = new AtomicLong(1);
    //private MyLong atomicId = new MyLong();
    
    private RowMapper<Bus> busRowMapper = new RowMapper<Bus>() {
        public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bus bus = new Bus();
            bus.setId(rs.getLong("bus_id"));
            bus.setModel((rs.getString("model")));
            bus.setCapacity((rs.getLong("capacity")));
            return bus;
        }
    };
    
    public List<Bus> getAllBuses() {
        List<Bus> buses = jdbcTemplate.query("SELECT bus_id, model, capacity " +
                                             "FROM buses", busRowMapper);
        return buses;
    }
    
    public Long createBus(Bus bus, boolean insertToDb) {
        if (insertToDb) {
            return getJdbcCreatedId(bus);
        }
        return 0L;
    }
    
    private Long getJdbcCreatedId(Bus bus) {
        bus.setId(atomicId.incrementAndGet());
        jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement("INSERT INTO buses " + 
                                                                               "(bus_id, model, capacity) VALUES " + 
                                                                               "(?, ?, ?)");
                            ps.setString(1, bus.getId());
                            ps.setString(2, bus.getModel());
                            ps.setLong(3, bus.getCapacity());
                            return ps;
                        }
                    });
        return bus.getId();
    }
}

//class MyLong {
//  private Long id = 1L;
//  
//  public Long incrementAndGet() {
//      id = id + 1;
//      return id;
//  }
//}