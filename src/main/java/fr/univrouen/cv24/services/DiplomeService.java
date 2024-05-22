package fr.univrouen.cv24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DiplomeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertDiplome(String intitule, int niveau, Date date, String institut, int cvId) {
        String sql = "CALL insert_diplome(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, intitule, niveau, date, institut, cvId);
    }

    public void UpdateDiplomeId(int diplomes_id) {
        String sql = "CALL Upddate_ID(?)";
        jdbcTemplate.update(sql, diplomes_id);
    }
}