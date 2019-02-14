package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IOrderMethodService {
	Integer saveOrderMethod(OrderMethod ordermethod);

	void updateOrderMethod(OrderMethod ordermethod);

	void deleteOrderMethod(Integer id);

	OrderMethod getOneOrderMethod(Integer id);

	List<OrderMethod> getAllOrderMethods();

	List<OrderMethod> getOrderMethodsByMode(String mode);
	
	
	
	
	
	
	
	
	
}
