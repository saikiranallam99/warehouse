package com.app.dao;

import com.app.model.OrderMethod;
import java.lang.Integer;
import java.util.List;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IOrderMethodDao {
	Integer saveOrderMethod(OrderMethod ordermethod);

	void updateOrderMethod(OrderMethod ordermethod);

	void deleteOrderMethod(Integer id);

	OrderMethod getOneOrderMethod(Integer id);

	List<OrderMethod> getAllOrderMethods();
	
	List<OrderMethod> getOrderMethodsByMode(String mode);
}





