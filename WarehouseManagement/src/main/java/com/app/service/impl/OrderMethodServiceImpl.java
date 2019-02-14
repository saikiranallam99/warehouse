package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;


@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	public Integer saveOrderMethod(OrderMethod ordermethod) {
		return dao.saveOrderMethod(ordermethod);
	}

	@Transactional
	public void updateOrderMethod(OrderMethod ordermethod) {
		dao.updateOrderMethod(ordermethod);
	}

	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}

	@Transactional(	readOnly = true	)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}

	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}
	
	
	@Transactional(readOnly = true)
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		return dao.getOrderMethodsByMode(mode);
	}
	
	
	
	
	
	
	
}
