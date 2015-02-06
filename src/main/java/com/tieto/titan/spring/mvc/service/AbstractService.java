package com.tieto.titan.spring.mvc.service;

import com.tieto.titan.spring.mvc.dao.AbstractDAO;

public abstract class AbstractService {
	public abstract void setDAO(AbstractDAO dao);
}
