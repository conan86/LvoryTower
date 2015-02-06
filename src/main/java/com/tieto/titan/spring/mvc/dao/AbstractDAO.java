package com.tieto.titan.spring.mvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO {
	public abstract void setJdbcTemplate(JdbcTemplate  jdbcTemplate);
}
