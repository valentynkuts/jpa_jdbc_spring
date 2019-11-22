package com.example.demo.auto_JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auto_jdbc")
public class AutoController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public Auto getCarById(@PathVariable Long id) {
        return jdbcTemplate.queryForObject("SELECT id, marka, registration FROM auto WHERE id = ?",
                new Object[]{id}, (rs, rowNum) ->
                        new Auto(rs.getLong("id"), rs.getString("marka"),
                                rs.getString("registration")));
    }

    @GetMapping(value = "/marka/{marka}", produces = "application/json")
    public Auto getCarByMarka(@PathVariable String marka) {
        return jdbcTemplate.queryForObject("SELECT * FROM auto WHERE marka = ?",
                new Object[]{marka}, (rs, rowNum) ->
                        new Auto(rs.getLong("id"), rs.getString("marka"),
                                rs.getString("registration")));
    }

    @GetMapping(value = "/registration/{registration}", produces = "application/json")
    public Auto getCarByRegistration(@PathVariable String registration) {
        return jdbcTemplate.queryForObject("SELECT * FROM auto WHERE registration = ?",
                new Object[]{registration}, (rs, rowNum) ->
                        new Auto(rs.getLong("id"), rs.getString("marka"),
                                rs.getString("registration")));
    }

    @PostMapping
    public void addCar(@RequestBody Auto auto) {
        jdbcTemplate.update("INSERT INTO car (id,marka,registration) VALUES (?, ?, ?)", auto.getId(), auto.getMarka(), auto.getRegistration());
        // jdbcTemplate.update("INSERT INTO car(marka,registration) VALUES (?, ?)",auto.getMarka(), auto.getRegistration());

    }

    @PutMapping("/{id}")
    public void updateCar(@RequestBody Auto auto, @PathVariable Long id) {
        jdbcTemplate.update("UPDATE INTO car SET id = ?,marka = ?,registration = ? WHERE id = ?", auto.getId(), auto.getMarka(), auto.getRegistration(), id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        jdbcTemplate.update("DELETE FROM car WHERE id = ?", id);
    }

}
