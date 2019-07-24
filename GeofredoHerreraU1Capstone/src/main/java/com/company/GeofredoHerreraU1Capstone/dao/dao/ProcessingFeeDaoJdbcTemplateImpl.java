package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    private final String SELECT_PROCESSING_FEE_INDEX_SQL = "SELECT * FROM processing_fee WHERE product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_INDEX_SQL, this::mapRowToProcessingFee, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNumber) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
